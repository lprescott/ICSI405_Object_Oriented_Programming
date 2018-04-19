package edu.albany.person.employee;

import edu.albany.person.Person;

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
* Employee.java defines a abstract Employee object that extends Person with employee id.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public abstract class Employee extends Person{
	
	//Static instance variable
	protected static int count;
	private int employee_id;

	/**
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public static void setCount(int count) {
		Employee.count = count;
	}
	/**
	 * @return the employee_id
	 */
	public int getEmployee_id() {
		return employee_id;
	}
	/**
	 * @param employee_id the employee_id to set
	 */
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.albany.person.Person#toString()
	 */
	public abstract String toString();

}
