/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Course: ICS4U1 Mr. Fernandes
 * Notes:
 */
package view;


//imports
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;


/**
 * ForgotPasswordFrame opens a screen for users to reset their password.
 */
@SuppressWarnings("serial")
public class ForgotPasswordFrame extends JFrame {
	
	//instance variables
	private ForgotPasswordPanel forgotPasswordPanel;

	
	//constructor
	public ForgotPasswordFrame(String username) {
		
		setTitle("SymptoMed");
		setLayout(null);
		setSize(1400, 800);
		getContentPane().setBackground(new Color(123, 234, 223));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//main panel
		forgotPasswordPanel = new ForgotPasswordPanel(username);
		forgotPasswordPanel.setBounds(420, 100, 560, 585);
		add(forgotPasswordPanel);
		
		setVisible(true);
		
		JOptionPane.showMessageDialog(this, "Press tab key on your keyboard to move to the next text field.",
                "TIP", JOptionPane.INFORMATION_MESSAGE);
	}


	//getters and setters
	public ForgotPasswordPanel getForgotPasswordPanel() {
		return forgotPasswordPanel;
	}

	public void setForgotPasswordPanel(ForgotPasswordPanel forgotPasswordPanel) {
		this.forgotPasswordPanel = forgotPasswordPanel;
	}
		
}	// end of ForgotPasswordFrame class