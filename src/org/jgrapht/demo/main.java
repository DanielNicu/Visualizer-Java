package org.jgrapht.demo;

import javax.swing.JFrame;



class RedBlackTreeExample  
{  
    public static void main(String[] args)  
    {    
    	FF frame = new FF();
        frame.setTitle("Tree Visualizator");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}  