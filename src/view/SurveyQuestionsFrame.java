/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Course: ICS4U1 Mr. Fernandes
 * Notes:
 */
package view;


//imports
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * Frame that allows user to enter basic personal information (some of which helps customize results).
 */
@SuppressWarnings("serial")
public class SurveyQuestionsFrame extends JFrame {
	
	//instance variables
	private HeaderPanel headerPanel = new HeaderPanel();	//header
	private SurveyQuestionsPanel questionsPanel;
	
	
	//constructor
	public SurveyQuestionsFrame() {
		
		setTitle("SymptoMed");
		setLayout(null);
		setSize(1400, 800);
		getContentPane().setBackground(new Color(123, 234, 223));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JOptionPane.showMessageDialog(this, "There are five steps in the symptom checker. The following screens will guide you. "
				+ "To ensure accuracy, 'back' button will only show when you are on the last screen.",
                "TIP", JOptionPane.INFORMATION_MESSAGE);
		
		headerPanel.setBounds(0, 0, 1400, 75);
		add(headerPanel);
		
		//adds the title
		JLabel title = new JLabel("Survey Questions");
		title.setFont(new Font("Roboto", Font.PLAIN, 25));
		title.setBounds(600, 5, 500, 65);
		headerPanel.add(title);
		
		//main panel
		questionsPanel = new SurveyQuestionsPanel();
		questionsPanel.setBounds(200, 100, 1000, 585);
		add(questionsPanel);
		
		setVisible(true);
		
		JOptionPane.showMessageDialog(this, "All fields are mandatory to fill as they help us customize our services. Thank you!",
                "TIP", JOptionPane.INFORMATION_MESSAGE);
	}
		
}
