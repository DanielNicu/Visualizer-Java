package org.jgrapht.demo;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

public class FF extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Container container = getContentPane();
	JButton RBB = new JButton("Red Black Tree");
    JButton resetButton = new JButton("Min Heap");
    JButton kmp = new JButton("KMP");
    
    FF() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }
    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
       
        RBB.setBounds(1100, 600, 150, 30);
        resetButton.setBounds(400, 600, 100, 30);
        kmp.setBounds(675,600,100,30);

    }

    public void addComponentsToContainer() {
        container.add(RBB);
        container.add(resetButton);
        container.add(kmp);
    }

    public void addActionEvent() {
        RBB.addActionListener(this);
        resetButton.addActionListener(this);
        kmp.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RBB) {
        	List<Integer> arr= new ArrayList<Integer>();
        	RBT frame=new RBT(arr,0);
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	this.dispose();
        }
        if (e.getSource() == resetButton) {
        	List<Integer> arr= new ArrayList<Integer>();
        	HE frame=new HE(arr,0);
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	this.dispose();
        }
        if (e.getSource() == kmp) {
        	String p = (String)JOptionPane.showInputDialog(
                    this,
                    "Input the pattern",
                    "Pattern",
                    JOptionPane.PLAIN_MESSAGE);
        	String t = (String)JOptionPane.showInputDialog(
                    this,
                    "Input the file name",
                    "File name",
                    JOptionPane.PLAIN_MESSAGE);
        	KMP frame = null;
			try {
				frame = new KMP(p,t);
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	this.dispose();
        }
    }
}
