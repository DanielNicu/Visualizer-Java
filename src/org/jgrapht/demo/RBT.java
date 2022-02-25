package org.jgrapht.demo;


import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class RBT extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton rb = new JButton("Add");
    JButton delete = new JButton("Delete");
    JButton search = new JButton("Search");
    JButton inord = new JButton("INORDER");
    JButton preord = new JButton("PRE");
    JButton postord = new JButton("POST");
    JButton minb = new JButton("MIN");
    JButton maxb = new JButton("MAX");
    JTextField tt = new JTextField();
    
	public RBT(List<Integer> arr, int src){
		setExtendedState(JFrame.MAXIMIZED_BOTH);  
		RedBlackTree obj = new RedBlackTree();
		for(int a: arr)
		{
			obj.insert(a);
		}
        Circle c = new Circle(obj,src);
        getContentPane().setLayout(null);
        JScrollPane scroll=new JScrollPane();
        scroll.setBounds(0,0,1600,600);
        getContentPane().add(scroll);
        scroll.setViewportView(c);
        rb.setBounds(900,700,100,30);
        rb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == rb ) {
		        	arr.add(Integer.parseInt(tt.getText()));
		        	RBT frame=new RBT(arr,0);
		        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        	dispose();
		        }
			}
        	
        });
        delete.setBounds(800,700,100,30);
        delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == delete ) {
		        	arr.remove(new Integer(Integer.parseInt(tt.getText())));
		        	RBT frame=new RBT(arr,0);
		        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        	dispose();
		        }
			}
        	
        });
        search.setBounds(1000,700,100,30);
        search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == search ) {
		        	RBT frame=new RBT(arr,Integer.parseInt(tt.getText()));
		        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        	dispose();
		        }
			}
        	
        });
        inord.setBounds(600,700,100,30);
        inord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == inord ) {
		        	List<Integer> in = obj.inorderTraversal();
		        	JOptionPane.showInputDialog(this, in);
		        }
			}
        	
        });
        preord.setBounds(500,700,100,30);
        preord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == preord ) {
		        	List<Integer> in = obj.preorderTraversal();
		        	JOptionPane.showInputDialog(this, in);
		        }
			}
        	
        });
        postord.setBounds(400,700,100,30);
        postord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == postord ) {
		        	List<Integer> in = obj.postorderTraversal();
		        	JOptionPane.showInputDialog(this, in);
		        }
			}
        	
        });
        maxb.setBounds(700,730,100,30);
        maxb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == maxb ) {
					int a = obj.getMax();
		        	RBT frame=new RBT(arr,a);
		        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        	dispose();
		        }
			}
        	
        });
        minb.setBounds(600,730,100,30);
        minb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == minb ) {
					int a = obj.getMin();
		        	RBT frame=new RBT(arr,a);
		        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        	dispose();
		        }
			}
        	
        });
        
        
        tt.setBounds(700,700,100,30);
        add(rb);
        add(delete);
        add(search);
        add(tt);
        add(inord);
        add(preord);
        add(postord);
        add(maxb);
        add(minb);;
        setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}
