/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Course: ICS4U1 Mr. Fernandes
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.FindDiseasesController;
import controller.MainController;


/**
* Allows user to enter basic personal information (some of which helps customize results).
*/
@SuppressWarnings("serial")
public class SurveyQuestionsPanel extends JPanel {
	
	//instance variables
	private JLabel instruction;
	
	private JLabel ageGuideline;
	private JTextField age;
	
	private JLabel genderGuideline;
    private JRadioButton male;
    private JRadioButton female;
    private JRadioButton other;
	
	private JLabel weightGuideline;
	private JTextField weight;
	
	private JLabel heightGuideline;
	private JTextField height;
	
	private JLabel pregnancyGuideline;
	private JRadioButton pregnantYes;
	private JRadioButton pregnantNo;
	
	private JLabel smokingGuideline;
	private JRadioButton smokingYes;
	private JRadioButton smokingNo;
	
	private JLabel alcoholGuideline;
	private JRadioButton alcoholYes;
	private JRadioButton alcoholNo;
	
	private JButton next;
	
	
	//constructor
	public SurveyQuestionsPanel() {
		
		setLayout(null);
		setOpaque(false);
		
		//section 1: titles
		instruction = new JLabel("Step 1 of 5: Please answer these survey questions to help us identify your symptoms and conditions.");
		instruction.setFont(new Font("Roboto", Font.ITALIC, 19));
		instruction.setForeground(new Color(21, 132, 121));
		instruction.setBounds(30, 15, 970, 50);
		add(instruction);	
		
		ageGuideline = new JLabel("Please enter you age as a whole number.");
		ageGuideline.setFont(new Font("Roboto", Font.PLAIN, 19));
		ageGuideline.setBounds(30, 75, 970, 50);
		add(ageGuideline);
		
		genderGuideline = new JLabel("Please choose your gender.");
		genderGuideline.setFont(new Font("Roboto", Font.PLAIN, 19));
		genderGuideline.setBounds(30, 206, 970, 50);
		add(genderGuideline);
		
		weightGuideline = new JLabel("Please enter your weight (in pounds).");
		weightGuideline.setFont(new Font("Roboto", Font.PLAIN, 19));
		weightGuideline.setBounds(30, 317, 970, 50);
		add(weightGuideline);
		
		heightGuideline = new JLabel("Please enter your height (in inches).");
		heightGuideline.setFont(new Font("Roboto", Font.PLAIN, 19));
		heightGuideline.setBounds(30, 448, 970, 50);
		add(heightGuideline);
		
		pregnancyGuideline = new JLabel("Are you pregnant?");
		pregnancyGuideline.setFont(new Font("Roboto", Font.PLAIN, 19));
		pregnancyGuideline.setBounds(600, 75, 970, 50);
		add(pregnancyGuideline);
		
		smokingGuideline = new JLabel("Do you smoke regularly?");
		smokingGuideline.setFont(new Font("Roboto", Font.PLAIN, 19));
		smokingGuideline.setBounds(600, 206, 970, 50);
		add(smokingGuideline);
		
		alcoholGuideline = new JLabel("Do you drink alcohol regularly?");
		alcoholGuideline.setFont(new Font("Roboto", Font.PLAIN, 19));
		alcoholGuideline.setBounds(600, 317, 970, 50);
		add(alcoholGuideline);
		
		
		//section 2: user's information
		age = new JTextField("");
		age.setFont(new Font("Roboto", Font.PLAIN, 19));
		age.setForeground(Color.gray);
		age.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		age.setBounds(30, 125, 100, 50);
		add(age);
		
		weight = new JTextField("");
		weight.setFont(new Font("Roboto", Font.PLAIN, 19));
		weight.setForeground(Color.gray);
		weight.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		weight.setBounds(30, 367, 400, 50);
		add(weight);
		
		height = new JTextField("");
		height.setFont(new Font("Roboto", Font.PLAIN, 19));
		height.setForeground(Color.gray);
		height.setBorder(BorderFactory.createLineBorder(new Color(21, 132, 121), 1));
		height.setBounds(30, 498, 400, 50);
		add(height);
		
		//gender
		male = new JRadioButton(" Male");
		male.setFont(new Font("Roboto", Font.PLAIN, 19));
		male.setForeground(new Color(21, 132, 121));
		
	    female = new JRadioButton(" Female");
	    female.setFont(new Font("Roboto", Font.PLAIN, 19));
	    female.setForeground(new Color(21, 132, 121));
	    
	    other = new JRadioButton(" Other");
	    other.setFont(new Font("Roboto", Font.PLAIN, 19));
	    other.setForeground(new Color(21, 132, 121));
	    
	    Box genderBox = Box.createHorizontalBox();
	    genderBox.add(male);
	    genderBox.add(female);
	    genderBox.add(other);
	    genderBox.setBounds(30, 256, 300, 50);
		add(genderBox);
	    
	    ButtonGroup genderHolder = new ButtonGroup();
	    genderHolder.add(male);
	    genderHolder.add(female);
	    genderHolder.add(other);
	    
	    //pregnancy
		pregnantYes = new JRadioButton(" Yes");
		pregnantYes.setFont(new Font("Roboto", Font.PLAIN, 19));
		pregnantYes.setForeground(new Color(21, 132, 121));
		
	    pregnantNo = new JRadioButton(" No");
	    pregnantNo.setFont(new Font("Roboto", Font.PLAIN, 19));
	    pregnantNo.setForeground(new Color(21, 132, 121));
	    
	    Box pregnantBox = Box.createHorizontalBox();
	    pregnantBox.add(pregnantYes);
	    pregnantBox.add(pregnantNo);
	    pregnantBox.setBounds(600, 125, 200, 50);
		add(pregnantBox);
	    
	    ButtonGroup pregnantHolder = new ButtonGroup();
	    pregnantHolder.add(pregnantYes);
	    pregnantHolder.add(pregnantNo);
	    
	    //smoking
		smokingYes = new JRadioButton(" Yes");
		smokingYes.setFont(new Font("Roboto", Font.PLAIN, 19));
		smokingYes.setForeground(new Color(21, 132, 121));
		
	    smokingNo = new JRadioButton(" No");
	    smokingNo.setFont(new Font("Roboto", Font.PLAIN, 19));
	    smokingNo.setForeground(new Color(21, 132, 121));
	    
	    Box smokingBox = Box.createHorizontalBox();
	    smokingBox.add(smokingYes);
	    smokingBox.add(smokingNo);
	    smokingBox.setBounds(600, 256, 200, 50);
		add(smokingBox);
	    
	    ButtonGroup smokingHolder = new ButtonGroup();
	    smokingHolder.add(smokingYes);
	    smokingHolder.add(smokingNo);
	    
	    //alcohol
		alcoholYes = new JRadioButton(" Yes");
		alcoholYes.setFont(new Font("Roboto", Font.PLAIN, 19));
		alcoholYes.setForeground(new Color(21, 132, 121));
		
	    alcoholNo = new JRadioButton(" No");
	    alcoholNo.setFont(new Font("Roboto", Font.PLAIN, 19));
	    alcoholNo.setForeground(new Color(21, 132, 121));
	    
	    Box alcoholBox = Box.createHorizontalBox();
	    alcoholBox.add(alcoholYes);
	    alcoholBox.add(alcoholNo);
	    alcoholBox.setBounds(600, 367, 200, 50);
		add(alcoholBox);
	    
	    ButtonGroup alcoholHolder = new ButtonGroup();
	    alcoholHolder.add(alcoholYes);
	    alcoholHolder.add(alcoholNo);
	    
	    next = new JButton("Next: Choose body part >");
		next.setFont(new Font("Roboto", Font.PLAIN, 17));
		next.setOpaque(true);
		next.setBackground(new Color(21, 132, 121));
		next.setForeground(Color.white);
		next.setBounds(600, 498, 370, 50);
		next.setBorder(BorderFactory.createEmptyBorder());
		
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame parent = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, next);
				
