package edu.albany.hw4;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: April 25th, 2018
*
* Project Name: HW4
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* PositiveInteger.java is a (concrete) subclass of Semigroup.
* 
* 	The required operate method adds two integers together.
* 
* 	The equals and toString methods have been implemented for later testing.
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class PositiveInteger extends SemiGroup<Integer> {

	//Instance variables
	private int value;
	
	//Constructor accepting positive integer
	public PositiveInteger(int value) {
		this.setValue(value);
	}

	//Overriden operate method that adds the passed integer to 
	//	Positive Integers current val
	@Override
	public Integer operate(Integer b) {
		return this.getValue() + b;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * This toString method returns the PositiveIntegers String representation of value.
	 */
	@Override
	public String toString() {
		return String.valueOf(this.getValue());
	}

	/*
	 * This equals method attempts to compare the passed numect with the current value by comparing references,
	 * 	then classes, then casting and comparing using values equals method.
	 */
	public boolean equals(PositiveInteger num) {
		//References
		if (this == num)
			return true;
		if (num == null)
			return false;
		//Classes
		if (getClass() != num.getClass())
			return false;
		//Actual values
		PositiveInteger other = (PositiveInteger) num;
		if (this.getValue() != other.getValue()) {
			return false;
		}
		return true;
	}

	
}
