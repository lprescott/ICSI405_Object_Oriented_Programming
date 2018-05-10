package edu.albany.budgettracker.person;

import java.text.NumberFormat;
import java.util.ArrayList;
import edu.albany.budgettracker.budget.Budget;
import edu.albany.budgettracker.budget.Budgetable;
import edu.albany.budgettracker.budget.expenditure.ExpenditureEnum;
import edu.albany.budgettracker.person.member.Member;
import edu.albany.budgettracker.person.user.User;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
*
* Project Name: Final Project - Budget Tracker
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* @file Family.java has a list of persons, either users or members that implements budgetable, therefore having 
* 	a createbudget method.
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


	/**
	 * this method is required by the interface bugetable
	 * 
	 * it prints the budget created by a family object by referencing this projects enumerations
	 */
	@Override
	public void printBudget(Budget input) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~BUDGET~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println("Family: " + this.getMembers().get(0).getLastName());
		System.out.println("Total income: " + input.getNetIncome() + "\n");

		System.out.println("The " + this.getMembers().get(0).getLastName() + " family should spend these amounts per year."
				+ "\n " + formatter.format(ExpenditureEnum.HOUSING.getPercentage()*input.getNetIncome()) + " on housing "
				+ "\n " + formatter.format(ExpenditureEnum.TRANSPORTATION.getPercentage()*input.getNetIncome()) + " on transportation "
				+ "\n " + formatter.format(ExpenditureEnum.FOOD.getPercentage()*input.getNetIncome()) + " on food "
				+ "\n " + formatter.format(ExpenditureEnum.DEBT_PAYMENTS.getPercentage()*input.getNetIncome()) + " on debt payments "
				+ "\n " + formatter.format(ExpenditureEnum.PERSONAL.getPercentage()*input.getNetIncome()) + " on personal "
				+ "\n " + formatter.format(ExpenditureEnum.SAVINGS.getPercentage()*input.getNetIncome()) + " on savings "
				+ "\n " + formatter.format(ExpenditureEnum.UTILITIES.getPercentage()*input.getNetIncome()) + " on utilities "
				+ "\n " + formatter.format(ExpenditureEnum.CLOTHING.getPercentage()*input.getNetIncome()) + " on clothing "
				+ "\n " + formatter.format(ExpenditureEnum.MEDICAL.getPercentage()*input.getNetIncome()) + " on medical ");
		
	}
	
	/**
	 * this method is required by the interface bugetable
	 * 
	 * it creates and returns a budget object after looping through all persons in the families list
	 * 	and accumulation all necessary details
	 */
	@Override
	public Budget createBudget(Budgetable<Family> input) {
		
		double totalIncome = 0;
		
		for(Person p : members) {
			Budget temp = null;
			if(p instanceof User) {
				temp = ((User) p).getPersonalBudget();
			} else if(p instanceof Member) {
				temp = ((Member) p).getPersonalBudget();
			}
			
			if(temp == null) {
				System.out.println("There was an error casting Budgets when creating a Family object.");
			} else if(temp.getExpenditures() == null) {
				totalIncome += p.getIncome();
			} else if(temp.getExpenditures() != null) {
				System.out.println("Families do not support expenditures yet.");
			}
			
		}
		
		Budget returnable = new Budget();
		returnable.setNetIncome(totalIncome);
		return returnable;
	}
}
