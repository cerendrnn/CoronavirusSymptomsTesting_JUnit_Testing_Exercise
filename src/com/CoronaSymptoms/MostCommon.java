package com.CoronaSymptoms;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class MostCommon extends JPanel {
	
	public JFrame p;
	private JLabel common;
	private JLabel question1, question2, question3;
	private JRadioButton yes1 = new JRadioButton("YES");   
	private JRadioButton no1 = new JRadioButton("NO"); 
	private JRadioButton yes2 = new JRadioButton("YES");   
	private JRadioButton no2 = new JRadioButton("NO");  
	private JRadioButton yes3 = new JRadioButton("YES");   
	private JRadioButton no3 = new JRadioButton("NO");
	public int countYES = 0;
	public int countNO = 0;
	private JButton b;
	
	
	public MostCommon(Result r)
	{
		LessCommon lc = new LessCommon(r);
		p = new JFrame("Questions");
		common = new JLabel("MOST COMMON SYMPTOMS ",JLabel.CENTER);
		question1 = new JLabel("Do you have fever? ");
		question2 = new JLabel("Do you have persistent dry cough? ");
		question3 = new JLabel("Do you suffer from tiredness? ");
		common.setSize(new Dimension(1530,300));
		question1.setSize(new Dimension(1430,200));
		question1.setLocation(480,130);
		yes1.setSize(new Dimension(60,60));
		yes1.setLocation(465, 245);
		question2.setSize(new Dimension(1430,200));
		question2.setLocation(660,130);
		yes2.setSize(new Dimension(60,60));
		yes2.setLocation(685, 245);
		no2.setSize(new Dimension(60,60));
		no2.setLocation(765, 245);
		no1.setSize(new Dimension(60,60));
		no1.setLocation(550, 245);
		question3.setSize(new Dimension(1430,200));
		question3.setLocation(900,130);
		yes3.setSize(new Dimension(60,60));
		yes3.setLocation(885, 245);
		no3.setSize(new Dimension(60,60));
		no3.setLocation(965, 245);
		b = new JButton("CONTINUE CHECK");
		b.setSize(new Dimension(160,30));
		b.setEnabled(true);
		b.setLocation(680,415);
		common.setVisible(true);
		common.setFont(new Font("Calibri", Font.PLAIN, 18));
		yes1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		      countYES++;
		    }

		});
		yes2.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		      countYES++;
		    }

		});
		yes3.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		      countYES++;
		    }

		});
		no1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		      countNO++;
		    }

		});
		
		no2.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		      countNO++;
		    }

		});
		
		no3.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		      countNO++;
		    }

		});
		b.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		      boolean check1 = yes1.isSelected()||no1.isSelected();
		      boolean check2 = yes2.isSelected()||no2.isSelected();
		      boolean check3 = yes3.isSelected()||no3.isSelected();
		      if(isAllChecked(check1, check2, check3))
		      {
		    	  r.getMCdata(countYES);
		    	  p.getContentPane().removeAll();
		          p.repaint();
		    	  p.add(lc.getHeader());
		    	  int numQues = lc.getSizeQues();
		    	  JLabel[] quest = lc.getQuestions();
		    	  JRadioButton[] yes = lc.getYesButtons();
		    	  JRadioButton[] no = lc.getNoButtons();
		    	  
		    	  for(int i=0; i<numQues; i++)
		  		 {
		    		  p.add(quest[i]);
		    		  p.add(yes[i]);
		    		  p.add(no[i]);
		    		  no[i].addActionListener(new ActionListener(){
		    			    public void actionPerformed(ActionEvent e) {
		    			      lc.setNumNO();
		    			    }

		    			});
		    		  
		    		  yes[i].addActionListener(new ActionListener(){
		    			    public void actionPerformed(ActionEvent e) {
		    			      lc.setNumYes();
		    			    }

		    			});
		  		 }
		    	 
		    	 p.add(lc.getCont());
		    	 lc.sendFrame(p);
		    	 
		      }
		      else
		    	  JOptionPane.showMessageDialog(null, "Please answer all questions");
		     
		    }
		    
		});
		p.setContentPane(new JLabel(new ImageIcon("welcome.jpeg")));
		p.add(common);
		p.add(question1);
		p.add(yes1); p.add(no1);
		p.add(question2);
		p.add(yes2); p.add(no2);		
		p.add(question3);
		p.add(yes3); p.add(no3); p.add(b);
		setLayout(new FlowLayout());
		p.setVisible(true);
		p.setResizable(true);
		p.pack();
		p.setSize(1910,850);
	}
		
	
	public boolean isAllChecked(boolean check1, boolean check2, boolean check3)
	{
		if(check1 && check2 && check3)
		    return true;
		else
			return false;
	}
	
	public int countY()
	{
		return countYES;
	}
	
	
	
}
