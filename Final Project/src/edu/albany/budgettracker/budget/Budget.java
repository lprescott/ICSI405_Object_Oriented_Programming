package edu.albany.budgettracker.budget;

import java.util.Arrays;

import edu.albany.budgettracker.budget.expenditure.Expenditure;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
*
* Project Name: Final Project - Budget Tracker
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* @file Budget.java attempts to represent a budget as a data structure with either a list of deductions and a net income,
* 	or a estimation of deductions and a net income.
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
public class Budget {
	
	private double netIncome;
	private double deductions;
	private Expenditure[] expenditures;
	
	//Constructor
	public Budget(double netIncome, double deductions, Expenditure[] expenditures) {
		this.setNetIncome(netIncome);
		this.setDeductions(deductions);
		this.setExpenditures(expenditures);
	}

	public Budget() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the netIncome
	 */
	public double getNetIncome() {
		return netIncome;
	}

	/**
	 * @param netIncome the netIncome to set
	 */
	public void setNetIncome(double netIncome) {
		this.netIncome = netIncome;
	}

	/**
	 * @return the deductions
	 */
	public double getDeductions() {
		return deductions;
	}

	/**
	 * @param deductions the deductions to set
	 */
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	/**
	 * @return the expenditures
	 */
	public Expenditure[] getExpenditures() {
		return expenditures;
	}

	/**
	 * @param expenditures the expenditures to set
	 */
	public void setExpenditures(Expenditure[] expenditures) {
		this.expenditures = expenditures;
	}

	@Override
	public String toString() {
		return "Budget [netIncome=" + netIncome + ", deductions=" + deductions + ", expenditures="
				+ Arrays.toString(expenditures) + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(deductions);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Arrays.hashCode(expenditures);
		temp = Double.doubleToLongBits(netIncome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Budget other = (Budget) obj;
		if (Double.doubleToLongBits(deductions) != Double.doubleToLongBits(other.deductions))
			return false;
		if (!Arrays.equals(expenditures, other.expenditures))
			return false;
		if (Double.doubleToLongBits(netIncome) != Double.doubleToLongBits(other.netIncome))
			return false;
		return true;
	}


}
