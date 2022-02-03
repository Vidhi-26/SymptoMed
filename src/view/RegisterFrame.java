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
 * RegisterFrame class opens the screen that allows a new user to sign up on the app. 
 */
@SuppressWarnings("serial")
public class RegisterFrame extends JFrame {
	
	//instance variables
	private RegisterPanel registerPanel;

	
	//constructor
	public RegisterFrame() {
		
		setTitle("SymptoMed");
		setLayout(null);
		setSize(1400, 800);
		getContentPane().setBackground(new Color(123, 234, 223));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//main panel
		registerPanel = new RegisterPanel();
		registerPanel.setBounds(200, 100, 1000, 585);
		add(registerPanel);
		
		setVisible(true);
		
		JOptionPane.showMessageDialog(this, "Press tab key on your keyboard to move to the next text field."
				+ "All fields are mandatory to fill as they help us customize our services. Thank you!",
                "TIP", JOptionPane.INFORMATION_MESSAGE);
	}


	//getters and setters
	public RegisterPanel getRegisterPanel() {
		return registerPanel;
	}

	public void setRegisterPanel(RegisterPanel registerPanel) {
		this.registerPanel = registerPanel;
	}
		
}	// end of RegisterFrame class
