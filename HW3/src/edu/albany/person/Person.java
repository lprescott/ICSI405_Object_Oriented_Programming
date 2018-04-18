package edu.albany.person;

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
* Person.java defines a abstract Person object with a first and last name.
* 
* This class also defines an abstract method toString()
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public abstract class Person {
	
	//Instance variable(s)
	private String first_name;
	private String last_name;
	
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	/*
	 * The function getName return the first initial of a the person's first name, and their
	 * last name seperated by a space.
	 */
	public String getName() {
		return first_name.toCharArray()[0] + ". " + last_name;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public abstract String toString();
}
