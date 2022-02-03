/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Course: ICS4U1 Mr. Fernandes
 * Notes:
 */
package view;


//imports
import javax.swing.*;

import controller.LoginController;
import controller.MainController;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;


/**
 * ForgotPasswordPanel class allows the user to reset their password if they have forgotten it
 */
@SuppressWarnings("serial")
public class ForgotPasswordPanel extends JPanel {
	
	//instance variables
	private JLabel forgotPasswordTitle;
	private JLabel tagline;
	
	private JPasswordField password;
	private JPasswordField confirmPassword;
	private JButton show;
	
	private JButton resetButton;
	private JLabel signInGuideline;
	private JButton signInButton;
	
	
	//constructor 
	public ForgotPasswordPanel(String username) {
		
		setLayout(null);
		setOpaque(false);
		
		//section 1: titles
		forgotPasswordTitle = new JLabel("Reset Password");
		forgotPasswordTitle.setFont(new Font("Roboto", Font.BOLD, 35));
		forgotPasswordTitle.setBounds(30, 30, 350, 50);
		add(forgotPasswordTitle);
		
		tagline = new JLabel("SymptoMed");
		tagline.setFont(new Font("Roboto", Font.PLAIN, 17));
		tagline.setForeground(new Color(21, 132, 121));
		tagline.setBounds(30, 85, 150, 25);
		add(tagline);
		
		//section 2: password fields
		password = new JPasswordField("Enter new password");
		password.setFont(new Font("Roboto", Font.PLAIN, 20));
		password.setForeground(Color.gray);
		password.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		password.setEchoChar((char) 0);
		password.setBounds(30, 180, 500, 65);
		add(password);
		
		confirmPassword = new JPasswordField("Confirm password");
		confirmPassword.setFont(new Font("Roboto", Font.PLAIN, 20));
		confirmPassword.setForeground(Color.gray);
		confirmPassword.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		confirmPassword.setEchoChar((char) 0);
		confirmPassword.setBounds(30, 285, 500, 65);
		add(confirmPassword);
		
		show = new JButton("hide");
		show.setFont(new Font("Roboto", Font.PLAIN, 17));
		show.setBackground(Color.white);
		show.setForeground(new Color(21, 132, 121));
		show.setBounds(400, 0, 100, 65);
		show.setBorder(BorderFactory.createEmptyBorder());
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (show.getText().equals("show")) {
					password.setEchoChar((char) 0);
					show.setText("hide");
				}
				
				else {
					password.setEchoChar('\u2022');
					show.setText("show");
				}
			}
		});
		password.add(show);
		
		//section 3: reset button or sign in option
		resetButton = new JButton("Reset password");
		resetButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		resetButton.setOpaque(true);
		resetButton.setBackground(new Color(123, 234, 223));
		resetButton.setBounds(30, 420, 500, 65);
		resetButton.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, resetButton);
				
				//shows error message if fields are empty
				if (password.getPassword().length == 0 || confirmPassword.getPassword().length == 0) {
					JOptionPane.showMessageDialog(parent, "No password detected. Please enter a valid password.",
	                        "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				//shows error message if fields are on default mode (user did not enter anything)
				else if (String.valueOf(password.getPassword()).equals("Enter new password") || String.valueOf(confirmPassword.getPassword()).equals("Confirm password")) {
					JOptionPane.showMessageDialog(parent, "Invalid password. Please enter a valid password.",
	                        "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				//shows error message if password and confirm password do not match
				else if (!String.valueOf(password.getPassword()).equals(String.valueOf(confirmPassword.getPassword()))) {
				JOptionPane.showMessageDialog(parent, "Passwords do not match. Please check again.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				//shows successful resetting message
				else {
					
					JOptionPane.showMessageDialog(parent, "Password reset successful.",
	                        "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
	
					MainController.setFlag(true);
					MainController.setPwdCheck2(String.valueOf(password.getPassword()));
					MainController.getPatient().setPassword(String.valueOf(password.getPassword()));
					MainController.setPwdCheck(String.valueOf(password.getPassword()));
					
					//opens new frame
					parent.dispose();
					new LoginFrame();
				}
			}
		});
		
		add(resetButton);
		
		//for sign in
		signInGuideline = new JLabel("Go back to login?");
		signInGuideline.setFont(new Font("Roboto", Font.PLAIN, 17));
		signInGuideline.setBounds(145, 495, 200, 50);
		add(signInGuideline);
		
		signInButton = new JButton("Sign in");
		signInButton.setFont(new Font("Roboto", Font.PLAIN, 17));
		signInButton.setBackground(Color.white);
		signInButton.setForeground(new Color(21, 132, 121));
		signInButton.setBounds(300, 495, 70, 50);
		signInButton.setBorder(BorderFactory.createEmptyBorder());
		
		signInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, signInButton);
				parent.dispose();
				new LoginFrame();
			}
		});
		
		add(signInButton);
		
	}
	
	
	//Utility methods
	/*
	 * Add rounded borders to the panel
	 */
	@Override
    public void paintComponent(Graphics g) {
			
		//Refreshes the panel
       super.paintComponent(g);
       
       Dimension arcs = new Dimension(25, 25);
       int width = getWidth();
       int height = getHeight();
       
       Graphics2D g2 = (Graphics2D) g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

       //Draws the rounded borders
       g2.setColor(Color.white);
       g2.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
       
       g2.setColor(getForeground());
       g2.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
       
    }
	
	
}	// end of ForgotPasswordPanel class
