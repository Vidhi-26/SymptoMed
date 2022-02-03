/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Course: ICS4U1 Mr. Fernandes
 * Notes:
 */
package controller;


//imports
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import model.Disease;
import view.BodyPartsChooserFrame;
import view.HomeFrame;
import view.SymptomsChooserFrame;


/**
 * FindDiseasesController is the algorithm to find potential diseases
 * of user based on symptoms.
 */
public class FindDiseasesController {
	
	//instance variables
	//1. Declare and initialize a hashmap for allSymptoms, which contains all available symptoms
	private static HashMap<String, String> allSymptoms;
	
	//2. Declare and initialize a LinkedList for allDiseases, which contains all available diseases
	private static LinkedList<Disease> allDiseases;
	
	private static String selectedSymptom;
	
	
	//default constructor
	public FindDiseasesController() {
		
	}
	
	
	//getters and setters
	public static String getSelectedSymptom() {
		return selectedSymptom;
	}


	public static void setSelectedSymptom(String selectedSymptom) {
		FindDiseasesController.selectedSymptom = selectedSymptom;
	}
	
	public static HashMap<String, String> getAllSymptoms() {
		return allSymptoms;
	}


	public static void setAllSymptoms(HashMap<String, String> allSymptoms) {
		FindDiseasesController.allSymptoms = allSymptoms;
	}


	public static LinkedList<Disease> getAllDiseases() {
		return allDiseases;
	}


	public static void setAllDiseases(LinkedList<Disease> allDiseases) {
		FindDiseasesController.allDiseases = allDiseases;
	}


	//utility methods
	/*
	 * The algorithm begins here.
	 */
	public static void detectDiseases() {
		
		allDiseases = FileImportController.getAvailableDiseases();
		
		allSymptoms = FileImportController.getAvailableSymptoms();
		
		//3. Traverse through the allDiseases LinkedList
		for (int i = 0; i < allDiseases.size(); i++) {
			
			//3.1 If the disease is age-specific AND if the patient’s age is not within the age group the disease affects
			if (allDiseases.get(i).isAgeSpecific())	{
				
				if ((MainController.getPatient().getAge() < allDiseases.get(i).getMinAge())
						|| (MainController.getPatient().getAge() > allDiseases.get(i).getMaxAge())) {
					
					//3.1.1 Remove the disease from allDiseases
					allDiseases.remove(allDiseases.get(i));
				}
			}
			
			
			//3.2 If the disease is gender-specific AND if the patient’s gender is not affected by the disease
			else if (allDiseases.get(i).isGenderSpecific())	{
				
				if (Boolean.compare(MainController.getPatient().isGender(), allDiseases.get(i).isGender()) != 0) {
					
					//3.2.1 Remove the disease from allDiseases
					allDiseases.remove(allDiseases.get(i));
				}
			}
			
			
			//3.3 If the disease is BMI-specific AND if the patient’s BMI is not within the BMI range the disease affects
//			else if (allDiseases.get(i).isBmiSpecific())	{
//				
//				if ((MainController.getPatient().getBmi() < allDiseases.get(i).getMinBmi())
//						|| (MainController.getPatient().getBmi() > allDiseases.get(i).getMaxBmi())) {
//					
//					//3.3.1 Remove the disease from allDiseases
//					allDiseases.remove(allDiseases.get(i));
//				}
//			}
			
		}	// end of disease traversal for loop for age, gender and bmi
		
		
		//4. Display choices of body parts to the user, along with a textbox to type a symptom
		new BodyPartsChooserFrame();
			
	}	// end of detectDiseases method

	
	/*
	 * Rest of detectDiseases algorithm 
	 * It was broken into 2 parts as frames pop up dynamically in the second part
	 * which was interfering the first part.
	 * In other words, the frames in part 2 opened even before the part 1 finished executing.
	 */
	public static void detectDiseasesPartTwo() {
		
		LinkedList<Disease> newDiseases = new LinkedList<Disease>();
		
		//5. Repeat steps 6 through 9 until five diseases remain in allDisease
		
		//6. Traverse through allDiseases
		for (int i = 0; i < allDiseases.size(); i++) {
			
			//6.1 Finds symptoms based on user's body part chosen
			for (String key : allDiseases.get(i).getSymptoms().keySet()) {
				
				String keyTrim = key.trim();
				
				if (keyTrim.equals(selectedSymptom)) {
					newDiseases.add(allDiseases.get(i));
				}
			}
			
		}	// end of disease traversal for symptoms
		
		allDiseases.clear();
		allDiseases.addAll(newDiseases);
		
		//7. Remove all elements from allSymptoms
		allSymptoms.clear();
		
		
		//8. Create an updated list of symptoms by adding all symptoms that occur in diseases present in allDiseases into allSymptoms
		for (int i = 0; i < allDiseases.size(); i++) {
			
			allSymptoms.putAll(allDiseases.get(i).getSymptoms());
			
		}	// end of disease traversal for symptoms
		
		
		// 9. Display allSymptoms and prompt the user to choose another symptom
		String[] symptomsToDisplay = allSymptoms.keySet().toArray(new String[0]);
		
		if (symptomsToDisplay.length > 0) {
			new SymptomsChooserFrame(symptomsToDisplay);
		}
		else {
			allDiseases.removeAll(allDiseases);
			//FileImportController.addUser(FindDiseasesController.getAllDiseases());
			MainController.setCanFindDiseases(false);
			MainController.setCheckedOnce(true);
			new HomeFrame();
		}	
		
	}
	

	/*
	 * Based on user's body part chosen, find symptoms affecting that body part
	 * Then, return to SymptomsChooser frame where symptoms are displayed.
	 */
	public static Set<String> findSymptoms(String bodyPart) {
		
		Set<String> result = new HashSet<>();
		
		//find symptoms that occur in the body part entered by user
	      if (allSymptoms.containsValue(bodyPart)) {
	    	  
	          for (Map.Entry<String, String> entry : allSymptoms.entrySet()) {
	        	  
	              if (Objects.equals(entry.getValue(), bodyPart)) {
	                  result.add(entry.getKey());
	              }
	          }
	      }
	      
	      return result;
	}
	
}	// end of FindDiseasesController class
