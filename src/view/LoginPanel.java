/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Notes:
 */
package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

//imports
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.LoginController;
import controller.MainController;

/**
 * LoginPanel class allows the user to enter their username and password to sign in.
 */
@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	
	//instance variables
	private JLabel signInTitle;
	private JLabel tagline;
	
	private JTextField username;
	private JPasswordField password;
	private JButton show;
	private JButton forgotPwd;
	
	private JButton signInButton;
	private JLabel signUpGuideline;
	private JButton signUpButton;
	
	
	//constructor 
	public LoginPanel() {
		
		setLayout(null);
		setBackground(Color.white);
		
		//section 1: titles
		signInTitle = new JLabel("Sign in");
		signInTitle.setFont(new Font("Roboto", Font.BOLD, 35));
		signInTitle.setBounds(30, 30, 150, 50);
		add(signInTitle);
		
		tagline = new JLabel("SymptoMed");
		tagline.setFont(new Font("Roboto", Font.PLAIN, 17));
		tagline.setForeground(new Color(21, 132, 121));
		tagline.setBounds(30, 85, 150, 25);
		add(tagline);
		
		//section 2: username and password fields
		username = new JTextField("Username");
		username.setFont(new Font("Roboto", Font.PLAIN, 20));
		username.setForeground(Color.gray);
		username.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		username.setBounds(30, 165, 500, 65);
		add(username);
		
		password = new JPasswordField("Password");
		password.setFont(new Font("Roboto", Font.PLAIN, 20));
		password.setForeground(Color.gray);
		password.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		password.setEchoChar((char) 0);
		password.setBounds(30, 255, 500, 65);
		add(password);
		
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
		
		forgotPwd = new JButton("Forgot Password?");
		forgotPwd.setFont(new Font("Roboto", Font.PLAIN, 17));
		forgotPwd.setBackground(Color.white);
		forgotPwd.setForeground(new Color(21, 132, 121));
		forgotPwd.setBounds(-25, 330, 250, 50);
		forgotPwd.setBorder(BorderFactory.createEmptyBorder());
		
		forgotPwd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, forgotPwd);
				
				if (forgotPwd.getText().equals("")) {
					JOptionPane.showMessageDialog(parent, "Please enter your username first.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (!LoginController.checkIfRegistered(username.getText())) {
					JOptionPane.showMessageDialog(parent, "You aren't registered with us. Please register by clicking the Sign up button.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					parent.dispose();
					new ForgotPasswordFrame(username.getText());
				}
			}
		});
		
		add(forgotPwd);
		
		//section 3: sign in or sign up options
		signInButton = new JButton("Sign in");
		signInButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		signInButton.setOpaque(true);
		signInButton.setBackground(new Color(123, 234, 223));
		signInButton.setBounds(30, 420, 500, 65);
		signInButton.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		
		signInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean isValidation = true;
				
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, signInButton);
				
				//shows error message if fields are missing
				if (username.getText().isEmpty() || password.getPassword().length == 0) {
					
		            JOptionPane.showMessageDialog(parent, "Missing username of password. Please check again.",
		                                   "ERROR", JOptionPane.ERROR_MESSAGE);
		            isValidation = false;
				}
				
				//shows error message if user kept default values (did not edit fields)
				else if (username.getText().equals("Username") || String.valueOf(password.getPassword()).equals("Password")) {
		            JOptionPane.showMessageDialog(parent, "Invalid username or password. Please try again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
		            isValidation = false;
		            
				}
				
				//shows error message if user has not registered
				else if (!LoginController.checkIfRegistered(username.getText())) {
					if (!MainController.getUserCheck().equals(username.getText())) {
						JOptionPane.showMessageDialog(parent, "You aren't registered with us. Please register by clicking the Sign up button.",
	                            "ERROR", JOptionPane.ERROR_MESSAGE);
						 username.setText("");
						 
						 isValidation = false;
					}
				}
				
				//shows error message if user entered wrong password
				else if (MainController.isFlag()) {
					if (MainController.getPwdCheck2().equals(String.valueOf(password.getPassword())) == false) {
						JOptionPane.showMessageDialog(parent, "Incorrect password. Please try again.",
	                            "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				else if (!LoginController.checkCorrectPwd(String.valueOf(password.getPassword()), username.getText())) {
					if (MainController.getPwdCheck().equals(String.valueOf(password.getPassword())) == false) {
						JOptionPane.showMessageDialog(parent, "Incorrect password. Please try again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
						
						isValidation = false;
				
						username.setText("");
						password.setText("");
					}
				}
				
				//loads next screen
				if (isValidation) {
					parent.dispose();
					LoginController.saveCurrentUser(username.getText());
					new HomeFrame();
				}
				
			}
		});
		
		add(signInButton);
		
		//sign up option
		signUpGuideline = new JLabel("Don't have an account?");
		signUpGuideline.setFont(new Font("Roboto", Font.PLAIN, 17));
		signUpGuideline.setBounds(135, 495, 200, 50);
		add(signUpGuideline);
		
		signUpButton = new JButton("Sign up");
		signUpButton.setFont(new Font("Roboto", Font.PLAIN, 17));
		signUpButton.setBackground(Color.white);
		signUpButton.setForeground(new Color(21, 132, 121));
		signUpButton.setBounds(340, 495, 70, 50);
		signUpButton.setBorder(BorderFactory.createEmptyBorder());
		
		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, signUpButton);
				parent.dispose();
				new RegisterFrame();
			}
		});
		
		add(signUpButton);
		
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
       g2.setColor(getBackground());
       g2.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
       
       g2.setColor(getForeground());
       g2.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
       
    }
	
	
}	// end of LoginPanel class
