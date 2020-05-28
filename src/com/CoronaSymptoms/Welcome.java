package com.CoronaSymptoms;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Welcome extends JPanel implements ActionListener {
	
	private JTextField ntf, atf;
	private JButton b;
	private static final String NAME_PATTERN =
            "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$";
	private String userName;
	private int uage;
	private Matcher nameMatcher;
	private boolean valid;
	private boolean v_age;
	private JFrame fm;
	private Result r = new Result();
	
	    			
	public Welcome(Result r)
	{	
		 fm = new JFrame("Coronavirus Symptoms Testing");
		 
		 JLabel enter = new JLabel("Please enter your name and age ",JLabel.CENTER);
		 JLabel name = new JLabel("Name: ",JLabel.CENTER);
		 JLabel age = new JLabel("Age: ",JLabel.CENTER);
		 b = new JButton("CHECK SYMPTOMS");
		 b.setSize(new Dimension(160,30));
		 b.setLocation(680,420);
		 b.setEnabled(true);
		 ntf = new JTextField(80);		 	 
		 ntf.setSize(new Dimension(170,20));
		 ntf.setLocation(620, 332);
		 atf = new JTextField(30);
		 atf.setSize(new Dimension(170,20));
		 atf.setLocation(620, 368);
		 enter.setSize(new Dimension(1530,600));
		 name.setSize(new Dimension(1150,680));
		 age.setSize(new Dimension(1150,760));
		 enter.setFont(new Font("Calibri", Font.PLAIN, 18));
		 name.setFont(new Font("Calibri", Font.PLAIN, 18));
		 age.setFont(new Font("Calibri", Font.PLAIN, 18));
		 fm.setContentPane(new JLabel(new ImageIcon("welcome.jpeg")));
		 fm.add(enter);
		 fm.add(name);
		 fm.add(ntf);
		 fm.add(age);
		 fm.add(atf);
		 fm.add(b);
		 setLayout(new FlowLayout());
		 fm.setVisible(true);
		 fm.setResizable(true);
		 fm.pack();
		 fm.setSize(1910,850);
		 
		 b.addActionListener(this);
		 
	}
	
	public void actionPerformed(ActionEvent e){  
        
		userName = ntf.getText();
    	valid = checkValidName(userName);
		if(valid == false )
			JOptionPane.showMessageDialog(null, "Please enter a valid name");
		String a = atf.getText();
    	System.out.println(a);
		uage = Integer.parseInt(a);
		v_age = checkValidAge(uage);
		
		if(v_age ==false)
		{
			JOptionPane.showMessageDialog(null, "Please enter valid age");
		}
		
		if(v_age&&valid)
			new MostCommon(r);
	}
    
	
	public boolean checkValidName(String name)
	{
		nameMatcher = Pattern.compile(NAME_PATTERN).matcher(name);
		
		if(nameMatcher.matches()) {
            return name.length() != 1 && name.length() != 2;
        }
        else
            return false;
		
	}
	public boolean checkValidAge(int age)
	{
		if( age > 0 && age <130)
		{
			return true;
		}
		
		return false;
	}
    
	public static void main(String[] args)
	{	
        Result r = new Result();
		new Welcome(r);
		
	}
	
	
	
	
}
