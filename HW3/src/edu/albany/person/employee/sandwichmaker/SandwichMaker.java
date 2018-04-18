package edu.albany.person.employee.sandwichmaker;

import edu.albany.person.employee.Employee;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: April 17th, 2018
*
* Project Name: HW2
* Package Name: edu.albany.person.employee.sandwichmaker
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
	
	private Sandwich current_sandwich;
	private int num_current_sandwiches;
	
	/*
	* Constructor accepting first name, last name, employee id, and cash register amount.
    */
	public SandwichMaker(String new_first_name, String new_last_name, int new_employee_id, Sandwich new_current_sandwich, int new_num_current_sandwiches) {
		this.setFirst_name(new_first_name);
		this.setLast_name(new_last_name);
		this.setEmployee_id(new_employee_id);
		this.setCurrent_sandwich(new_current_sandwich);
		this.setNum_current_sandwiches(new_num_current_sandwiches);
	}
	
	/**
	 * @return the current_sandwich
	 */
	public Sandwich getCurrent_sandwich() {
		return current_sandwich;
	}

	/**
	 * @param current_sandwich the current_sandwich to set
	 */
	public void setCurrent_sandwich(Sandwich current_sandwich) {
		this.current_sandwich = current_sandwich;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getFirst_name() + " " + this.getLast_name() + " (id: " + this.getEmployee_id() + ") is cooking " + this.getNum_current_sandwiches() + " " + this.getCurrent_sandwich().getName() + "(s).";
	}
	
	/**
	 * @return the num_current_sandwiches
	 */
	public int getNum_current_sandwiches() {
		return num_current_sandwiches;
	}

	/**
	 * @param num_current_sandwiches the num_current_sandwiches to set
	 */
	public void setNum_current_sandwiches(int num_current_sandwiches) {
		this.num_current_sandwiches = num_current_sandwiches;
	}

	public enum Sandwich {
	    TURKEY("Turkey Sandwich", 5.89), 
	    BBQ("BBQ Sandwich", 4.25),
	    BLT("BLT Sandwich", 4.51),
	    MEATBALL("Meatball Sandwich", 5.55),
	    GRILLEDCHEESE("Grilled-Cheese Sandwich", 3.25);
		
		private String name;
		private double price;
		
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
		
		public String toString() {
			return String.format("%-25s$%s" , this.getName(), this.getPrice());
		}
	}
}
