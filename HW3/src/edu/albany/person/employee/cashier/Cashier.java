package edu.albany.person.employee.cashier;

import java.text.NumberFormat;

import edu.albany.person.customer.Customer;
import edu.albany.person.employee.Employee;
import edu.albany.person.employee.sandwichmaker.SandwichMaker.Sandwich;
import edu.albany.transaction.Transaction;

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
* Cashier.java defines a Cashier object that extends Employee with a cash register amount attribute.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class Cashier extends Employee{
	
	private double cash_register_amount;
	
	/*
	* Constructor accepting first name, last name, employee id, and cash register amount.
    */
	public Cashier(String new_first_name, String new_last_name, double new_cash_register_amount) {
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return this.getFirst_name() + " " + this.getLast_name() + " with employee id " + this.getEmployee_id() + " has " + formatter.format(this.getCash_register_amount()) + " in their cash register.";
	}
	
	public void printReceipt() {
		
	}

	public void credit(double transaction_total) {
		this.cash_register_amount += transaction_total;
	}

	public static void authenticate(Customer customer, Cashier cashier, Transaction test_transaction) {
		double transaction_total = test_transaction.getPrice();
		customer.debit(transaction_total);
		cashier.credit(transaction_total);
	}
	
}
