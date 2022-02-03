/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Course: ICS4U1 Mr. Fernandes
 * Notes:
 * Cite: Katherine Chun's paintComponent method to create checks pattern
 */
package view;


//imports
import javax.swing.*;
import controller.LoginController;
import java.awt.*;
import java.awt.event.*;

/**
 * Creates checks pattern for backround
 */
@SuppressWarnings("serial")
public class ChecksPanel extends JPanel {
	
	//instance variables
	
	
	//constructor 
	public ChecksPanel() {
		
		setLayout(null);
		setOpaque(false);	
		
	}
	
	
	//Utility methods
	/*
	 * Draws checks on panel
	 */
	@Override
    public void paintComponent(Graphics g) {
			
		//Refreshes the panel
       super.paintComponent(g);
    
       g.setColor(new Color(21, 132, 121));		//Setting the colour of the lines
		
		//Painting the vertical lines for the grid
		for (int row = 0; row < 18; row++)
			g.drawLine(0, 20 + row * 50, 1650, 20 + row * 50);
		
		//Painting the horizontal lines for the grid
		for (int column = 0; column < 33; column++) 
			g.drawLine(column * 50, 0,column * 50, 920);
       
    }
	
	
}	// end of ChecksPanel class
