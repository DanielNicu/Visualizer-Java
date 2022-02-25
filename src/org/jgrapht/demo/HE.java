package org.jgrapht.demo;
import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
public class HE extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton rb = new JButton("Add");
    JButton delete = new JButton("Delete");
    JButton search = new JButton("Search");
    JButton inord = new JButton("SHOW");
    JButton minb = new JButton("MIN");
    JButton maxb = new JButton("MAX");
    JTextField tt = new JTextField();
    HE(List<Integer> arr, int src){
		setExtendedState(JFrame.MAXIMIZED_BOTH);  
		MinHeap obj = new MinHeap(100);
		for(int a: arr)
		{
			obj.insert(a);
		}
        Ceap c = new Ceap(obj,src);
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
		        	HE frame=new HE(arr,0);
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
		        	HE frame=new HE(arr,0);
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
		        	HE frame=new HE(arr,Integer.parseInt(tt.getText()));
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
					List<Integer> a = new ArrayList<Integer>();
					while(obj.getSize()!=0)
					{
						a.add(obj.remove());
					}
		        	JOptionPane.showInputDialog(this, a);
		        	HE frame=new HE(arr,0);
		        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        	dispose();
		        }
			}
        	
        });
        maxb.setBounds(700,730,100,30);
        maxb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == maxb ) 
				{
					int x = obj.getMax();
		        	HE frame=new HE(arr,x);
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
		        	HE frame=new HE(arr,obj.getHeap()[1]);
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
        add(maxb);
        add(minb);;
        setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
