package edu.albany.person.employee.cashier;

import java.text.NumberFormat;
import edu.albany.person.customer.Customer;
import edu.albany.person.employee.Employee;
import edu.albany.transaction.Transaction;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: April 17th, 2018
*
* Project Name: HW3
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* Cashier.java defines a Cashier object that extends Employee with a cash register amount attribute.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class Cashier extends Employee{
	
	//Instance variable(s)
	private double cash_register_amount;
	
	/*
	* Constructor accepting first name, last name, employee id, and cash register amount.
    */
	public Cashier(String new_first_name, String new_last_name, double new_cash_register_amount) {
		employee_id++;
		this.setFirst_name(new_first_name);
		this.setLast_name(new_last_name);
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

	/*
	 * (non-Javadoc)
	 * @see edu.albany.person.employee.Employee#toString()
	 */
	@Override
	public String toString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return this.getFirst_name() + " " + this.getLast_name() + " with employee id " + this.getEmployee_id() + " has " + formatter.format(this.getCash_register_amount()) + " in their cash register.";
	}

	/*
	 * This method adds money to the cash register if it is not above the limit of 300 dollars.
	 */
	public void receive(double transaction_total) {
		if((this.cash_register_amount += transaction_total)<300) {
			this.cash_register_amount += transaction_total;
		} else {
			throw new IllegalArgumentException("\"Sorry, one moment, there is too much money in the register.\"");
		}
	}

	/*
	 * This method attempts to call pay and receive (completing the transaction) and throws an exception if a problem is
	 * found.
	 */
	public static void authenticate(Customer customer, Cashier cashier, Transaction test_transaction) {
		double transaction_total = test_transaction.getPrice();
		customer.pay(transaction_total);
		cashier.receive(transaction_total);
	}
}
