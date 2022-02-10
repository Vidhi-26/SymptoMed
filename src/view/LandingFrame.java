/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Notes:
 */
package view;


//imports
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * LandingFrame class is the first frame that opens when the program runs.
 */
@SuppressWarnings("serial")
public class LandingFrame extends JFrame {
	
	//instance variables
	private JLabel backgroundImageLabel = new JLabel(new ImageIcon("./images/bgImage.jpg"));
	private JPanel infoPanel;
	
	private JLabel name = new JLabel("SymptoMed");
	private JLabel tagline;
	private JLabel about;
	
	private JButton signUp;
	private JButton signIn;
	
	
	//constructor
	public LandingFrame() {
		
		setTitle("SymptoMed");
		setLayout(null);
		setSize(1400, 800);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setOpaque(false);
		infoPanel.setBounds(200, 200, 400, 600);
		add(infoPanel);
		
		//name, tagline, and about the app
		name.setFont(new Font("Roboto", Font.BOLD, 30));
		name.setForeground(Color.white);
		name.setBounds(0, 30, 400, 50);
		infoPanel.add(name);
		
		tagline = new JLabel("Where you come first");
		tagline.setFont(new Font("Roboto", Font.ITALIC, 18));
		tagline.setForeground(Color.white);
		tagline.setBounds(0, 90, 400, 25);
		infoPanel.add(tagline);
		
		JLabel about1 = new JLabel("A symptom checker application that diagnoses");
		about1.setFont(new Font("Roboto", Font.PLAIN, 17));
		about1.setForeground(Color.white);
		about1.setBounds(0, 150, 400, 25);
		infoPanel.add(about1);
		
		JLabel about1Another = new JLabel("diseases based on the symptoms you choose.");
		about1Another.setFont(new Font("Roboto", Font.PLAIN, 17));
		about1Another.setForeground(Color.white);
		about1Another.setBounds(0, 175, 400, 25);
		infoPanel.add(about1Another);
		
		JLabel about2 = new JLabel("Once you choose a symptom, we dynamically");
		about2.setFont(new Font("Roboto", Font.PLAIN, 17));
		about2.setForeground(Color.white);
		about2.setBounds(0, 200, 400, 25);
		infoPanel.add(about2);
		
		JLabel about2Another = new JLabel("update and show only the relevant symptoms");
		about2Another.setFont(new Font("Roboto", Font.PLAIN, 17));
		about2Another.setForeground(Color.white);
		about2Another.setBounds(0, 225, 400, 25);
		infoPanel.add(about2Another);
		
		JLabel about3 = new JLabel("the next time. It only takes a few minutes to");
		about3.setFont(new Font("Roboto", Font.PLAIN, 17));
		about3.setForeground(Color.white);
		about3.setBounds(0, 250, 400, 25);
		infoPanel.add(about3);
		
		JLabel about3Another = new JLabel("complete checking your symptoms.");
		about3Another.setFont(new Font("Roboto", Font.PLAIN, 17));
		about3Another.setForeground(Color.white);
		about3Another.setBounds(0, 275, 400, 25);
		infoPanel.add(about3Another);
		
		JLabel about4 = new JLabel("Thank you for choosing SymptoMed!");
		about4.setFont(new Font("Roboto", Font.PLAIN, 17));
		about4.setForeground(Color.white);
		about4.setBounds(0, 317, 400, 25);
		infoPanel.add(about4);
		
		//sign in or sign up options
		signIn = new JButton("Sign in");
		signIn.setFont(new Font("Roboto", Font.PLAIN, 18));
		signIn.setForeground(Color.white);
		signIn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		signIn.setBounds(0, 400, 120, 40);
		signIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginFrame();
			}
		});
		infoPanel.add(signIn);
		
		signUp = new JButton("Sign up");
		signUp.setFont(new Font("Roboto", Font.PLAIN, 18));
		signUp.setForeground(Color.white);
		signUp.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		signUp.setBounds(200, 400, 120, 40);
		signUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterFrame();
			}
		});
		infoPanel.add(signUp);	
		
		//background image
		backgroundImageLabel.setBounds(0, 0, 1400, 800);
		add(backgroundImageLabel);
		
		setVisible(true);	
	}
	
}	// end of LandingFrame class
