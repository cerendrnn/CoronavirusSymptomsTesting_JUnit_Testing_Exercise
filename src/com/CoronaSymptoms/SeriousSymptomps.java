package com.CoronaSymptoms;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SeriousSymptomps {
	
	private MostCommon mC = null;
	private LessCommon l = null;
	private JLabel serious;
	private int ssize = 3;
	private Result r;
	String[] ser_symp = {"difficulty breathing or shortness of breath","chest pain or pressure", "loss of speech or movement"};
	private JLabel[] symptompsLabel = new JLabel[ssize];
	private JRadioButton[] yesButton = new JRadioButton[ssize];
	private JRadioButton[] noButton = new JRadioButton[ssize];
	public int countYES = 0;
	public int countNO = 0;
	private JButton con = new JButton("CONTINUE CHECK");
	public JFrame mf = null;
	int loc = 50;
	int xButton = 490;
	int yButton = 226;
	int yButton2 = 595;
	int yButton3 = 226;
	
	public SeriousSymptomps(Result r)
	{
		serious = new JLabel("SERIOUS SYMPTOMS ",JLabel.CENTER);
		serious.setSize(new Dimension(1530,300));
		serious.setFont(new Font("Calibri", Font.PLAIN, 18));
		con.setSize(new Dimension(160,30));
		con.setLocation(650,455);

		
		for(int i=0; i<ssize; i++)
		{
			symptompsLabel[i] = new JLabel("Do you have " + ser_symp[i] + "?");
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
		
		con.addActionListener(new ActionListener() {

			boolean[] check = new boolean[3];
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<3; i++)
				{
					check[i] = yesButton[i].isSelected()||noButton[i].isSelected();
				}
				if(allAnswered(check))
				{
					r.getSSdata(countYES);
					mf.getContentPane().removeAll();
					mf.repaint();						
					mf.add(r.getHeader());
					r.displayResultMostCommon();
					mf.add(r.writeMCA());
					mf.add(r.writeMostCommon());
					r.displayResultLessCommon();
					mf.add(r.writeLCA());
					mf.add(r.writeLessCommon());
					r.displaySeriousSymp();
					mf.add(r.writeSSA());
					mf.add(r.writeSeriousSymp());
					int res = r.explainResult(r.getMCYES(), r.getLCYES(), r.getSeriousYES());
					r.displayResult(res);
					mf.add(r.displayResult1());
					mf.add(r.displayResult2());
				}
				else
					JOptionPane.showMessageDialog(null, "Please answer all questions");
				
			}			
			
		});
		
	
	}
	public JLabel getHeader()
	{
		return serious;
	}
	public void setNumYes()
	{
		countYES++;
	}
	
	public void setNumNO()
	{
		countNO++;
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
		return ssize;
	}
	
	public boolean allAnswered(boolean[] buttons)
	{
		for(int i=0; i<3; i++)
		{
			if(buttons[i] == false)
				return false;
		}
		return true;
	}
	public void sendFrame(JFrame fr)
	{
		mf = fr;
	}
	public JButton getCont()
	{
		return con;
	}
	
	
}
