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
	protected static int employee_id = 1;

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
		Employee.employee_id = employee_id;
	}
	
	/*
	 * (non-Javadoc)
	 * @see edu.albany.person.Person#toString()
	 */
	public abstract String toString();
	
	/*
	 * This creates a default constructor for the Employee object that sets their employee id.
	 */
	public Employee() {
		employee_id++;
	}
}