				//if fields are empty, errors are shown
				if (age.getText().isEmpty() || weight.getText().isEmpty() || height.getText().isEmpty()) {
					JOptionPane.showMessageDialog(parent, "A required field is incomplete. Please check again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (!male.isSelected() && !female.isSelected() && !other.isSelected()) 
					JOptionPane.showMessageDialog(parent, "A required field is incomplete. Please check again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				
				else if (!pregnantYes.isSelected() && !pregnantNo.isSelected())
					JOptionPane.showMessageDialog(parent, "A required field is incomplete. Please check again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				
				else if (!smokingYes.isSelected() && !smokingNo.isSelected())
					JOptionPane.showMessageDialog(parent, "A required field is incomplete. Please check again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				
				else if (!alcoholYes.isSelected() && !alcoholNo.isSelected())
					JOptionPane.showMessageDialog(parent, "A required field is incomplete. Please check again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				
				//shows error if user enters string, characters, or age below 1/above 100
				else if (!checkIntegerBounds(age.getText())) {
					JOptionPane.showMessageDialog(parent, "Invalid age. Please check again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					age.setText("");
				}
				
				//shows error if user enters string, characters, or weight below 1/above 974
				else if (!checkWeightBounds(weight.getText())) {
					JOptionPane.showMessageDialog(parent, "Invalid weight. Please check again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					weight.setText("");
				}
				 
				//shows error if user enters string, characters, or height below 1/above 100
				else if (!checkHeightBounds(height.getText())) {
					JOptionPane.showMessageDialog(parent, "Invalid height. Please check again.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					height.setText("");
				}
				
				else {
					parent.dispose();

					//calculates bmi
				    double bmi = (Double.valueOf(weight.getText()) / Math.pow(Double.valueOf(height.getText()), 2)) * 703;
				    
				    //saves user information in current user
				    MainController.getPatient().setAge(Integer.valueOf(age.getText()));
				    MainController.getPatient().setGender(male.isSelected());
				    MainController.getPatient().setWeight(Double.valueOf(weight.getText()));
				    MainController.getPatient().setHeight(Double.valueOf(height.getText()));
				    MainController.getPatient().setBmi(bmi);
				    
				    MainController.getPatient().setPregnant(pregnantYes.isSelected());
				    MainController.getPatient().setDoesSmoking(smokingYes.isSelected());
				    MainController.getPatient().setConsumesAlcohol(alcoholYes.isSelected());
				    
//				    try {
//					    
//					    Scanner myReader = new Scanner("./files/patients.txt");
//					      
//					    while (myReader.hasNextLine()) {
//					    	String data = myReader.nextLine();
//					        String[] arrData = data.split("[,]", 0);
//					        
//					        if (MainController.getPatient().getUsername().equals(arrData[0])) {
//					        	
//					        	FileWriter myWriter = new FileWriter("./files/patients.txt", true);
//							    
//					        	
//					        	
//							    age.write(myWriter);
//							    myWriter.write(",");
//							    myWriter.write(String.valueOf(male.isSelected()));
//							    myWriter.write(",");
//							    
//							    weight.write(myWriter);
//							    myWriter.write(",");
//							    height.write(myWriter);
//							    myWriter.write(",");
//							    myWriter.write(String.valueOf(bmi));
//							    myWriter.write(",");
//							    myWriter.write(String.valueOf(pregnantYes.isSelected()));
//							    myWriter.write(",");
//							    myWriter.write(String.valueOf(smokingYes.isSelected()));
//							    myWriter.write(",");
//							    myWriter.write(String.valueOf(alcoholYes.isSelected()));
//							    myWriter.write("\n");
//							    
//					        }
//					    }
//					  
//					    myWriter.close();
//					    
//					    System.out.println("Successfully wrote to the file again.");
//					    
//					  } catch (IOException e1) {
//					  	
//					    System.out.println("An error occurred.");
//					    e1.printStackTrace();
//					    
//					  }
				    
				    FindDiseasesController.detectDiseases();
				}
				
			}
		});
		
		add(next);
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
       
    }
	
	/*
	 * Checks and returns true if the age entered by the user is an integer from 1 to 100
	 * Otherwise, returns false
	 */
    private boolean checkIntegerBounds(String text) {
        
    	try {
           
           if (Integer.parseInt(text) > 0 && Integer.parseInt(text) <= 100)
           		return true;
           else 
           		return false;
           
        	} catch (NumberFormatException e) {
        	
        		return false;
           
        	}
     }
    
    /*
     * Checks and returns true if the weight entered by the user is a double from 1 to 974
	 * Otherwise, returns false
     */
    private boolean checkWeightBounds(String text) {
        
    	try {
    		
            if (Double.parseDouble(text) > 0.0 && Double.parseDouble(text) <= 974.0)
            	return true;
            else
            	return false;
            
        	} catch (Exception e) {
    	   
        		return false;
             
        	}
     }
    
    /*
     * Checks and returns true if the height entered by the user is a double from 1 to 100
	 * Otherwise, returns false
     */
    private boolean checkHeightBounds(String text) {
        
    	try {
    		
            if (Double.parseDouble(text) > 0.0 && Double.parseDouble(text) <= 108.0)
            	return true;
            else
            	return false;
            
        	} catch (Exception e) {
    	   
        		return false;
             
        	}
     }
    
	
}	//end of SurveyQuestionsPanel class
