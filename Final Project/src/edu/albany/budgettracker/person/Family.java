package edu.albany.budgettracker.person;

import java.util.Arrays;

import edu.albany.budgettracker.budget.Budget;
import edu.albany.budgettracker.budget.Budgetable;

public class Family implements Budgetable<Family> {
	
	private static Family instance;
	private Person[] members;
	private Budget familyBudget;
	
	@Override
	public Budget createBudget(Budgetable<Family> input) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the instance
	 */
	public static Family getInstance() {
		if (instance == null) {
			instance = new Family();
		}
		return instance;
	}

	@Override
	public String toString() {
		return "Family [members=" + Arrays.toString(members) + ", familyBudget=" + familyBudget + "]";
	}

	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(Family instance) {
		Family.instance = instance;
	}

	/**
	 * @return the members
	 */
	public Person[] getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(Person[] members) {
		this.members = members;
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
}
