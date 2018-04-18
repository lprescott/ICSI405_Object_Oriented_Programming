package edu.albany.person.employee.cashier;

import java.text.NumberFormat;

import edu.albany.person.employee.Employee;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: April 17th, 2018
*
* Project Name: HW2
* Package Name: edu.albany.person.employee.cashier
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* Cashier.java defines a Cashier object that extends Employee with a cash register amount attribute.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class Cashier extends Employee{
	
	private double cash_register_amount;
	
	/*
	* Constructor accepting first name, last name, employee id, and cash register amount.
    */
	public Cashier(String new_first_name, String new_last_name, int new_employee_id, double new_cash_register_amount) {
		this.setFirst_name(new_first_name);
		this.setLast_name(new_last_name);
		this.setEmployee_id(new_employee_id);
		this.setCash_register_amount(new_cash_register_amount);
	}

	/**
	 * @return the cash_register_amount
	 */
	public double getCash_register_amount() {
		return cash_register_amount;
	}

	/**
	 * @param cash_register_amount the cash_register_amount to set
	 */
	public void setCash_register_amount(double cash_register_amount) {
		this.cash_register_amount = cash_register_amount;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return this.getFirst_name() + " " + this.getLast_name() + " with employee id " + this.getEmployee_id() + " has " + formatter.format(this.getCash_register_amount()) + " in their cash register.";
	}
	
}
