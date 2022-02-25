package org.jgrapht.demo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class RedBlackTree
{
    public Node root;
    public RedBlackTree()
    {
        super();
        root = null;
    }

    class Node
    {
        int data;
        Node left;
        Node right;
        char colour;
        Node parent;
 
        Node(int data)
        {
            super();
            this.data = data;   
            this.left = null; 
            this.right = null; 
            this.colour = 'R'; 
            this.parent = null; 
        }
    }

    Node rotateLeft(Node node)
    {
        Node x = node.right;
        Node y = x.left;
        x.left = node;
        node.right = y;
        node.parent = x; 
        if(y!=null)
            y.parent = node;
        return(x);
    }

    Node rotateRight(Node node)
    {
        Node x = node.left;
        Node y = x.right;
        x.right = node;
        node.left = y;
        node.parent = x;
        if(y!=null)
            y.parent = node;
        return(x);
    }

    boolean ll = false;
    boolean rr = false;
    boolean lr = false;
    boolean rl = false;

    Node insertHelp(Node root, int data)
    {
        boolean f=false;
        if(root==null)
            return(new Node(data));
        else if(data<root.data)
        {
            root.left = insertHelp(root.left, data);
            root.left.parent = root;
            if(root!=this.root)
            {
                if(root.colour=='R' && root.left.colour=='R')
                    f = true;
            }
        }
        else
        {
            root.right = insertHelp(root.right,data);
            root.right.parent = root;
            if(root!=this.root)
            {
                if(root.colour=='R' && root.right.colour=='R')
                    f = true;
            }
        }
        if(this.ll) 
        {
            root = rotateLeft(root);
            root.colour = 'B';
            root.left.colour = 'R';
            this.ll = false;
        }
        else if(this.rr) 
        {
            root = rotateRight(root);
            root.colour = 'B';
            root.right.colour = 'R';
            this.rr  = false;
        }
        else if(this.rl) 
        {
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            root.colour = 'B';
            root.left.colour = 'R';
 
            this.rl = false;
        }
        else if(this.lr)  
        {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.colour = 'B';
            root.right.colour = 'R';
            this.lr = false;
        }
        if(f)
        {
            if(root.parent.right == root)  
            {
                if(root.parent.left==null || root.parent.left.colour=='B')  
                {
                    if(root.left!=null && root.left.colour=='R')
                        this.rl = true;
                    else if(root.right!=null && root.right.colour=='R')
                        this.ll = true;
                }
                else 
                {
                    root.parent.left.colour = 'B';
                    root.colour = 'B';
                    if(root.parent!=this.root)
                        root.parent.colour = 'R';
                }
            }
            else  
            {
                if(root.parent.right==null || root.parent.right.colour=='B')
                {
                    if(root.left!=null && root.left.colour=='R')
                        this.rr = true;
                    else if(root.right!=null && root.right.colour=='R')
                        this.lr = true;
                }
                else
                {
                    root.parent.right.colour = 'B';
                    root.colour = 'B';
                    if(root.parent!=this.root)
                        root.parent.colour = 'R';
                }
            }
            f = false;
        }
        return(root); 
    }

    public void insert(int data)
    {
        if(this.root==null)
        {
            this.root = new Node(data);
            this.root.colour = 'B';
        }
        else
            this.root = insertHelp(this.root,data);
    }

    List<Integer> inorderTraversalHelper(Node node, List<Integer> a)
    {
        if(node!=null)
        {
            inorderTraversalHelper(node.left,a);
            a.add(node.data);
            inorderTraversalHelper(node.right,a);
        }
        return a;
    }
    List<Integer> preorderTraversalHelper(Node node, List<Integer> a)
    {
        if(node!=null)
        {
        	a.add(node.data);
            preorderTraversalHelper(node.left,a);
            preorderTraversalHelper(node.right,a);
        }
        return a;
    }
    List<Integer> postorderTraversalHelper(Node node, List<Integer> a)
    {
        if(node!=null)
        {
            postorderTraversalHelper(node.left,a);
            postorderTraversalHelper(node.right,a);
            a.add(node.data);
        }
        return a;
    }
    void inorderTraversalDraw(Node node, Graphics g, int x, int y, int grade, int src)
    {
        if(node!=null)
        {
        	{  
   			 g.setColor(Color.WHITE);
   			 if(node.data == src) {
   				g.setColor(Color.GREEN);
   			 }
   			 g.fillOval(x,y,40,40);
   			 g.setColor(Color.RED); 
   	         if (node.colour == 'B')  
   	        	 g.setColor(Color.BLACK);  
   	         g.drawOval(x,y,40,40);
   	         g.drawString(String.valueOf(node.data),x+20,y+26);
   	         if (node.left != null) {
   	        	 g.drawLine(x+10,y+26,x-grade*10-60,y+55);
   	         }
   	         if (node.right != null) {
   	        	 g.drawLine(x+30,y+26,x+grade*10+60,y+45);
   	         }
   	      inorderTraversalDraw(node.left,g, x-grade*10-60,y+45,grade-5,src);               
   	      inorderTraversalDraw(node.right,g, x+grade*10+60,y+45,grade-5,src);  
   	      }
        }
    }

    public List<Integer> inorderTraversal()
    {
    	List<Integer> a = new ArrayList<Integer>();
        return inorderTraversalHelper(this.root,a);
    }
    public List<Integer> preorderTraversal()
    {
    	List<Integer> a = new ArrayList<Integer>();
        return preorderTraversalHelper(this.root,a);
    }
    public List<Integer> postorderTraversal()
    {
    	List<Integer> a = new ArrayList<Integer>();
        return postorderTraversalHelper(this.root,a);
    }
    public void inorderDraw(Graphics g,int src)
    {
        inorderTraversalDraw(this.root,g,800,20,20,src);
    }
    int getMaxHelp (Node node) {
    	Node x = node;
    	while(x.right != null) {
    		x= x.right;	
    	}
    	return x.data;
    }
    public int getMax() {
    	return getMaxHelp(this.root);
    }
    int getMinHelp (Node node) {
    	Node x = node;
    	while(x.left != null) {
    		x= x.left;	
    	}
    	return x.data;
    }
    public int getMin() {
    	return getMinHelp(this.root);
    }
    Node searchHelp(Node a, int val) {
    	if(a!= null) {
    	if(a.data != val ) {
    		searchHelp(a.left,val);
    		searchHelp(a.right,val);
    	}
    	if(a.data== val) {
    	return a;
    	}
    	}
    	return null;
    }
    public Node search(int val) {
    	return searchHelp(this.root, val);
    }
    Node deleteHelp(Node root, int data)
    {
        boolean f=false;
        if(root==null)
            return(new Node(data));
        else if(data<root.data)
        {
            root.left = insertHelp(root.left, data);
            root.left.parent = root;
            if(root!=this.root)
            {
                if(root.colour=='R' && root.left.colour=='R')
                    f = true;
            }
        }
        else
        {
            root.right = insertHelp(root.right,data);
            root.right.parent = root;
            if(root!=this.root)
            {
                if(root.colour=='R' && root.right.colour=='R')
                    f = true;
            }
        }
        if(this.ll) 
        {
            root = rotateLeft(root);
            root.colour = 'B';
            root.left.colour = 'R';
            this.ll = false;
        }
        else if(this.rr) 
        {
            root = rotateRight(root);
            root.colour = 'B';
            root.right.colour = 'R';
            this.rr  = false;
        }
        else if(this.rl) 
        {
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            root.colour = 'B';
            root.left.colour = 'R';
 
            this.rl = false;
        }
        else if(this.lr)  
        {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.colour = 'B';
            root.right.colour = 'R';
            this.lr = false;
        }
        if(f)
        {
            if(root.parent.right == root)  
            {
                if(root.parent.left==null || root.parent.left.colour=='B')  
                {
                    if(root.left!=null && root.left.colour=='R')
                        this.rl = true;
                    else if(root.right!=null && root.right.colour=='R')
                        this.ll = true;
                }
                else 
                {
                    root.parent.left.colour = 'B';
                    root.colour = 'B';
                    if(root.parent!=this.root)
                        root.parent.colour = 'R';
                }
            }
            else  
            {
                if(root.parent.right==null || root.parent.right.colour=='B')
                {
                    if(root.left!=null && root.left.colour=='R')
                        this.rr = true;
                    else if(root.right!=null && root.right.colour=='R')
                        this.lr = true;
                }
                else
                {
                    root.parent.right.colour = 'B';
                    root.colour = 'B';
                    if(root.parent!=this.root)
                        root.parent.colour = 'R';
                }
            }
            f = false;
        }
        return(root); 
    }



       
}  

