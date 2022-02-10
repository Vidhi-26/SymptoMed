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
import java.util.LinkedList;

//imports
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import model.Disease;

/**
 * Shows user's diagnosed diseases.
 */
@SuppressWarnings("serial")
public class DiseasesPanel extends JPanel {
	
	//instance variables
	private JLabel instruction;

	//private JButton[] diseasesButtons;
	private JButton diseaseButton;
	
	private int y = 85;
	
	
	//constructor 
	public DiseasesPanel(LinkedList<Disease> diseases) {
		
		setLayout(null);
		setOpaque(false);
		
		//displays instruction
		instruction = new JLabel("Step 4 of 5: Please click on disease name for more information. Click home to see health report.");
		instruction.setFont(new Font("Roboto", Font.ITALIC, 20));
		instruction.setForeground(new Color(21, 132, 121));
		instruction.setBounds(50, 30, 970, 25);
		add(instruction);
		
		//displays all diseases (depending on the number of diseases)
		for (int i = 0; i < diseases.size(); i++) {
			
			Disease matchedDisease = diseases.get(i);
			
			diseaseButton = new JButton("  " + matchedDisease.getName());
			diseaseButton.setHorizontalAlignment(SwingConstants.LEFT);
			diseaseButton.setFont(new Font("Roboto", Font.PLAIN, 22));
			diseaseButton.setOpaque(true);
			diseaseButton.setBackground(Color.white);
			diseaseButton.setForeground(new Color(21, 132, 121));
			diseaseButton.setBorder(BorderFactory.createLineBorder(Color.black, 1));
			diseaseButton.setBounds(200, y, 600, 60);
			diseaseButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, diseaseButton);
					parent.dispose();
					new MoreInformationFrame(matchedDisease);
				}
			});
			add(diseaseButton);	
			
			y += 100;
		}
		
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
       g2.setColor(new Color(211, 248, 244));
       g2.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
       
       g2.setColor(getForeground());
       g2.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
       
    }
	
	
}	// end of DiseasesPanel class
