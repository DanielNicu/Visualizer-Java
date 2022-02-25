package org.jgrapht.demo;

import java.awt.Color;
import java.awt.Graphics;

class MinHeap {


    private int[] Heap;
    private int size;
    private int maxsize;
 

    private static final int FRONT = 1;
 
    
    MinHeap(int maxsize)
    {

        this.maxsize = maxsize;
        this.size = 0;
 
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }
    private int parent(int pos) { return pos / 2; }
    private int leftChild(int pos) { return (2 * pos); }
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 

    private boolean isLeaf(int pos)
    {
 
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
 
        return false;
    }
 

    private void swap(int fpos, int spos)
    {
 
        int tmp;
        tmp = Heap[fpos];
 
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 

    private void minHeapify(int pos)
    {
 
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)]
                || Heap[pos] > Heap[rightChild(pos)]) {
 
                if (Heap[leftChild(pos)]
                    < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
 
    public void insert(int element)
    {
 
        if (size >= maxsize) {
            return;
        }
 
        Heap[++size] = element;
        int current = size;
 
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
 
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(
                " PARENT : " + Heap[i]
                + " LEFT CHILD : " + Heap[2 * i]
                + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }
 
    public int remove()
    {
 
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
 
        return popped;
    }
    public void printDrawHelp(Graphics g, int x, int y, int grade, int src, int pos)
    {
    	if(pos<=size)
        {
        	{  
   			 g.setColor(Color.WHITE);
   			 if(Heap[pos] == src) {
   				g.setColor(Color.GREEN);
   			 }
   			 g.fillOval(x,y,40,40);
   			 g.setColor(Color.BLACK); 
   	         g.drawOval(x,y,40,40);
   	         g.drawString(String.valueOf(Heap[pos]),x+20,y+26);
   	         if (2*pos<=size) {
   	        	 g.drawLine(x+10,y+26,x-grade*10-60,y+55);
   	         }
   	         if (2*pos+1<=size) {
   	        	 g.drawLine(x+30,y+26,x+grade*10+60,y+45);
   	         }
   	      printDrawHelp(g, x-grade*10-60,y+45,grade-5,src,2*pos);               
   	      printDrawHelp(g, x+grade*10+60,y+45,grade-5,src,2*pos+1);  
   	      }
        }
    }
    public void printDraw(Graphics g,int src)
    {
        printDrawHelp(g,800,20,20,src,1);
    }

	public int[] getHeap() {
		return Heap;
	}

	public void setHeap(int[] heap) {
		Heap = heap;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
    public int getMax() {
    	int a = 0;
    	for (int i = 1 ; i <= size; i++) {
    		if(Heap[i]> a)
    			a=Heap[i];
    	}
    	return a;
    }
}