/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Notes:
 */
package controller;


/**
 * LoginController checks proper login such as 
 * checking if user is already registered, or whether they entered correct password.
 */
public class LoginController {

	//utility methods
	/*
	 * Traverses through allPatients arraylist and checks if the user has already registered
	 * If so, it returns true. Otherwise, returns false to LoginPanel.
	 */
	public static boolean checkIfRegistered(String username) {
		
		for (int i = 0; i < FileImportController.getAllPatients().size(); i++) {
			if (FileImportController.getAllPatients().get(i).getUsername().equals(username))
				return true;	
		}
		
		return false;
	}
	
	
	/*
	 * Traverses through allPatients arraylist and checks if the user has entered correct password.
	 * If so, it returns true. Otherwise, returns false to LoginPanel.
	 */
	public static boolean checkCorrectPwd(String password, String username) {
		
		System.out.println(FileImportController.getAllPatients().size());
		
		for (int i = 0; i < FileImportController.getAllPatients().size(); i++) {
			
			if (FileImportController.getAllPatients().get(i).getUsername().equals(username)) {
				if (FileImportController.getAllPatients().get(i).getPassword().equals(password))
					return true;
			}
				
		}

		return false;
	}
	
	
	/*
	 * Assigns the current user to the Patient object from MainController
	 */
	public static void saveCurrentUser(String username) {
		
		for (int i = 0; i < FileImportController.getAllPatients().size(); i++) {
			
			//finds user from all patients by their username
			if (FileImportController.getAllPatients().get(i).getUsername().equals(username)) {
				MainController.setPatient(FileImportController.getAllPatients().get(i));
				
				if (MainController.isFlag()) {
					MainController.getPatient().setPassword(MainController.getPwdCheck2());
				}
			}
		}
	}
	
}	//end of LoginController class
