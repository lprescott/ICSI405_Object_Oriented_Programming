package edu.albany.budgettracker.person;

import java.text.NumberFormat;
import java.util.ArrayList;
import edu.albany.budgettracker.budget.Budget;
import edu.albany.budgettracker.budget.Budgetable;
import edu.albany.budgettracker.budget.expenditure.ExpenditureEnum;
import edu.albany.budgettracker.person.member.Member;
import edu.albany.budgettracker.person.user.User;

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


	public Budget createBudget() {
		
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
