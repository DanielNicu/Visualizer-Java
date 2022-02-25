package org.jgrapht.demo;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;
class KMP extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton search = new JButton("Search");
	JTextField pp = new JTextField("Pattern");
	JTextField tt = new JTextField("File");
	public KMP(String a, String b) throws BadLocationException {
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		StyleContext sc = new StyleContext();
        final DefaultStyledDocument doc = new DefaultStyledDocument(sc);
        JTextPane pane = new JTextPane(doc);
        final Style redStyle = sc.addStyle("RED", null);
        redStyle.addAttribute(StyleConstants.Foreground, Color.red);
        redStyle.addAttribute(StyleConstants.FontSize, new Integer(16));
        final Style blackStyle = sc.addStyle("BLACK", null);
        blackStyle.addAttribute(StyleConstants.Foreground, Color.black);
        blackStyle.addAttribute(StyleConstants.FontSize, new Integer(16));
        try {
            File myObj = new File(b);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              List<Integer> arr = new ArrayList<Integer>();
              String data = myReader.nextLine();
              arr = KMPSearch(a,data,arr);
              for (int i = 0; i < data.length(); i++){
            	    char c = data.charAt(i);
            	    int start = pane.getText().length();
            	    Style style = blackStyle;
            	    for(Integer ll : arr) {
            	    	if(i>= ll && i<=ll+a.length()-1) {
            	    		style=redStyle;
            	    	}
            	    }
            	    	doc.insertString(start, String.valueOf(c) , style);
              }
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
		getContentPane().setLayout(null);
        JScrollPane scroll=new JScrollPane();
        scroll.setBounds(0,0,1500,600);
        getContentPane().add(scroll);
        scroll.setViewportView(pane);
        tt.setBounds(800,700,100,30);
        pp.setBounds(700,700,100,30);
        search.setBounds(900,700,100,30);
        search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == search ) {
					KMP frame = null;
					try {
						frame = new KMP(pp.getText(),tt.getText());
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        	dispose();
		        }
			}
        	
        });
        add(search);
        add(tt);
        add(pp);
        setVisible(true);
	}
	
	
	List<Integer> KMPSearch(String pat, String txt, List<Integer> arr)
   {
       int M = pat.length();
       int N = txt.length();
 

       int lps[] = new int[M];
       int j = 0; 
 
       computeLPSArray(pat, M, lps);
 
       int i = 0; 
       while (i < N) {
           if (pat.charAt(j) == txt.charAt(i)) {
               j++;
               i++;
           }
           if (j == M) {
               arr.add(i-j);
               j = lps[j - 1];
           }
           else if (i < N && pat.charAt(j) != txt.charAt(i)) {
               if (j != 0)
                   j = lps[j - 1];
               else
                   i = i + 1;
           }
       }
       return arr;
   }
 
   void computeLPSArray(String pat, int M, int lps[])
   {
       int len = 0;
       int i = 1;
       lps[0] = 0; 
       while (i < M) {
           if (pat.charAt(i) == pat.charAt(len)) {
               len++;
               lps[i] = len;
               i++;
           }
           else 
           {
               if (len != 0) {
                   len = lps[len - 1];
               }
               else 
               {
                   lps[i] = len;
                   i++;
               }
           }
       }
   }


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
