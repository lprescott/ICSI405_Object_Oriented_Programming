package com.ualbany.hw1.problem3;

/**
 * @author Luke R. Prescott
 * Student ID: 001252879
 * 
 * Start Date: Feb 11, 2018
 *
 * Project Name: HW1
 * Package Name: com.ualbany.hw1.problem3
 */
public class Address {
	
	//Instance variables:
	private String addressLine1; 
	private String addressLine2;
	private String City;
	private String State;
	private String Zip;
	
	//Constructor(s)
	/**
	 * @param addressLine1
	 * @param addressLine2
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Address(String addressLine1, String addressLine2, String city, String state, String zip) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		City = city;
		State = state;
		Zip = zip;
	}
	
	//Getters and Setters:
	
	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return City;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		City = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return State;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		State = state;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return Zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		Zip = zip;
	}

	/*
	 * 
	 */
	@Override
	public String toString() {
		return "\tAddress Line 1: " + addressLine1 + "\n\tAddress Line 2: " + addressLine2 + "\n\tCity: " + City
				+ "\n\tState: " + State + "\n\tZip: " + Zip + "\n";
	}

}
