package edu.albany.transaction;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import edu.albany.person.customer.Customer;
import edu.albany.person.employee.cashier.Cashier;
import edu.albany.person.employee.sandwichmaker.SandwichMaker;
import edu.albany.problem2.Menu.Sandwich;

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
* Transaction.java contains a order_number and a list of Sandwiches that a customer has placed.
* 
* This object is passed to the cook, and the cashier as needed to complete an order.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class Transaction {
	
	//Instance variables
	private static int order_number = 0;
	private Sandwich[] order;

	/**
	 * @return the order
	 */
	public Sandwich[] getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Sandwich[] order) {
		this.order = order;
	}
	/**
	 * @return the order_number
	 */
	public static int getOrder_number() {
		return order_number;
	}
	/**
	 * @param order_number the order_number to set
	 */
	public static void setOrder_number(int order_number) {
		Transaction.order_number = order_number;
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		
		final DecimalFormat df = new DecimalFormat("#.##");

		//Loop through order
		double count = 0;
		for(Sandwich s : this.getOrder()) {
			count += s.getPrice();
		}

		return Double.parseDouble(df.format(count));
	}
	
	/**
	 * @return the price
	 */
	public double getTax() {
		
		final DecimalFormat df = new DecimalFormat("#.##");
		
		
		//Loop through order
		double count = 0;
		for(Sandwich s : this.getOrder()) {
			count += s.getPrice();
		}
		
		//Add tax
		count = (count * 0.08);
		
		return Double.parseDouble(df.format(count));
	}


	/*
	 * This is a constructor that takes a list of sandwiches as a parameter and increments a static variable 
	 * order_number when neccessary. 
	 */
	public Transaction(Sandwich[] new_order){
		this.order = new_order;
		order_number++;
	}
	
	/*
	 * This function prints a receipt after an order has been authenticated.
	 */
	public void printReceipt(Customer customer, Cashier cashier, SandwichMaker cook) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
	
		System.out.println("\nReceipt (Order # " + Transaction.getOrder_number() + "): ");
		System.out.println("-------------------------------");
		System.out.println(String.format("%-25s%s" , "Type", "Price"));
		System.out.println("-------------------------------");
		for(Sandwich s : this.getOrder()) {
			System.out.println(s.toString());
		}
		System.out.println("-------------------------------");
		System.out.println(String.format("%-25s%s" , "Tax", formatter.format(this.getTax())));
		System.out.println(String.format("%-25s%s" , "Total", formatter.format(this.getPrice()+this.getTax())));
		System.out.println("-------------------------------");
		System.out.println("You are being served today by, ");
		System.out.println(String.format("%15s, cashier, id " + cashier.getEmployee_id(), cashier.getName()));
		System.out.println(String.format("%15s, cook, id " + cook.getEmployee_id(), cook.getName()));	
	}
}
