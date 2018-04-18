package edu.albany.person.customer;

import java.text.NumberFormat;

import edu.albany.person.Person;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: April 17th, 2018
*
* Project Name: HW2
* Package Name: edu.albany.person.customer
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* Customer.java defines a Customer object that extends Person with a disposable income attribute.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class Customer extends Person {
	
	private double disposable_income;

	/*
	* Constructor accepting first name, last name and disposable income.
    */
	public Customer(String new_first_name, String new_last_name, double new_disposable_income) {
		this.setDisposable_income(new_disposable_income);
		this.setFirst_name(new_first_name);
		this.setLast_name(new_last_name);
	}
	
	/**
	 * @return the disposable_income
	 */
	public double getDisposable_income() {
		return disposable_income;
	}
	/**
	 * @param disposable_income the disposable_income to set
	 */
	public void setDisposable_income(double disposable_income) {
		this.disposable_income = disposable_income;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return this.getFirst_name() + " " + this.getLast_name() + " has " + formatter.format(this.getDisposable_income()) + " in their pocket";
	}
}
