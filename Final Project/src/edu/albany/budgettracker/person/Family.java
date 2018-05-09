package edu.albany.budgettracker.person;

import java.util.ArrayList;
import edu.albany.budgettracker.budget.Budget;
import edu.albany.budgettracker.budget.Budgetable;

public class Family implements Budgetable<Family> {
	
	private static Family instance;
	private ArrayList<Person> members;
	private Budget familyBudget;
	


	/**
	 * @return the instance
	 */
	public static Family getInstance() {
		if (instance == null) {
			instance = new Family();
		}
		return instance;
	}


	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(Family instance) {
		Family.instance = instance;
	}



	/**
	 * @return the familyBudget
	 */
	public Budget getFamilyBudget() {
		return familyBudget;
	}

	/**
	 * @param familyBudget the familyBudget to set
	 */
	public void setFamilyBudget(Budget familyBudget) {
		this.familyBudget = familyBudget;
	}

	/**
	 * @return the members
	 */
	public ArrayList<Person> getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(ArrayList<Person> members) {
		this.members = members;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Family [members=" + members + ", familyBudget=" + familyBudget + "]";
	}


	@Override
	public void printBudget(Budget input) {
		// TODO Auto-generated method stub
		
	}
}
