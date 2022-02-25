package org.jgrapht.demo;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Ceap extends JPanel{
	private static final long serialVersionUID = 1L;
	MinHeap obj;
	int src;
	public Ceap(MinHeap obj,int src) {
		super();
		this.obj=obj;
		this.src=src;
	}
	public void paint (Graphics g) {
		setSize(1600,600);
		obj.printDraw(g,src);
	}
}
