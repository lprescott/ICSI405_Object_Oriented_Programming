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
public class Person {
	
	//Instance variables:
	private String firstName;
	private String lastName;
	private Address homeAddress;
	private CheckingBankAccount bankAccount;
	
	//Constructor(s):
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param homeAddress
	 * @param bankAccount
	 */
	public Person(String firstName, String lastName, Address homeAddress, CheckingBankAccount bankAccount) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeAddress = homeAddress;
		this.bankAccount = bankAccount;
	}
	
	//Getters and Setters:

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the homeAddress
	 */
	public Address getHomeAddress() {
		return homeAddress;
	}
	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	/**
	 * @return the bankAccount
	 */
	public CheckingBankAccount getBankAccount() {
		return bankAccount;
	}
	/**
	 * @param bankAccount the bankAccount to set
	 */
	public void setBankAccount(CheckingBankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
}
