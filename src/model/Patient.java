/*
 * Name: Vidhi Ruparel
 * Date: January 10, 2022
 * Course: ICS4U1 Mr. Fernandes
 * Notes:
 */
package model;


/**
 * Template class for Patient object.
 */
public class Patient {
	
	//instance variables
	
	//username and password
	private String username;
	private String password;
	
	//basic information (name and address)
	private String name;
	private String adressLine;
	private String city;
	private String province;
	private String postalCode;
	
	//answers to survey questions part 1
	private int age;
	private boolean gender;
	private double weight;
	private double height;
	private double bmi;
	
	//answers to survey questions part 2
	private boolean pregnant;
	private boolean doesSmoking;
	private boolean consumesAlcohol;
	
	//diseases experienced
	private String disease1;
	private String disease2;
	private String disease3;
	
	
	//constructors
	//default constructor
	public Patient() {
		
	}
	
	//overloaded constructor
	public Patient(String username, String password, String name, String adressLine, String city, String province,
			String postalCode, int age, boolean gender, double weight, double height, double bmi, boolean pregnant,
			boolean doesSmoking, boolean consumesAlcohol, String disease1, String disease2, String disease3) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.adressLine = adressLine;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.age = age;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.bmi = bmi;
		this.pregnant = pregnant;
		this.doesSmoking = doesSmoking;
		this.consumesAlcohol = consumesAlcohol;
		this.disease1 = disease1;
		this.disease2 = disease2;
		this.disease3 = disease3;
	}
	
	//getters and setters
	
	//username and password
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	//basic information (name and address)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAdressLine() {
		return adressLine;
	}
	
	public void setAdressLine(String adressLine) {
		this.adressLine = adressLine;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	//answers to survey questions part 1
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isGender() {
		return gender;
	}
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getBmi() {
		return bmi;
	}
	
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	
	//answers to survey questions part 2
	public boolean isPregnant() {
		return pregnant;
	}
	
	public void setPregnant(boolean pregnant) {
		this.pregnant = pregnant;
	}
	
	public boolean isDoesSmoking() {
		return doesSmoking;
	}
	
	public void setDoesSmoking(boolean doesSmoking) {
		this.doesSmoking = doesSmoking;
	}
	
	public boolean isConsumesAlcohol() {
		return consumesAlcohol;
	}
	
	public void setConsumesAlcohol(boolean consumesAlcohol) {
		this.consumesAlcohol = consumesAlcohol;
	}
	
	//diseases experienced
	public String getDisease1() {
		return disease1;
	}

	public void setDisease1(String disease1) {
		this.disease1 = disease1;
	}

	public String getDisease2() {
		return disease2;
	}

	public void setDisease2(String disease2) {
		this.disease2 = disease2;
	}

	public String getDisease3() {
		return disease3;
	}

	public void setDisease3(String disease3) {
		this.disease3 = disease3;
	}

	
	//toString method
	@Override
	public String toString() {
		return "Patient [username=" + username + ", password=" + password + ", name=" + name + ", adressLine="
				+ adressLine + ", city=" + city + ", province=" + province + ", postalCode=" + postalCode + ", age="
				+ age + ", gender=" + gender + ", weight=" + weight + ", height=" + height + ", bmi=" + bmi
				+ ", pregnant=" + pregnant + ", doesSmoking=" + doesSmoking + ", consumesAlcohol=" + consumesAlcohol
				+ ", disease1=" + disease1 + ", disease2=" + disease2 + ", disease3=" + disease3 + "]";
	}


}	// end of Patient class
