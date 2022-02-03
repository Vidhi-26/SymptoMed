/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Course: ICS4U1 Mr. Fernandes
 * Notes:
 */
package view;


import java.awt.Color;

//imports
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * LoginFrame class allows the user to login. 
 * It opens the sign in screen.
 */
@SuppressWarnings("serial")
public class LoginFrame extends JFrame {
	
	//instance variables
	private LoginPanel loginPanel;

	
	//constructor
	public LoginFrame() {
		
		setTitle("SymptoMed");
		setLayout(null);
		setSize(1400, 800);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//main panel
		loginPanel = new LoginPanel();
		loginPanel.setBounds(420, 100, 560, 585);
		add(loginPanel);
		
		setVisible(true);
	
		JOptionPane.showMessageDialog(this, "Press tab key on your keyboard to move to the next text field.",
                "TIP", JOptionPane.INFORMATION_MESSAGE);
	}


	//getters and setters
	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public void setLoginPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel;
	}
		
}	// end of LoginFrame class