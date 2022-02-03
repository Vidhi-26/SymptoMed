/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Course: ICS4U1 Mr. Fernandes
 * Notes:
 */
package view;


//imports
import javax.swing.*;

import model.Disease;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;


/**
 *  Frame that shows the user's diagnosed diseases.
 */
@SuppressWarnings("serial")
public class MatchedPotentialDiseasesFrame extends JFrame {
	
	//instance variables
	private HeaderPanel headerPanel = new HeaderPanel();	//header
	private DiseasesPanel diseasesPanel;
	private ShapePanel shapePanel;
	private ChecksPanel checksPanel;

	
	//constructor
	public MatchedPotentialDiseasesFrame(LinkedList<Disease> diseases) {
		
		setTitle("SymptoMed");
		setLayout(null);
		setSize(1400, 800);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		headerPanel.setBounds(0, 0, 1400, 75);
		headerPanel.setBackground(new Color(21, 132, 121));
		headerPanel.getLogoLabel().setForeground(Color.white);
		add(headerPanel);
		
		//adds the title
		JLabel title = new JLabel("Diseases Diagnosed");
		title.setFont(new Font("Roboto", Font.PLAIN, 25));
		title.setForeground(Color.white);
		title.setBounds(600, 5, 500, 65);
		headerPanel.add(title);
		
		shapePanel = new ShapePanel();
		shapePanel.setBounds(0, 0, 300, 400);
		add(shapePanel);
		
		//main panel
		diseasesPanel = new DiseasesPanel(diseases);
		diseasesPanel.setBounds(200, 100, 1000, 585);
		add(diseasesPanel);
		
		checksPanel = new ChecksPanel();
		checksPanel.setBounds(0, 0, 1400, 800);
		add(checksPanel);
		
		setVisible(true);
	}
		
}	// end of MatchedPotentialDiseasesFrame class
