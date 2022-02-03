/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Course: ICS4U1 Mr. Fernandes
 * Notes:
 */
package view;


//imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
 * The RegisterPanel class allows the user to enter personal information to sign up for the app.
 */
@SuppressWarnings("serial")
public class RegisterPanel extends JPanel {
	
	//instance variables
	private JLabel signUpTitle;
	private JLabel tagline;
	
	private JTextField name;
	private JTextField address;
	private JTextField city;
	private JTextField province;
	private JTextField postalCode;
	
	private JTextField username;
	private JPasswordField password;
	private JPasswordField confirmPassword;
	private JButton show;
	
	private JButton signUpButton;
	private JLabel signInGuideline;
	private JButton signInButton;
	
	
	//constructor 
	public RegisterPanel() {
		
		setLayout(null);
		setOpaque(false);
		
		//section 1: titles
		signUpTitle = new JLabel("Sign up");
		signUpTitle.setFont(new Font("Roboto", Font.BOLD, 35));
		signUpTitle.setBounds(30, 30, 150, 50);
		add(signUpTitle);
		
		tagline = new JLabel("SymptoMed");
		tagline.setFont(new Font("Roboto", Font.PLAIN, 17));
		tagline.setForeground(new Color(21, 132, 121));
		tagline.setBounds(30, 85, 150, 25);
		add(tagline);
		
		//section 2: personal information
		name = new JTextField("Full name");
		name.setFont(new Font("Roboto", Font.PLAIN, 20));
		name.setForeground(Color.gray);
		name.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		name.setBounds(30, 155, 455, 60);
		add(name);
		
		address = new JTextField("Address Line 1");
		address.setFont(new Font("Roboto", Font.PLAIN, 20));
		address.setForeground(Color.gray);
		address.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		address.setBounds(515, 155, 455, 60);
		add(address);
		
		city = new JTextField("City");
		city.setFont(new Font("Roboto", Font.PLAIN, 20));
		city.setForeground(Color.gray);
		city.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		city.setBounds(30, 245, 293, 60);
		add(city);
		
		province = new JTextField("Province");
		province.setFont(new Font("Roboto", Font.PLAIN, 20));
		province.setForeground(Color.gray);
		province.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		province.setBounds(353, 245, 293, 60);
		add(province);
		
		postalCode = new JTextField("Postal code");
		postalCode.setFont(new Font("Roboto", Font.PLAIN, 20));
		postalCode.setForeground(Color.gray);
		postalCode.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		postalCode.setBounds(676, 245, 293, 60);
		add(postalCode);
		
		//section 3: username and password fields
		username = new JTextField("Username");
		username.setFont(new Font("Roboto", Font.PLAIN, 20));
		username.setForeground(Color.gray);
		username.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		username.setBounds(30, 335, 293, 60);
		add(username);
		
		password = new JPasswordField("Password");
		password.setFont(new Font("Roboto", Font.PLAIN, 20));
		password.setForeground(Color.gray);
		password.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		password.setEchoChar((char) 0);
		password.setBounds(353, 335, 293, 60);
		add(password);
		
		show = new JButton("hide");
		show.setFont(new Font("Roboto", Font.PLAIN, 17));
		show.setBackground(Color.white);
		show.setForeground(new Color(21, 132, 121));
		show.setBounds(223, 0, 50, 65);
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
		
		confirmPassword = new JPasswordField("Confirm password");
		confirmPassword.setFont(new Font("Roboto", Font.PLAIN, 20));
		confirmPassword.setForeground(Color.gray);
		confirmPassword.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		confirmPassword.setEchoChar((char) 0);
		confirmPassword.setBounds(676, 335, 293, 60);
		add(confirmPassword);
		
		//section 4: sign up or sign in options
		signUpButton = new JButton("Sign up");
		signUpButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		signUpButton.setOpaque(true);
		signUpButton.setBackground(new Color(123, 234, 223));
		signUpButton.setBounds(250, 450, 500, 60);
		signUpButton.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		
		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, signInButton);
				
