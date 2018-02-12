package com.ualbany.hw1.problem3;

/**
 * @author Luke R. Prescott
 * Student ID: 001252879
 * 
 * Start Date: Feb 11, 2018
 *
 * Project Name: HW1
 * Package Name: com.ualbany.hw1.problem3
 * 
 * A checking bank account has value, a person can withdraw, deposit
 * money to the account
 * 
 */
public class CheckingBankAccount {
	
	//Instance variables
	private double value;
	
	/**
	 * Withdraws money from a instance of CheckingBankAccount
	 * @param withdrawAmt
	 */
	public void withdraw(double withdrawAmt) {
		this.value -= withdrawAmt;
	}
	
	/**
	 * Deposits money from a instance of CheckingBankAccount
	 * @param depositAmt
	 */
	public void deposit(double depositAmt) {
		this.value += depositAmt;
	}
	
	//Getters and Setters:

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	//Constructor(s)

	/**
	 * @param value
	 */
	public CheckingBankAccount(double value) {
		this.value = value;
	}
	
}
