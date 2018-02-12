package com.ualbany.hw1.problem1;

//Imported libraries:
import java.text.DecimalFormat;

/**
 * @author Luke R. Prescott 
 * Student ID: 001252879
 * 
 * Start Date: Feb 11, 2018
 *
 * Project Name: HW1
 * Package Name: com.ualbany.hw1.problem1
 * 
 * This class creates an Employee object with three instance variables:
 * 	1. firstName
 * 	2. lastName
 *  3. montlySalary
 *  
 * 	There is one constructor that accepts all three variables to instantiate. 
 * 		It also checks that monthlySalary is greater than zero, and assigns it to zero if not.
 * 
 * 	getYearlySalary - returns a double (12.0 * an employee's monthly salary).
 * 	giveRaise - accepts a decimal representing a percent to raise an employees monthly salary
 * 	toString - returns an Employee instance represented in a String format.
 *
 * 	Finally, there are getters and setters for all instance variables.
 */
public class Employee {
	
	//Instance variables:
	private String firstName;
	private String lastName;
	private double monthlySalary;
	
	//Constructor(s):
	public Employee(String firstName, String lastName, double monthlySalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//Check if salary is negative:
		if(monthlySalary < 0) {
			this.monthlySalary = 0.0;
		} else {
			this.monthlySalary = monthlySalary;
		}
	}
	
	/** 
	 * getYearlySalary returns the instance's monthlySalary * 12
	 * 
	 * @return the yearlySalary of an Employee instance
	 */
	public double getYearlySalary() {
		return this.getMonthlySalary() * 12.0;
	}
	
	/**
	 * giveRaise increases the instance's monthlySalary by the supplied percent
	 * 
	 * @param decimalToRaise the percent to raise in decimal format
	 */
	public void giveRaise(double decimalToRaise) {
		
		//Assign monthly salary to itself + .10(itself)
		double currentMonthlySalary = this.getMonthlySalary();
		this.setMonthlySalary(currentMonthlySalary + (decimalToRaise * currentMonthlySalary));
	}
	
	/**
	 * @return an Employee instance represented in String format
	 */
	@Override
    public String toString() {
   
    	//Creates a new decimal format that rounds to two decimal points, i.e. money
    	DecimalFormat money = new DecimalFormat("#.00"); 
    			
        return "The yearly salary for " + this.getFirstName() + " " + this.getLastName()
			 + " is: $" + money.format(this.getYearlySalary()) + ".";
    }
    
    //Start Getters and Setters --------------------------
	
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
	 * @return the monthlySalary
	 */
	public double getMonthlySalary() {
		return monthlySalary;
	}
	/**
	 * @param monthlySalary the monthlySalary to set
	 */
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	//End Getters and Setters --------------------------
	
}