				//shows error if fields are empty
				if (name.getText().isEmpty() || address.getText().isEmpty() || city.getText().isEmpty() || province.getText().isEmpty()
						|| postalCode.getText().isEmpty() || username.getText().isEmpty() || password.getPassword().length == 0) {
					JOptionPane.showMessageDialog(parent, "A required field is incomplete. Please check again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				//shows error if user includes comma in name or address
				else if (name.getText().contains(",") || address.getText().contains(",")) {
					JOptionPane.showMessageDialog(parent, "Invalid characters included. TIP: Commas are not valid characters.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				//shows error if passwords do not match
				else if (!String.valueOf(password.getPassword()).equals(String.valueOf(confirmPassword.getPassword()))) {
					JOptionPane.showMessageDialog(parent, "Passwords do not match. Please check again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				//shows error if user leaves default values for any of the fields
				else if (name.getText().equals("Full name")) {
					JOptionPane.showMessageDialog(parent, "Invalid name. Please try again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					name.setText("");
				}
				
				else if (address.getText().equals("Address Line 1")) {
					JOptionPane.showMessageDialog(parent, "Invalid address. Please try again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					address.setText("");
				}
				
				else if (city.getText().equals("City")) {
					JOptionPane.showMessageDialog(parent, "Invalid city. Please try again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					city.setText("");
				}
				
				else if (province.getText().equals("Province")) {
					JOptionPane.showMessageDialog(parent, "Invalid province. Please try again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					province.setText("");
				}
				
				else if (postalCode.getText().equals("Postal code")) {
					JOptionPane.showMessageDialog(parent, "Invalid postal code. Please try again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					postalCode.setText("");
				}
				
				else if (username.getText().equals("Username")) {
					JOptionPane.showMessageDialog(parent, "Invalid username. Please try again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					username.setText("");
				}
				
				else if (String.valueOf(password.getPassword()).equals("Password") || String.valueOf(confirmPassword.getPassword()).equals("Confirm password")) {
					JOptionPane.showMessageDialog(parent, "Invalid password. Please enter a valid password.",
	                        "ERROR", JOptionPane.ERROR_MESSAGE);
					password.setText("");
					confirmPassword.setText("");
				}
				
				//shows error if user tries to user a username that another patient has
				else if (LoginController.checkIfRegistered(username.getText())) {
					JOptionPane.showMessageDialog(parent, "Username already exists. Please try a different username.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					username.setText("");
				}
				
				else {
					
						//saves information in current user
						MainController.getPatient().setUsername(username.getText());
						MainController.getPatient().setPassword(String.valueOf(password.getPassword()));
						
						MainController.setUserCheck(username.getText());
						MainController.setPwdCheck(String.valueOf(password.getPassword()));
						
						MainController.getPatient().setName(name.getText());
						MainController.getPatient().setAdressLine(address.getText());
						MainController.getPatient().setCity(city.getText());
						MainController.getPatient().setProvince(province.getText());
						MainController.getPatient().setPostalCode(postalCode.getText());
					
						//loads next screen
						JOptionPane.showMessageDialog(parent, "Successfully registered! Please login.",
                            "SUCESS", JOptionPane.INFORMATION_MESSAGE);
						parent.dispose();
						new LoginFrame();
				}
			}
		});
		
		add(signUpButton);
		
		//sign in option
		signInGuideline = new JLabel("Already have an account?");
		signInGuideline.setFont(new Font("Roboto", Font.PLAIN, 17));
		signInGuideline.setBounds(350, 510, 250, 60);
		add(signInGuideline);
		
		signInButton = new JButton("Sign in");
		signInButton.setFont(new Font("Roboto", Font.PLAIN, 17));
		signInButton.setBackground(Color.white);
		signInButton.setForeground(new Color(21, 132, 121));
		signInButton.setBounds(580, 510, 70, 60);
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
	
	
}	// end of RegisterPanel class
