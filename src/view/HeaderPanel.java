/*
 * Name: Vidhi Ruparel
 * Date: January 18, 2021
 * Course: ICS4U1-02 Mr. Fernandes
 * Description: This is the header panel, which creates a header for all frames
 */
package view;


//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * HeaderPanel class. This is a template header class that
 * sets up headers for all screens. 
 */
@SuppressWarnings("serial")
public class HeaderPanel extends JPanel {
	
	//instance variables
	//logo
	private JLabel logoLabel;													//logo label
	
	//home
	private ImageIcon homeImage = new ImageIcon("./images/homeImage.png");		//home image
	private JButton homeButton;													//home button
	
	//constructor
	public HeaderPanel() {
		
		setLayout(null);
		setBackground(Color.white);
		
		//adds the logo image to the logo label
		logoLabel = new JLabel("SYMPTOMED");
		logoLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
		logoLabel.setBounds(100, 9, 500, 60);
		add(logoLabel);
		
		//adds the home image to the home button
		homeButton = new JButton(homeImage);
		homeButton.setBorder(BorderFactory.createEmptyBorder());
		homeButton.setBackground(getBackground());
		homeButton.setBounds(1300, 0, 75, 75);
		
		//opens the home screen when clicked
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, homeButton);
				parent.dispose();
				new HomeFrame();
			}
		});
		add(homeButton);
		
	}


	//getters and setters
	public JLabel getLogoLabel() {
		return logoLabel;
	}

	public void setLogoLabel(JLabel logoLabel) {
		this.logoLabel = logoLabel;
	}

	public JButton getHomeButton() {
		return homeButton;
	}

	public void setHomeButton(JButton homeButton) {
		this.homeButton = homeButton;
	}	
}	//end of HeaderPanel class