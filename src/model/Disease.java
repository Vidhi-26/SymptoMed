/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Notes:
 */
package model;


//imports
import java.util.HashMap;


/**
 * The Disease class is a template class for a disease.
 * It includes instance variables, constructor, getters and setters, and toString method.
 */
public class Disease {
	
	//instance variables
	private String name;
	private HashMap<String, String> symptoms;
	private String about;
	private String causes;
	private String treatments;
	private String webLink;
	
	private boolean ageSpecific;	//true for particular age-group, false if general disease
	private int minAge;
	private int maxAge;
	
	private boolean genderSpecific;	//true for disease affecting some genders, otherwise false
	private boolean gender;			//true for male, false for female
	
	private boolean bmiSpecific;	//true for disease affecting overweight people, otherwise false
	private double minBmi;
	private double maxBmi;
	
	private boolean pregnancySpecific;
	private boolean smokingSpecific;
	private boolean alcoholSpecific;
	
	
	//constructor
	//default constructor
	public Disease() {
		
	}
	
	//overloaded constructor
	public Disease(String name, HashMap<String, String> symptoms, String about, String causes, String treatments, 
			String webLink, boolean ageSpecific, int minAge, int maxAge, boolean genderSpecific,
			boolean gender, boolean bmiSpecific, double minBmi, double maxBmi, boolean pregnancySpecific, boolean smokingSpecific, boolean alcoholSpecific) {
		super();
		this.name = name;
		this.symptoms = symptoms;
		this.about = about;
		this.causes = causes;
		this.treatments = treatments;
		this.webLink = webLink;
		this.ageSpecific = ageSpecific;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.genderSpecific = genderSpecific;
		this.gender = gender;
		this.bmiSpecific = bmiSpecific;
		this.minBmi = minBmi;
		this.maxBmi = maxBmi;
		this.pregnancySpecific = pregnancySpecific;
		this.smokingSpecific = smokingSpecific;
		this.alcoholSpecific = alcoholSpecific;
	}


	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public HashMap<String, String> getSymptoms() {
		return symptoms;
	}
	
	public void setSymptoms(HashMap<String, String> symptoms) {
		this.symptoms = symptoms;
	}
	
	public String getAbout() {
		return about;
	}
	
	public void setAbout(String about) {
		this.about = about;
	}
	
	public String getCauses() {
		return causes;
	}
	
	public void setCauses(String causes) {
		this.causes = causes;
	}
	
	public String getTreatments() {
		return treatments;
	}
	
	public void setTreatments(String treatments) {
		this.treatments = treatments;
	}
	
	public String getWebLink() {
		return webLink;
	}
	
	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}
		
	public boolean isAgeSpecific() {
		return ageSpecific;
	}
	
	public void setAgeSpecific(boolean ageSpecific) {
		this.ageSpecific = ageSpecific;
	}
	
	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public boolean isGenderSpecific() {
		return genderSpecific;
	}

	public void setGenderSpecific(boolean genderSpecific) {
		this.genderSpecific = genderSpecific;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public boolean isBmiSpecific() {
		return bmiSpecific;
	}

	public void setBmiSpecific(boolean bmiSpecific) {
		this.bmiSpecific = bmiSpecific;
	}

	public double getMinBmi() {
		return minBmi;
	}

	public void setMinBmi(double minBmi) {
		this.minBmi = minBmi;
	}

	public double getMaxBmi() {
		return maxBmi;
	}

	public void setMaxBmi(double maxBmi) {
		this.maxBmi = maxBmi;
	}

	public boolean isPregnancySpecific() {
		return pregnancySpecific;
	}

	public void setPregnancySpecific(boolean pregnancySpecific) {
		this.pregnancySpecific = pregnancySpecific;
	}

	public boolean isSmokingSpecific() {
		return smokingSpecific;
	}

	public void setSmokingSpecific(boolean smokingSpecific) {
		this.smokingSpecific = smokingSpecific;
	}

	public boolean isAlcoholSpecific() {
		return alcoholSpecific;
	}

	public void setAlcoholSpecific(boolean alcoholSpecific) {
		this.alcoholSpecific = alcoholSpecific;
	}

	
	//toString method
	@Override
	public String toString() {
		return "Disease [name=" + name + ", symptoms=" + symptoms + ", about=" + about + ", causes=" + causes
				+ ", treatments=" + treatments + ", webLink=" + webLink + ", ageSpecific=" + ageSpecific + ", minAge="
				+ minAge + ", maxAge=" + maxAge + ", genderSpecific=" + genderSpecific + ", gender=" + gender
				+ ", bmiSpecific=" + bmiSpecific + ", minBmi=" + minBmi + ", maxBmi=" + maxBmi + ", pregnancySpecific="
				+ pregnancySpecific + ", smokingSpecific=" + smokingSpecific + ", alcoholSpecific=" + alcoholSpecific
				+ "]";
	}

	
}	// end of Disease class
