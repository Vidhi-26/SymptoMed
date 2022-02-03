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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.FileImportController;
import controller.FindDiseasesController;
import controller.MainController;
import model.Disease;


/**
 * Loads frame that shows body parts a radiobuttons for user to choose.
 */
@SuppressWarnings("serial")
public class BodyPartsChooserFrame extends JFrame {
	
	//instance variables
	private HeaderPanel headerPanel = new HeaderPanel();	//header
	private BodyPartsChooserPanel bodyPartsChooserPanel;
	private JLabel instruction;
	private JLabel backgroundImageLabel = new JLabel(new ImageIcon("./images/dna.jpg"));
	private JButton next;

	
	//constructor
	public BodyPartsChooserFrame() {
		
		setTitle("SymptoMed");
		setLayout(null);
		setSize(1400, 800);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//adding header panel
		headerPanel.setBounds(0, 0, 1400, 75);
		add(headerPanel);

		//adds the title
		JLabel title = new JLabel("Body Parts Chooser");
		title.setFont(new Font("Roboto", Font.PLAIN, 25));
		title.setBounds(600, 5, 500, 65);
		headerPanel.add(title);
		
		//adding instruction
		instruction = new JLabel(" Step 2 of 5: Please choose the body part with your MOST severe symptom. This helps us find your disease accurately.");
		instruction.setFont(new Font("Roboto", Font.ITALIC, 18));
		instruction.setOpaque(true);
		instruction.setBackground(Color.white);
		instruction.setForeground(new Color(21, 132, 121));
		instruction.setBounds(150, 120, 1050, 50);
		instruction.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		add(instruction);
		
		//opens main panel
		bodyPartsChooserPanel = new BodyPartsChooserPanel();
		bodyPartsChooserPanel.setBounds(420, 210, 560, 450);
		add(bodyPartsChooserPanel);
		
		//button to proceed to next screen
		next = new JButton("Next: Choose your symptoms >");
		next.setFont(new Font("Roboto", Font.PLAIN, 20));
		next.setOpaque(true);
		next.setBackground(Color.white);
		next.setForeground(new Color(21, 132, 121));
		next.setBounds(515, 670, 370, 50);
		next.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int count = 0;
				String selected = "";
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, next);
				
				//checks if body part is selected
				for (int i = 0; i < 17; i++) {
					if (bodyPartsChooserPanel.getBodyPartsButtons()[i].isSelected()) {
						selected = bodyPartsChooserPanel.getBodyPartsButtons()[i].getText();
						count = 1;
					}
				}
				
				//if it is not selected, shows error message
				if (count != 1) {
					JOptionPane.showMessageDialog(parent, "Please choose a body part to proceed.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				//if selected, loads next screen
				else {
					
					Set<String> result = new HashSet<>();
							
					result = FindDiseasesController.findSymptoms(selected.trim());
					
					String[] symptomsPassed = result.toArray(new String[result.size()]);
					parent.dispose();
					
					if (symptomsPassed.length > 0) {
						new SymptomsChooserFrame(symptomsPassed);
						//utility messages for next screen
						JOptionPane.showMessageDialog(parent, "You may choose a symptom already chosen another time. "
								+ "It will help us strengthen our results for greater accuracy.",
	                            "TIP", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(parent, "We are currently working on the scroll feature so you can"
								+ " see all symptoms. Thank you for your patience!",
	                            "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						
						//goes to home frame if no symptoms load up for the body part the user chose
						LinkedList<Disease> temp = new LinkedList<Disease>();
						
						FindDiseasesController.setAllDiseases(temp);
						
						//adds user to patients file
						//FileImportController.addUser(FindDiseasesController.getAllDiseases());
						MainController.setCanFindDiseases(false);
						new HomeFrame();
					}
				}
			}
				
		});
		
		add(next);
		
		backgroundImageLabel.setBounds(0, 0, 1400, 800);
		add(backgroundImageLabel);
		
		setVisible(true);

	}
		
}	// end of BodyPartsChooserFrame class