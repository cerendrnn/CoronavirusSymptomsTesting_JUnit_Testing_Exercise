package com.CoronaSymptoms;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LessCommon extends JPanel{
	
	private int size = 7;
	String[] symptomps = {"aches and pains", "sore throat","diarrhoea","conjunctivitis","headache","loss of taste or smell","a rash on skin, or discolouration of fingers or toes"};
	private JLabel lesCommon;
	private MostCommon mc = null;
	private JLabel[] symptompsLabel = new JLabel[size];
	private JRadioButton[] yesButton = new JRadioButton[size];
	private JRadioButton[] noButton = new JRadioButton[size];
	public int countYES = 0;
	public int countNO = 0;
	private JButton cont = new JButton("CONTINUE CHECK");
	public JFrame mainFrame = null;
				
	public LessCommon(Result r)
	{
		lesCommon = new JLabel("LESS COMMON SYMPTOMS ",JLabel.CENTER);
		lesCommon.setSize(new Dimension(1530,300));
		lesCommon.setFont(new Font("Calibri", Font.PLAIN, 18));
		int loc = 50;
		int xButton = 490;
		int yButton = 226;
		int yButton2 = 595;
		int yButton3 = 226;
		cont.setSize(new Dimension(160,30));
		cont.setLocation(650,655);
		
		for(int i=0; i<7; i++)
		{
			symptompsLabel[i] = new JLabel("Do you have " + symptomps[i] + "?");
			symptompsLabel[i].setSize(new Dimension(1430,200));
			yesButton[i] = new JRadioButton("YES");
			noButton[i] = new JRadioButton("NO");
			yesButton[i].setLocation(xButton, yButton);
			yesButton[i].setSize(new Dimension(60,20));			
			noButton[i].setLocation(yButton2, yButton3);
			noButton[i].setSize(new Dimension(60,20));
			
			loc = loc + 60;
			yButton = yButton + 62;
			yButton3 = yButton3 + 62;
			symptompsLabel[i].setLocation(440,loc);
		}
		
		cont.addActionListener(new ActionListener() {

			boolean[] check = new boolean[7];
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<7; i++)
				{
					check[i] = yesButton[i].isSelected()||noButton[i].isSelected();
				}
				if(allAnswered(check))
				{
					r.getLCdata(countYES);
					mainFrame.getContentPane().removeAll();
					mainFrame.repaint();
					SeriousSymptomps ss = new SeriousSymptomps(r);
			    	mainFrame.add(ss.getHeader());
			    	int numQues = ss.getSizeQues();
			    	JLabel[] questSS = ss.getQuestions();
			    	JRadioButton[] yesSS = ss.getYesButtons();
			        JRadioButton[] noSS = ss.getNoButtons();
			    	
			    	 for(int i=0; i<numQues; i++)
			  		 {
			    		  mainFrame.add(questSS[i]);
			    		  mainFrame.add(yesSS[i]);
			    		  mainFrame.add(noSS[i]);
			    		  noSS[i].addActionListener(new ActionListener(){
			    			    public void actionPerformed(ActionEvent e) {
			    			      ss.setNumNO();
			    			    }

			    			});
			    		  
			    		  yesSS[i].addActionListener(new ActionListener(){
			    			    public void actionPerformed(ActionEvent e) {
			    			      ss.setNumYes();
			    			    }

			    			});
			  		 }
			    	 mainFrame.add(ss.getCont());
			    	 ss.sendFrame(mainFrame);
				}
				else
					JOptionPane.showMessageDialog(null, "Please answer all questions");
				
			}
		
			
		});	
					
	}
	public void sendFrame(JFrame f)
	{
		mainFrame = f;
	}
	public JButton getCont()
	{
		return cont;
	}
	
	public JLabel getHeader()
	{
		return lesCommon;
	}
	
	public JLabel[] getQuestions()
	{
		return symptompsLabel;
	}
	
	public JRadioButton[] getYesButtons()
	{
		return yesButton;
	}
	
	public JRadioButton[] getNoButtons()
	{
		return noButton;
	}
	
	public int getSizeQues()
	{
		return size;
	}
	public void setNumYes()
	{
		countYES++;
	}
	
	public void setNumNO()
	{
		countNO++;
	}
	
	public boolean allAnswered(boolean[] buttons)
	{
		for(int i=0; i<7; i++)
		{
			if(buttons[i] == false)
				return false;
		}
		return true;
	}	
	
	
}
