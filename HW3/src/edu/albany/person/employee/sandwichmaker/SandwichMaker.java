package edu.albany.person.employee.sandwichmaker;

import edu.albany.person.employee.Employee;
import edu.albany.problem2.Menu.Sandwich;
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
* SandwichMaker.java defines a Sandwichmaker object that extends Employee and has a current sandwich
* attribute.
* 
* This class also defines an enum that specifies the name and the prices of possibly made sandwiches.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class SandwichMaker extends Employee{
	
	private static Transaction current_transaction;
	
	/*
	* Constructor accepting first name, last name, employee id, and cash register amount.
    */
	public SandwichMaker(String new_first_name, String new_last_name, Transaction current_order) {
		employee_id++;
		this.setFirst_name(new_first_name);
		this.setLast_name(new_last_name);
		SandwichMaker.setCurrent_transaction(current_order);
	}


	/**
	 * @return the current_transaction
	 */
	public static Transaction getCurrent_transaction() {
		return current_transaction;
	}


	/**
	 * @param current_transaction the current_transaction to set
	 */
	public static void setCurrent_transaction(Transaction current_transaction) {
		SandwichMaker.current_transaction = current_transaction;
	}
	
	/**
	 * This function completes the current order, if any, that has been assigned to a SandwichMaker object.
	 *
	 */
	public static void completeOrder() {
		if(SandwichMaker.getCurrent_transaction().getOrder() != null) {
			System.out.println("\n\t\"Starting order number " + Transaction.getOrder_number() + "!\"\n");
			for(Sandwich s : SandwichMaker.getCurrent_transaction().getOrder()) {
				System.out.println("\t" + s.getName() + " ...done.");
			}			
		
			System.out.println("\n\t\"Order up!\"");
		} else {
			System.out.println("\n\t\"No current orders!\"");
		}

	}


	/*
	 * (non-Javadoc)
	 * @see edu.albany.person.employee.Employee#toString()
	 */
	@Override
	public String toString() {
		return this.getName();
	}
	
}
