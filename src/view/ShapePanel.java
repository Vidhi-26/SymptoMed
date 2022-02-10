/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Notes:
 */
package view;


//imports
import javax.swing.*;
import controller.LoginController;
import java.awt.*;
import java.awt.event.*;

/**
 * Improves background and aesthetics of GUI.
 */
@SuppressWarnings("serial")
public class ShapePanel extends JPanel {
	
	//instance variables
	
	
	//constructor 
	public ShapePanel() {
		setLayout(null);
		setOpaque(false);
	}
	
	
	//Utility methods
	/*
	 * Draw a bow shape.
	 */
	@Override
    public void paintComponent(Graphics g) {
			
		//Refreshes the panel
       super.paintComponent(g);
       
       Graphics2D g2 = (Graphics2D) g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

       //Draws the rounded borders
       g2.setColor(new Color(21, 132, 121));
       g2.fillRect(100, 0, 140, 200);
       g2.drawRect(100, 0, 140, 200);
       
       int[] x1 = {100, 170, 100};
       int[] y1 = {200, 200, 290};
       g2.drawPolygon(x1, y1, 3);
       g2.fillPolygon(x1, y1, 3);
       
       int[] x2 = {240, 170, 240};
       int[] y2 = {200, 200, 290};
       g2.drawPolygon(x2, y2, 3);
       g2.fillPolygon(x2, y2, 3);
       
    }
	
}	// end of DiseasesPanel class
