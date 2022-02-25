package org.jgrapht.demo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Circle extends JPanel{
	private static final long serialVersionUID = 1L;
	RedBlackTree obj;
	int src;
	public Circle(RedBlackTree obj,int src) {
		super();
		this.obj=obj;
		this.src=src;
	}
	public void paint (Graphics g) {
		setSize(1600,600);
		obj.inorderDraw(g,src);
	}
	
}
