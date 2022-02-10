/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Notes:
 */
package controller;


import model.Disease;
//imports
import model.Patient;
import view.LandingFrame;


/**
 * The program loads up from here.
 * It contains utility variables.
 */
public class MainController {
	
	//instance variables
	//accessed by all classes - it is the current user
	private static Patient patient = new Patient();

	//extra variables for checking user login and password 
	private static String userCheck = "";
	private static String pwdCheck = "";
	private static String pwdCheck2 = "";
	private static boolean flag = false;
	
	//extra variables for checking if the user is using the symptom checker multiple times during one login attempt
	private static boolean canFindDiseases = true;
	private static boolean checkedOnce = false;							//Added this variable in the update version

	LandingFrame landingFrame;

	
	//constructor
	public MainController() {
		
		//reads data from files to arrays, linked lists, and hashmaps
		new FileImportController();
		
		//begins loading the screens
		landingFrame = new LandingFrame();
		
	}
	

	//getters and setters
	public static Patient getPatient() {
		return patient;
	}
	
	public static void setPatient(Patient patient) {
		MainController.patient = patient;
	}

	public static boolean isCanFindDiseases() {
		return canFindDiseases;
	}

	public static void setCanFindDiseases(boolean canFindDiseases) {
		MainController.canFindDiseases = canFindDiseases;
	}

	public static String getPwdCheck() {
		return pwdCheck;
	}

	public static void setPwdCheck(String pwdCheck) {
		MainController.pwdCheck = pwdCheck;
	}

	public static String getPwdCheck2() {
		return pwdCheck2;
	}

	public static void setPwdCheck2(String pwdCheck2) {
		MainController.pwdCheck2 = pwdCheck2;
	}

	public static boolean isFlag() {
		return flag;
	}

	public static void setFlag(boolean flag) {
		MainController.flag = flag;
	}

	public static String getUserCheck() {
		return userCheck;
	}

	public static void setUserCheck(String userCheck) {
		MainController.userCheck = userCheck;
	}
	
	public static boolean isCheckedOnce() {
		return checkedOnce;
	}

	public static void setCheckedOnce(boolean checkedOnce) {
		MainController.checkedOnce = checkedOnce;
	}
	
}
