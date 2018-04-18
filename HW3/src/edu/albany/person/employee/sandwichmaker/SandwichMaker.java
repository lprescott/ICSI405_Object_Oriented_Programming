package edu.albany.person.employee.sandwichmaker;

import java.util.LinkedList;
import java.util.Queue;

import edu.albany.person.employee.Employee;
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
* SandwichMaker.java defines a Sandwichmaker object that extends Employee and has a current sandwich
* attribute.
* 
* This class also defines an enum that specifies the name and the prices of possibly made sandwiches.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class SandwichMaker extends Employee{
	
	Queue <Transaction> orders = new LinkedList<Transaction>();
	
	/*
	* Constructor accepting first name, last name, employee id, and cash register amount.
    */
	public SandwichMaker(String new_first_name, String new_last_name, Queue <Transaction> current_orders) {
		this.setFirst_name(new_first_name);
		this.setLast_name(new_last_name);
		this.setCurrent_Orders(current_orders);
	}


	private void setCurrent_Orders(Queue<Transaction> current_orders) {
		// TODO Auto-generated method stub
		this.orders = current_orders;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @param the sandwich to be made
	 *
	 */
	public static void completeOrder(Transaction transaction_to_cater) {
		System.out.println("\n\t\"Starting order number " + Transaction.getCount() + "!\"\n");
		for(Sandwich s : transaction_to_cater.getOrder()) {
			System.out.println("\t" + s.getName() + " ...done.");
		}			
	
		System.out.println("\n\t\"Order up!\"");
	}
	public enum Sandwich {
		
	    TURKEY("Turkey Sandwich", 5.89), 
	    BBQ("BBQ Sandwich", 4.25),
	    BLT("BLT Sandwich", 4.51),
	    MEATBALL("Meatball Sandwich", 5.55),
	    GRILLEDCHEESE("Grilled-Cheese Sandwich", 3.25);
		
		private String name;
		private double price;
		
		private static int count = 5;
		
		Sandwich(String new_name, double new_price) {
			this.name = new_name;
			this.price = new_price;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the price
		 */
		public double getPrice() {
			return price;
		}

		/**
		 * @return the count
		 */
		public static int getCount() {
			return count;
		}
		
		public String toString() {
			return String.format("%-25s$%s" , this.getName(), this.getPrice());
		}
	}
}
