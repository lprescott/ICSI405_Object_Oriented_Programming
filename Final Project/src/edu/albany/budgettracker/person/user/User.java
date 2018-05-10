package edu.albany.budgettracker.person.user;

import edu.albany.budgettracker.budget.Budget;
import edu.albany.budgettracker.budget.Budgetable;
import edu.albany.budgettracker.driver.Driver;
import edu.albany.budgettracker.person.Person;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
*
* Project Name: Final Project - Budget Tracker
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* @file User.java extends a Person object and holds the necessary details to create a budget. It also implements 
* 	budgetable which calls the main methods getBudget (inputting data from the command line)
* 
*~~~~~~~~~~~~~~INFO~~~~~~~~~~~~~~~
*
*	Budget Tracker, aims to create a solid foundation of custom data-structures that can be implemented to accept 
* expenditures or yearly figures from one person, or yearly figures from multiple people. It does so, by using the 
* object-oriented principles of inheritance, composition, polymorphism, generics, and enumerations. It also uses two 
* design patterns including multiple singleton objects and multiple facades.
* 
*	To accurately understand the inheritance and composition principles that were put into practice, please reference 
* the attached U.M.L. diagram. However, in words, there are four compositions: Family has an ArrayList of Persons; 
* Budget has an array of Expenditures; Expenditures have two enumerations, one fore regularity and one for types. 
* There are two instances of inheritance: A user is a person, and a member is also a person.
* 	
* 	Polymorphism was implemented effectively in the family object because the single user and multitude of members 
* that exist in the references of the parent person object can exist in the family object’s ArrayList. Also, 
* polymorphism is apparent in the driver class when instantiating person objects before determining their exact 
* instance using the ‘instanceof’ keyword.
* 
* 	Generics were only implemented in the interface budgetable; that is, the interface budgetable has a method 
* createBudget that accepts any implementation of the budgetable interface, including the related objects user 
* and member, and the unrelated object that is a family. All are budgetable.  
* 
* 	Enumerations were definitively implemented as to represent the regularity and type of expenditures, an important
* aspect of interpreting and suggesting budget changes to the user. The type of expenditures contains the type name, 
* and percentage of yearly spending  suggested for that type. The regularity of expenditures contains the regularity 
* name, and the number of occurrences of that time in one year. 
* 
* 	Two design patterns were used in this project, the first being singletons. The solid foundation that this project 
* aims to create allows only one user to be created (the user of the program) versus the unlimited amount of member 
* that are allowed. Also, this project only allows for the creation of one family object; that is, only one family 
* object is necessary at a given time, so to create more would be undermining the purpose of this program. 

* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*
*/
public class User extends Person implements Budgetable<User>{

	private static User instance;
	private int userID;
	private Budget personalBudget;
	private boolean hasGroupBudget;
	private double income;
	

	/**
	 * toString method, automatically gernerated
	 */
	@Override
	public String toString() {
		return "User [userID=" + userID + ", personalBudget=" + personalBudget
				+ ", hasGroupBudget=" + hasGroupBudget + "]";
	}

	//Constructors accepting a different amount of parameters depending on the use case
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

	/**
	 * create budget method required by interface
	 */
	@Override
	public Budget createBudget(Budgetable<User> input) {
		return Driver.getBudget(1, null, false, (Person) input, false);

	}

}
