package edu.albany.budgettracker.budget.expenditure;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
*
* Project Name: Final Project - Budget Tracker
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* @file Regularity.java is an enumeration that represents the possible intervals in which an expenditure may repeat.

* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*
*/
public enum Regularity {
	DAILY("daily", 365),
	WEEKLY("weekly", 52.17857),
	MONTHLY("monthly", 12),
	SEMI_ANNUALLY("semi-annually", 2),
	ANNUALLY("annually", 1);

	private double partsInYear;
	private String name;
	
	Regularity(String name, double partsInYear){
		this.name = name;
		this.partsInYear = partsInYear; 
	}

	/**
	 * @return the partsInYear
	 */
	public double getPartsInYear() {
		return partsInYear;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
