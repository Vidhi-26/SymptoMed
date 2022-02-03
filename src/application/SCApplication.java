/*
 * Name: Vidhi Ruparel
 * 
 * Date of submission: January 18, 2022
 * 
 * Course Code: ICS4U1-03 Mr. Fernandes
 * 
 * Title: Final Summative Project, Symptom Checker Application, SYMPTOMED
 * 
 * Description: This application will assist users in finding the most likely disease or disorder they have. 
 * Users choose the body part with their most severe symptom and are prompted with a list of auto-generated
 * symptoms based on a potential diseases algorithm. As the user chooses symptoms, the algorithm diagnoses diseases.
 * The ultimate goal is to make a software program that people would truly find useful for diagnosis and 
 * detection of diseases they have, so that patients are aware and informed before they go to doctors for further 
 * diagnosis and treatment. 

 * 
 * Features: 
 * 1. GUI: The program runs as a GUI, and the GUI is well-designed, functional, attractive, and easy to use.
 * 
 * 2. A registration/login system: If the user is using the app for the first time, they are prompted to register. Otherwise, they must login. The user's information is stored.
 * 
 * 3. Survey Questions: The program asks the user for age, gender, weight, and height results to customize results
 * 
 * 4. Symptom prompter: Based on the symptom chosen by the user, an updated list of symptoms is generated and the user is prompted to choose more symptoms until the program identifies at least five possible diseases.
 * 
 * 5. More information: With each disease, basic information including what the disease is, causes, research, and treatment.
 * 
 * 6. Live links to websites: There is a link to a website with more detailed information about the disease for the user’s further reading.
 * 
 * 7. Producing a healthcare record: The program saves the user’s healthcare information and disease history so they can check the next time they login or show to their doctor.
 * 
 * Major skills: OOP, Data structures (Linked List, HashMap, Set, HashSet, ArrayList), Recursion, Swing package (Radiobuttons and box layout, Scrollable Panel, JTextFields and JPasswordFields), AWT Package, 
 * Reading, writing and editing .csv and .txt files, data collection of a broad range of data and data massaging, Time management 
 * 
 * Areas of concern: 
 * 1. files used: patients.txt to store users
 *  			  finalDiseases.csv to store database of diseases (symptoms, about, causes, treatments, links)
 *  
 * 2. The scroll panel does not load for the symptoms and disease information panels, so to solve the same, 
 * the user is warned beforehand that the scrolling feature is still is development.
 * 
 * 3. Sometimes, no diseases are diagnosed. For example, for a body part like breast, there is only one symptom in the Diseases data. 
 * It is highly likely that breast cancer was removed from consideration due to factors like age, bmi, and gender, thus it might not show up
 * unless the user enters highly specific information to breast cancer.
 * 
 * 4. As an extra feature, if I had more time, a button that allows the user to exit the symptom checker at any time 
 * was to be implemented.
 * 
 */


package application;


//imports
import controller.MainController;


/**
 * The Application class is where the program begins to run.
 */
public class SCApplication {

	public static void main(String[] args) {
		
		new MainController();
	}
}
