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
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* Customer.java defines a Customer object that extends Person with a disposable income attribute.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class Customer extends Person {
	
	private double cash;

	/*
	* Constructor accepting first name, last name and disposable income.
    */
	public Customer(String new_first_name, String new_last_name, double new_cash) {
		this.setCash(new_cash);
		this.setFirst_name(new_first_name);
		this.setLast_name(new_last_name);
	}
	
	/**
	 * @return the cash
	 */
	public double getCash() {
		return cash;
	}
	/**
	 * @param cash the cash to set
	 */
	public void setCash(double cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return this.getFirst_name() + " " + this.getLast_name() + " has " + formatter.format(this.getCash()) + " in their pocket";
	}

	public void debit(double transaction_total) {
		if((this.cash -= transaction_total) > 0) this.cash -= transaction_total;
		else throw new IllegalArgumentException("Not enough money.");
	}
}
