/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Notes:
 */
package view;


//imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Shows body parts a radiobuttons for user to choose.
 */
@SuppressWarnings("serial")
public class BodyPartsChooserPanel extends JPanel {
	
	//instance variables
	private JLabel title;
	private String[] bodyParts = {"head", "brain", "eyes", "ears", "nose", "mouth", "throat", "chest", "breasts", "heart", "shoulders", 
			"hands", "stomach", "genitals", "legs", "skin", "entire body"};
	private JRadioButton[] bodyPartsButtons = new JRadioButton[17];
	
	
	//constructor 
	public BodyPartsChooserPanel () {
		
		setLayout(null);
		setOpaque(false);
		
		//section 1: title
		title = new JLabel("Body Parts");
		title.setFont(new Font("Roboto", Font.BOLD, 30));
		title.setForeground(new Color(21, 132, 121));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0, 5, 560, 50);
		add(title);
		
		//section 2: body parts buttons
		ButtonGroup buttonHolder = new ButtonGroup();
		Box buttonBox1 = Box.createVerticalBox();
		Box buttonBox2 = Box.createVerticalBox();
		
		//displays body parts as radiobuttons		
		for (int i = 0; i < 17; i++) {
			bodyPartsButtons[i] = new JRadioButton("    " + bodyParts[i]);
			bodyPartsButtons[i].setFont(new Font("Roboto", Font.PLAIN, 25));
		    buttonHolder.add(bodyPartsButtons[i]);
		    
		    if (i <= 8)
		    	buttonBox1.add(bodyPartsButtons[i]);
		    else 
		    	buttonBox2.add(bodyPartsButtons[i]);
		}
		
	    buttonBox1.setBounds(30, 90, 280, 450);
		add(buttonBox1);
		
		buttonBox2.setBounds(310, 90, 250, 450);
		add(buttonBox2);
		
	}
	
	
	//getters and setters
	public JRadioButton[] getBodyPartsButtons() {
		return bodyPartsButtons;
	}


	public void setBodyPartsButtons(JRadioButton[] bodyPartsButtons) {
		this.bodyPartsButtons = bodyPartsButtons;
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
   
       g2.drawLine(0, 55, 560, 55);
       
    }	
	
}	// end of BodyPartsChooserPanel class
