/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Notes:
 */
package view;


//imports
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import controller.FileImportController;
import controller.FindDiseasesController;
import controller.MainController;


/**
 * Shows health record of a patient
 * with basic information and 
 * top 3 diseases diagnosed the last time they logged in.
 */
@SuppressWarnings("serial")
public class HomeFrame extends JFrame {
	
	//instance variables
	private HeaderPanel headerPanel = new HeaderPanel();	//header
	private JButton logout;

	
	//constructor
	public HomeFrame() {
		
		setTitle("SymptoMed");
		setLayout(null);
		setSize(1400, 800);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		if (!MainController.isCanFindDiseases()) {
			JOptionPane.showMessageDialog(this, "Sorry, we could not match any diseases. Please try again with a different symptom.",
	                "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		}
		
		headerPanel.setBounds(0, 0, 1400, 75);
		headerPanel.setBackground(new Color(123, 234, 223));
		add(headerPanel);
		
		//adds the title
		JLabel title = new JLabel("Home - Health Record");
		title.setFont(new Font("Roboto", Font.PLAIN, 25));
		title.setBounds(600, 5, 500, 65);
		headerPanel.add(title);
		
		//adds logout button
		logout = new JButton("Logout");
		logout.setFont(new Font("Roboto", Font.PLAIN, 17));
		logout.setForeground(new Color(21, 132, 121));
		logout.setBorder(BorderFactory.createLineBorder(getForeground(), 1));
		logout.setBounds(1200, 100, 100, 50);
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, logout);
				JOptionPane.showMessageDialog(parent, "Successfully logged out. Press Ok to be redirected to our main page",
		                "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
				parent.dispose();
				FileImportController.addUser(FindDiseasesController.getAllDiseases());
				new LandingFrame();
			}
		});
		add(logout);
		
		//name
		JLabel name = new JLabel("Name: " + MainController.getPatient().getName());
		name.setBounds(333, 100, 233, 75);
		name.setFont(new Font("Roboto", Font.PLAIN, 18));
		name.setForeground(Color.black);
		name.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		add(name);
		
		//age
		JLabel age = new JLabel("Age: " + String.valueOf(MainController.getPatient().getAge()));
		age.setBounds(566, 100, 233, 75);
		age.setFont(new Font("Roboto", Font.PLAIN, 18));
		age.setForeground(Color.black);
		age.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		age.setHorizontalAlignment(SwingConstants.CENTER);
		add(age);
		
		//gender
		JLabel gender = new JLabel();
		if (MainController.getPatient().isGender())
			gender.setText("Gender: Male");
		else
			gender.setText("Gender: Female");
		gender.setBounds(799, 100, 233, 75);
		gender.setFont(new Font("Roboto", Font.PLAIN, 18));
		gender.setForeground(Color.black);
		gender.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		gender.setHorizontalAlignment(SwingConstants.CENTER);
		add(gender);
		
		//weight
		JLabel weight = new JLabel("Weight(lb): " + String.valueOf(MainController.getPatient().getWeight()));
		weight.setBounds(333, 200, 233, 75);
		weight.setFont(new Font("Roboto", Font.PLAIN, 18));
		weight.setForeground(Color.black);
		weight.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		weight.setBackground(new Color(145, 237, 228));
		weight.setHorizontalAlignment(SwingConstants.CENTER);
		add(weight);
		
		//height
		JLabel height = new JLabel("Height(in): " + String.valueOf(MainController.getPatient().getHeight()));
		height.setBounds(566, 200, 233, 75);
		height.setFont(new Font("Roboto", Font.PLAIN, 18));
		height.setForeground(Color.black);
		height.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		height.setBackground(new Color(145, 237, 228));
		height.setHorizontalAlignment(SwingConstants.CENTER);
		add(height);
		
		//bmi
		NumberFormat formatter = new DecimalFormat("#0.00");
		
		JLabel bmi = new JLabel("bmi: " + formatter.format(MainController.getPatient().getBmi()));
		bmi.setBounds(799, 200, 233, 75);
		bmi.setFont(new Font("Roboto", Font.PLAIN, 18));
		bmi.setForeground(Color.black);
		bmi.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		bmi.setBackground(new Color(145, 237, 228));
		bmi.setHorizontalAlignment(SwingConstants.CENTER);
		add(bmi);
		
