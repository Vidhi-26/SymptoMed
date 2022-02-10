/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Notes:
 */
package controller;


//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import model.Disease;
import model.Patient;


/**
 * FileImportController class imports all diseases data from finalDiseases.csv.
 * It imports (and exports) patients' data in patients.txt.
 */
public class FileImportController {
	
	//instance variables
	private static HashMap<String, String> availableSymptoms = new HashMap<String, String>();
	private static LinkedList<Disease> availableDiseases = new LinkedList<Disease>();
	private static ArrayList<Patient> allPatients;
	private final static String FILE_TO_ACCESS = "./files/patients.txt";
	
	
	//constructor
	public FileImportController() {
		
		String[] solution = new String[2];
		int count = 0;
		
		try {
			Scanner sc = new Scanner(new File("./files/finalDiseases.csv"));
			
			sc.useDelimiter(",");
			
			while (sc.hasNextLine()) {
				
				HashMap<String, String> diseaseSymptoms = new HashMap<String, String>();
				
				Disease disease = new Disease();
				
				//used to shift the cursor in the file to the next line
				if (count == 0)
					disease.setName(sc.next());
				else 
					disease.setName(solution[1]);
				
				//inputting information from csv file to a linked list of all diseases
				for (int i = 0; i < 5; i++)
					diseaseSymptoms.put(sc.next(), sc.next());
				
				availableSymptoms.putAll(diseaseSymptoms);
				disease.setSymptoms(diseaseSymptoms);
				
				disease.setAbout(sc.next());
				disease.setCauses(sc.next());
				disease.setTreatments(sc.next());
				disease.setWebLink(sc.next());
				
				disease.setAgeSpecific(sc.nextBoolean());
				disease.setMinAge(sc.nextInt());
				disease.setMaxAge(sc.nextInt());
				
				disease.setGenderSpecific(sc.nextBoolean());
				disease.setGender(sc.nextBoolean());
				
				disease.setBmiSpecific(sc.nextBoolean());
				disease.setMinBmi(sc.nextDouble());
				
				disease.setMaxBmi(sc.nextDouble());
				
				disease.setPregnancySpecific(sc.nextBoolean());
				disease.setSmokingSpecific(sc.nextBoolean());
				
				String problem = sc.next();
				solution = problem.split("\n");
				disease.setAlcoholSpecific(Boolean.parseBoolean(solution[0]));
				
				//adding each disease to the diseases linked list
				availableDiseases.add(disease);
				
				//keeps track of diseases read from file
				count++;
			
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//calls the method that imports patient data
		importUsers();
		
	}

	
	//getters and setters
	public static HashMap<String, String> getAvailableSymptoms() {
		return availableSymptoms;
	}
	
	public static void setAvailableSymptoms(HashMap<String, String> availableSymptoms) {
		FileImportController.availableSymptoms = availableSymptoms;
	}
	
	public static LinkedList<Disease> getAvailableDiseases() {
		return availableDiseases;
	}
	
	public static void setAvailableDiseases(LinkedList<Disease> availableDiseases) {
		FileImportController.availableDiseases = availableDiseases;
	}
	
	public static ArrayList<Patient> getAllPatients() {
		return allPatients;
	}

	public static void setAllPatients(ArrayList<Patient> allPatients) {
		FileImportController.allPatients = allPatients;
	}


	//utility methods
	/*
	 * Reads patients data from patients.text
	 */
	private static void importUsers() {
		
		allPatients = new ArrayList<Patient>();
		
		try {
		      File usersFile = new File(FILE_TO_ACCESS);
		      Scanner myReader = new Scanner(usersFile);
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        
		        String[] arrData = data.split("[,]", 1000);
		        
		        //creates a patient object
		        Patient patient = new Patient();
		        
		        //inputs all information from file to patient
		        patient.setUsername(arrData[0]);
		        patient.setPassword(arrData[1]);
		        
		        patient.setName(arrData[2]);
		        patient.setAdressLine(arrData[3]);
		        patient.setCity(arrData[4]);
		        patient.setProvince(arrData[5]);
		        patient.setPostalCode(arrData[6]);
		        
		        patient.setAge(Integer.parseInt(arrData[7]));
		        patient.setGender(Boolean.parseBoolean(arrData[8]));
		        patient.setWeight(Double.parseDouble(arrData[9]));
		        patient.setHeight(Double.parseDouble(arrData[10]));
		        patient.setBmi(Double.parseDouble(arrData[11]));
		        
		        patient.setPregnant(Boolean.parseBoolean(arrData[12]));
		        patient.setDoesSmoking(Boolean.parseBoolean(arrData[13]));
		        patient.setConsumesAlcohol(Boolean.parseBoolean(arrData[14]));
		        
		        patient.setDisease1(arrData[15]);
		        patient.setDisease2(arrData[16]);
		        patient.setDisease3(arrData[17]);
		        
		        //adds patient to an arraylist of all patients
		        allPatients.add(patient);
		        
		      }
		      
		      myReader.close();
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}	// end of importUsers methos
	
	
	/*
	 * At the end of the program, this method writes or updates the current
	 * patient's data in the patients file.
	 */
	public static void addUser(LinkedList<Disease> diseases) {
		
		//used to set proper indication of disease
		//depending if has a disease value or null
		String disease1 = "No disease diagnosed";
		String disease2 = "No disease diagnosed";
		String disease3 = "No disease diagnosed";
		
		if (diseases.size() == 1) {
			disease1 = diseases.get(0).getName();
		}
		
		else if (diseases.size() == 2) {
			disease1 = diseases.get(0).getName();
			disease2 = diseases.get(1).getName();
		}
		
		else if (diseases.size() >= 3) {
			disease1 = diseases.get(0).getName();
			disease2 = diseases.get(1).getName();
			disease3 = diseases.get(2).getName();
		}
		
		//sets disease information
		MainController.getPatient().setDisease1(disease1);
		MainController.getPatient().setDisease2(disease2);
		MainController.getPatient().setDisease3(disease3);
		
		if (allPatients.size() == 0) {
			allPatients.add(MainController.getPatient());
		}
		
		else {
			
			boolean isCurrentUserInserted = false;
			
			for (int i = 0; i < allPatients.size(); i++) {
				
				//finds the current user in allPatients and updates their information
				if (allPatients.get(i).getUsername().equals(MainController.getPatient().getUsername())) {
					
					isCurrentUserInserted = true;
					
					allPatients.get(i).setPassword(MainController.getPatient().getPassword());
					
					allPatients.get(i).setName(MainController.getPatient().getName());
					allPatients.get(i).setAdressLine(MainController.getPatient().getAdressLine());
					allPatients.get(i).setCity(MainController.getPatient().getCity());
					allPatients.get(i).setProvince(MainController.getPatient().getProvince());
					allPatients.get(i).setPostalCode(MainController.getPatient().getPostalCode());
					
					allPatients.get(i).setAge(MainController.getPatient().getAge());
					allPatients.get(i).setGender(MainController.getPatient().isGender());
					allPatients.get(i).setWeight(MainController.getPatient().getWeight());
					allPatients.get(i).setHeight(MainController.getPatient().getHeight());
					allPatients.get(i).setBmi(MainController.getPatient().getBmi());
					
					allPatients.get(i).setPregnant(MainController.getPatient().isPregnant());
					allPatients.get(i).setDoesSmoking(MainController.getPatient().isDoesSmoking());
					allPatients.get(i).setConsumesAlcohol(MainController.getPatient().isConsumesAlcohol());
					
					allPatients.get(i).setDisease1(MainController.getPatient().getDisease1());
					allPatients.get(i).setDisease2(MainController.getPatient().getDisease2());
					allPatients.get(i).setDisease3(MainController.getPatient().getDisease3());
				}	
			}
			
			//if the user is registering for the first time
			if (!isCurrentUserInserted) {
				allPatients.add(MainController.getPatient());
			}
		}
		
		
		try {
		      //removes all data from file
		      flushFileContents();
			
		      FileWriter myWriter = new FileWriter(FILE_TO_ACCESS, true);
		      
		      //adds contents of allPatients into file
		      for (int i = 0; i < allPatients.size(); i++) {
		    	  
		    	  myWriter.write(allPatients.get(i).getUsername() + "," 
		    			  + allPatients.get(i).getPassword() + ","
		    			  + allPatients.get(i).getName() + ","
		    			  + allPatients.get(i).getAdressLine() + ","
		    			  + allPatients.get(i).getCity() + ","
		    			  + allPatients.get(i).getProvince() + "," 
		    			  + allPatients.get(i).getPostalCode() + ","
		    			  + allPatients.get(i).getAge() + ","
		    			  + allPatients.get(i).isGender() + ","
		    			  + allPatients.get(i).getWeight() + ","
		    			  + allPatients.get(i).getHeight() + ","
		    			  + allPatients.get(i).getBmi() + "," 
		    			  + allPatients.get(i).isPregnant() + ","
		    			  + allPatients.get(i).isDoesSmoking() + ","
		    			  + allPatients.get(i).isConsumesAlcohol() + ","
		    			  + allPatients.get(i).getDisease1() + ","
		    			  + allPatients.get(i).getDisease2() + ","
		    			  + allPatients.get(i).getDisease3() + "\n");
		      }
		      
		      myWriter.close();
		      
		      System.out.println("Successfully wrote to the file at the end.");
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	/*
	 * Clears file contents
	 */
	private static void flushFileContents() {
		
		PrintWriter writer;
		
		try {
			writer = new PrintWriter(FILE_TO_ACCESS);
			writer.print("");
			writer.close();
			
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}	//	end of FileImportController class

