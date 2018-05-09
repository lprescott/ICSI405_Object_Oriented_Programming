package edu.albany.budgettracker.person.user;

import java.util.ArrayList;

import edu.albany.budgettracker.budget.Budget;
import edu.albany.budgettracker.budget.Budgetable;
import edu.albany.budgettracker.person.Person;

public class User extends Person implements Budgetable<User>{

	private static User instance;
	private int userID;
	private Budget personalBudget;
	private boolean hasGroupBudget;
	private double income;
	

	@Override
	public String toString() {
		return "User [userID=" + userID + ", personalBudget=" + personalBudget
				+ ", hasGroupBudget=" + hasGroupBudget + "]";
	}

	public User( int userID, Budget personalBudget, boolean hasGroupBudget) {
		this.userID = userID;
		this.personalBudget = personalBudget;
		this.hasGroupBudget = hasGroupBudget;
	}
	
	public User( int userID, Budget personalBudget, boolean hasGroupBudget, String firstName, String lastName, int age) {
		this.userID = userID;
		this.personalBudget = personalBudget;
		this.hasGroupBudget = hasGroupBudget;

		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAge(age);
	}
	
	public User() {
		super();
	}

	/**
	 * @return the instance
	 */
	public static User getInstance() {
		if(instance == null) {
			instance = new User();
		}
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(User instance) {
		User.instance = instance;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the personalBudget
	 */
	public Budget getPersonalBudget() {
		return personalBudget;
	}

	/**
	 * @param personalBudget the personalBudget to set
	 */
	public void setPersonalBudget(Budget personalBudget) {
		this.personalBudget = personalBudget;
	}

	/**
	 * @return the hasGroupBudget
	 */
	public boolean isHasGroupBudget() {
		return hasGroupBudget;
	}

	/**
	 * @param hasGroupBudget the hasGroupBudget to set
	 */
	public void setHasGroupBudget(boolean hasGroupBudget) {
		this.hasGroupBudget = hasGroupBudget;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (hasGroupBudget ? 1231 : 1237);
		result = prime * result + ((personalBudget == null) ? 0 : personalBudget.hashCode());
		result = prime * result + userID;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (hasGroupBudget != other.hasGroupBudget)
			return false;
		if (personalBudget == null) {
			if (other.personalBudget != null)
				return false;
		} else if (!personalBudget.equals(other.personalBudget))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

	/**
	 * @return the income
	 */
	public double getIncome() {
		return income;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(double income) {
		this.income = income;
	}

	@Override
	public void printBudget(Budget input) {
		if(input.getDeductions() == 0 && input.getNetIncome() == 0) {
			System.out.println("Expenditures given.");
		} else {
			System.out.println("Yearly figures given.");
		}
	}
}
