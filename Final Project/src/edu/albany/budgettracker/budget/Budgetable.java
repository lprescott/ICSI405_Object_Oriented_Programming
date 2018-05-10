package edu.albany.budgettracker.budget;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
*
* Project Name: Final Project - Budget Tracker
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* @file Budgetable.java is an interface that makes all implementations have a createBudget and a print Budget method.

* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*
*/
public interface Budgetable<T> {
	public void printBudget(Budget input);
	
	public Budget createBudget(Budgetable<T> input);
}
