/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Notes:
 */
package view;


//imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.FileImportController;
import controller.FindDiseasesController;
import controller.MainController;


/**
 * Frame that shows dynamically updated list of symptoms based on user choices.
 */
@SuppressWarnings("serial")
public class SymptomsChooserFrame extends JFrame {
	
	//instance variables
	private HeaderPanel headerPanel = new HeaderPanel();	//header
	private SymptomsChooserPanel symptomsChooserPanel;
	private JLabel instruction;
	private JLabel backgroundImageLabel = new JLabel(new ImageIcon("./images/dna.jpg"));
	private JButton next;
	private boolean isSymptomSelected = false;
	
	
	//constructor
	public SymptomsChooserFrame(String[] symptoms) {
		
		setTitle("SymptoMed");
		setLayout(null);
		//getContentPane().setLayout(new BorderLayout());
		setSize(1400, 800);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		headerPanel.setBounds(0, 0, 1400, 75);
		add(headerPanel);

		//adds the title
		JLabel title = new JLabel("Symptoms Chooser");
		title.setFont(new Font("Roboto", Font.PLAIN, 25));
		title.setBounds(600, 5, 500, 65);
		headerPanel.add(title);
		
		instruction = new JLabel("   Step 3 of 5:  Please choose a symptom you have from the list below.");
		instruction.setFont(new Font("Roboto", Font.ITALIC, 20));
		instruction.setOpaque(true);
		instruction.setBackground(Color.white);
		instruction.setForeground(new Color(21, 132, 121));
		instruction.setBounds(150, 120, 1050, 50);
		instruction.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		add(instruction);
		
		
		//panels
		symptomsChooserPanel = new SymptomsChooserPanel(symptoms);
		symptomsChooserPanel.setBounds(420, 210, 560, 450);
		add(symptomsChooserPanel);
		
//		JScrollPane scrollPane = new JScrollPane(symptomsChooserPanel);
//		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setBorder(BorderFactory.createEmptyBorder());
//        scrollPane.setBounds(420, 210, 560, 450);
//        getContentPane().setPreferredSize(new Dimension(1400, 800));
//        getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		next = new JButton("Next: Choose other symptoms >");
		next.setFont(new Font("Roboto", Font.PLAIN, 20));
		next.setOpaque(true);
		next.setBackground(Color.white);
		next.setForeground(new Color(21, 132, 121));
		next.setBounds(515, 680, 370, 50);
		next.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int count = 0;
				String selected = "";
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, next);
				
				//checks if user has chosen a symptom before moving to the next section
				for (int i = 0; i < symptoms.length; i++) {
					if (symptomsChooserPanel.getSymptomButtons()[i].isSelected()) {
						selected = symptomsChooserPanel.getSymptomButtons()[i].getText();
						count = 1;
					}
				}
				
				//if user has not, shows error message
				if (count != 1) {
					JOptionPane.showMessageDialog(parent, "Please choose a symptom to proceed.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				//otherwise, recursively calls part 2 of the detect diseases algorithm
				else {
					FindDiseasesController.setSelectedSymptom(selected.trim());
					
					parent.dispose();
					
					isSymptomSelected = true;
					
					if (isSymptomSelected) {
						
						//if more symptoms are available for user to choose, calls detect diseases
						if (FindDiseasesController.getAllDiseases().size() > 5) {
							
							FindDiseasesController.detectDiseasesPartTwo();
						}
						
						//otherwise, exits symptom checking and shows diseases diagnosed
						else {
							//10. Save and display the top 5 matched diseases	
							MainController.setCheckedOnce(true);
							
							//FileImportController.addUser(FindDiseasesController.getAllDiseases());
							
							//setting disease information
							
							//used to set proper indication of disease
							//depending if has a disease value or null
							String disease1 = "No disease diagnosed";
							String disease2 = "No disease diagnosed";
							String disease3 = "No disease diagnosed";
							
							if (FindDiseasesController.getAllDiseases().size() == 1) {
								disease1 = FindDiseasesController.getAllDiseases().get(0).getName();
							}
							
							else if (FindDiseasesController.getAllDiseases().size() == 2) {
								disease1 = FindDiseasesController.getAllDiseases().get(0).getName();
								disease2 = FindDiseasesController.getAllDiseases().get(1).getName();
							}
							
							else if (FindDiseasesController.getAllDiseases().size() >= 3) {
								disease1 = FindDiseasesController.getAllDiseases().get(0).getName();
								disease2 = FindDiseasesController.getAllDiseases().get(1).getName();
								disease3 = FindDiseasesController.getAllDiseases().get(2).getName();
							}
							
							//sets disease information
							MainController.getPatient().setDisease1(disease1);
							MainController.getPatient().setDisease2(disease2);
							MainController.getPatient().setDisease3(disease3);
							
							JOptionPane.showMessageDialog(parent, "Now, your potential diseases would be shown. Click Ok to proceed.",
		                            "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
							
							new MatchedPotentialDiseasesFrame(FindDiseasesController.getAllDiseases());
						}
						
					}
				}
			}
				
		});
		
		add(next);
		
		backgroundImageLabel.setBounds(0, 0, 1400, 800);
		add(backgroundImageLabel);
		
		setVisible(true);

	}
		
}	// end of SymptomsChooserFrame class