		//pregnancy
		JLabel pregnancy = new JLabel();
		if (MainController.getPatient().isPregnant())
			pregnancy.setText("Pregnant: Yes");
		else
			pregnancy.setText("Pregnant: No");
		pregnancy.setBounds(333, 300, 233, 75);
		pregnancy.setFont(new Font("Roboto", Font.PLAIN, 18));
		pregnancy.setForeground(Color.black);
		pregnancy.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		pregnancy.setHorizontalAlignment(SwingConstants.CENTER);
		add(pregnancy);
		
		//smoking
		JLabel smoking = new JLabel();
		if (MainController.getPatient().isDoesSmoking())
			smoking.setText("Does smoking: Yes");
		else
			smoking.setText("Does smoking: No");
		smoking.setBounds(566, 300, 233, 75);
		smoking.setFont(new Font("Roboto", Font.PLAIN, 18));
		smoking.setForeground(Color.black);
		smoking.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		smoking.setHorizontalAlignment(SwingConstants.CENTER);
		add(smoking);
		
		//alcohol
		JLabel alcohol = new JLabel();
		if (MainController.getPatient().isConsumesAlcohol())
			alcohol.setText("Consumes alcohol: Yes");
		else
			alcohol.setText("Consumes alcohol: No");
		alcohol.setBounds(799, 300, 233, 75);
		alcohol.setFont(new Font("Roboto", Font.PLAIN, 18));
		alcohol.setForeground(Color.black);
		alcohol.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		alcohol.setHorizontalAlignment(SwingConstants.CENTER);
		add(alcohol);
		
		//diseases
		JLabel instruction = new JLabel("Last time you gave the SymptoMed quiz, your top 3 diseases diagnosed were: ");
		instruction.setBounds(200, 400, 1100, 50);
		instruction.setFont(new Font("Roboto", Font.PLAIN, 18));
		name.setForeground(Color.black);
		add(instruction);
		
		JLabel disease1 = new JLabel();
		
		if (MainController.getPatient().getDisease1() != null)
			disease1.setText("  " + MainController.getPatient().getDisease1());
		else
			disease1.setText("  No disease diagnosed yet");
	
		disease1.setBounds(200, 450, 1100, 50);
		disease1.setFont(new Font("Roboto", Font.PLAIN, 18));
		disease1.setForeground(Color.black);
		disease1.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		add(disease1);
		
		JLabel disease2 = new JLabel();
		
		if (MainController.getPatient().getDisease2() != null)
			disease2.setText("  " + MainController.getPatient().getDisease2());
		else
			disease2.setText("  No disease diagnosed yet");
		
		disease2.setBounds(200, 537, 1100, 50);
		disease2.setFont(new Font("Roboto", Font.PLAIN, 18));
		disease2.setForeground(Color.black);
		disease2.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		add(disease2);
		
		JLabel disease3 = new JLabel();
		
		if (MainController.getPatient().getDisease3() != null)
			disease3.setText("  " + MainController.getPatient().getDisease3());
		else
			disease3.setText("  No disease diagnosed yet");
		
		disease3.setBounds(200, 625, 1100, 50);
		disease3.setFont(new Font("Roboto", Font.PLAIN, 18));
		disease3.setForeground(Color.black);
		disease3.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		add(disease3);
		
		JButton next = new JButton("Click to begin symptom checker >");
		next.setFont(new Font("Roboto", Font.PLAIN, 17));
		next.setOpaque(true);
		next.setBackground(new Color(21, 132, 121));
		next.setForeground(Color.white);
		next.setBounds(500, 700, 500, 50);
		next.setBorder(BorderFactory.createEmptyBorder());
		
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				if (MainController.isCheckedOnce()) {
					MainController.setCanFindDiseases(true);
					new FileImportController();
				}
				
				new SurveyQuestionsFrame();
			}
		});
		
		add(next);
		
		setVisible(true);
		
		//utility messages for user
		JOptionPane.showMessageDialog(this, "Please view your health record. If this is your first time at SymptoMed, you "
				+ "will not see any information here.",
                "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		
		JOptionPane.showMessageDialog(this, "If you haven't already, please click the button given to begin checking your symptoms. "
				+ "Thank you for using SymptoMed - Where you come first.",
                "MESSAGE", JOptionPane.INFORMATION_MESSAGE);

	}
		
}	// end of HomeFrame class
