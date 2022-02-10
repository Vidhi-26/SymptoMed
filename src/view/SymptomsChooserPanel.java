/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
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
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;


/**
 * Shows dynamically updated list of symptoms based on user choices.
 */
@SuppressWarnings("serial")
public class SymptomsChooserPanel extends JPanel {
	
	//instance variables
	private JLabel title;
	private JRadioButton[] symptomButtons;
	
	
	//constructor 
	public SymptomsChooserPanel(String[] symptoms) {
		
		setLayout(null);
		setOpaque(false);
		
		//section 1: title
		title = new JLabel("Symptoms");
		title.setFont(new Font("Roboto", Font.BOLD, 30));
		title.setForeground(new Color(21, 132, 121));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0, 5, 560, 50);
		add(title);
		
		
		//section 2: symptoms radio buttons
		symptomButtons = new JRadioButton[symptoms.length];
		
		ButtonGroup buttonHolder = new ButtonGroup();
		Box buttonBox = Box.createVerticalBox();
				
		for (int i = 0; i < symptoms.length; i++) {
			symptomButtons[i] = new JRadioButton("    " + symptoms[i]);
			symptomButtons[i].setFont(new Font("Roboto", Font.PLAIN, 20));
		    buttonHolder.add(symptomButtons[i]);
		    buttonBox.add(symptomButtons[i]);
		}
		
	    buttonBox.setBounds(30, 75, 600, 550);
		add(buttonBox);
        
	}
	
	
	//getters and setters
	public JRadioButton[] getSymptomButtons() {
		return symptomButtons;
	}


	public void setSymptomButtons(JRadioButton[] symptomButtons) {
		this.symptomButtons = symptomButtons;
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
	
}	// end of SymptomsChooserPanel class
