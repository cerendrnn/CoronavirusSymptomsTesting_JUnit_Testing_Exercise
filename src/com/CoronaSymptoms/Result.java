package com.CoronaSymptoms;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class Result {
	
	private JLabel res;
	private int mostCommonYes = 0;
	private int lessCommonYes = 0;
	private int seriousYES = 0;
	private JLabel lessCommon;
	private JLabel seriousSymptomps;
	private JLabel mostCommon;
	private JLabel mcr;
	private JLabel lcr;
	private JLabel ssr;
	private JLabel res1 = null;
	private JLabel res2 =null;
	
	
	public Result()
	{
		res = new JLabel("ANALYSIS OF THE SYMPTOMPS",JLabel.CENTER);
		res.setSize(new Dimension(1530,300));
		res.setFont(new Font("Calibri", Font.PLAIN, 18));
		mostCommon = new JLabel("Analysis of the most common symptomps you have encountered:");
		mostCommon.setSize(new Dimension(1430,200));
		mostCommon.setLocation(160,110);
		lessCommon = new JLabel("Analysis of the less common symptomps you have encountered:");
		lessCommon.setFont(new Font("Calibri", Font.PLAIN, 15));
		lessCommon.setSize(new Dimension(1530,300));
		lessCommon.setLocation(160,210);
		seriousSymptomps = new JLabel("Analysis of the serious symptomps you have encountered:");
		seriousSymptomps.setSize(new Dimension(1430,200));
		seriousSymptomps.setLocation(160,340);
		seriousSymptomps.setFont(new Font("Calibri", Font.PLAIN, 15));	
	}
	
	public JLabel getHeader()
	{
		return res;
	}
	
	public void displayResultMostCommon()
	{
		mcr = new JLabel("You have encountered " + mostCommonYes + " of most common symptomps of COVID-19");
		mcr.setSize(new Dimension(1530,300));
		mcr.setLocation(180,150);
		mostCommon.setFont(new Font("Calibri", Font.PLAIN, 15));
	}
	
	public void displayResultLessCommon()
	{
		
		lcr = new JLabel("You have encountered " + lessCommonYes + " of less common symptomps of COVID-19");
		lcr.setSize(new Dimension(1530,300));
		lcr.setLocation(180,250);
	}
	
	public void displaySeriousSymp()
	{
		ssr = new JLabel("You have encountered " + seriousYES + " of serious symptomps of COVID-19");
		ssr.setSize(new Dimension(1530,300));
		ssr.setLocation(180,350);
	}
	
	public JLabel writeMCA()
	{
		return mostCommon;
	}
	
	public JLabel writeSSA()
	{
		return seriousSymptomps;
	}
	
	public JLabel writeLCA()
	{
		return lessCommon;
	}
	
	public JLabel writeMostCommon()
	{
		return mcr;
	}
	public JLabel writeLessCommon()
	{
		return lcr;
	}
	public JLabel writeSeriousSymp()
	{
		return ssr;
	}
	
	public void getMCdata(int yes)
	{
		mostCommonYes = yes;
	}
	public void getLCdata(int yes)
	{
		lessCommonYes = yes;
	}
	public void getSSdata(int yes)
	{
		seriousYES = yes;
	}
	public JLabel displayResult1()
	{
		return res1;
	}
	public JLabel displayResult2()
	{
		return res2;
	}
	
	public int getMCYES()
	{
		return mostCommonYes;
	}
	
	public int getLCYES()
	{
		return lessCommonYes;
	}
	
	public int getSeriousYES()
	{
		return seriousYES;
	}
	
    public int explainResult(int seriousYES, int lessCommonYes, int mostCommonYes)
    {
    	if(seriousYES == 0 && lessCommonYes >= 4 && mostCommonYes <=2)
		{
    		return 2;
		}
    	if(seriousYES >= 2 && lessCommonYes >= 1 && mostCommonYes >=1 )
		{
    		return 1;
		}
    	if(seriousYES == 0 && lessCommonYes <=2 && mostCommonYes <=1)
		{
    		return 0;
		}
		return 0;
    	
    }
		
	public void displayResult(int res)
	{
		if(res == 2)
		{
			res1 = new JLabel("Do not worry. You do not have coronavirus.");
			res2 = new JLabel("You have influenza... Please stay at home. Please have a rest and take your pills...");
			res1.setSize(new Dimension(1530,300));
			res2.setSize(new Dimension(1530,300));
			res1.setFont(new Font("Calibri", Font.PLAIN, 19));
			res2.setFont(new Font("Calibri", Font.PLAIN, 19));
			res1.setLocation(190,460);
			res2.setLocation(190,480);
			
			
		}
		if(res == 1)
		{
			res1 = new JLabel("We are so sad to say that you are diagnosed with COVID-19 disease");
			res2 = new JLabel("Please stay at home. If you feel more terribly, please go to hospital");
			res1.setSize(new Dimension(1530,300));
			res2.setSize(new Dimension(1530,300));
			res1.setFont(new Font("Calibri", Font.PLAIN, 19));	
			res2.setFont(new Font("Calibri", Font.PLAIN, 19));
			res1.setLocation(190,460);
			res2.setLocation(190,480);
			
		}
		if(res == 0)
		{
			res1 = new JLabel("You are healthy");
			res2 = new JLabel("Please stay at home");
			res1.setSize(new Dimension(1530,300));
			res2.setSize(new Dimension(1530,300));
			res1.setFont(new Font("Calibri", Font.PLAIN, 19));
			res2.setFont(new Font("Calibri", Font.PLAIN, 19));
			res1.setLocation(190,460);
			res2.setLocation(190,480);
		}
	}

}
