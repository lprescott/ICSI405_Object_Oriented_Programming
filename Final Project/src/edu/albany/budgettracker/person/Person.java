package edu.albany.budgettracker.person;

import java.text.NumberFormat;

import edu.albany.budgettracker.budget.Budget;
import edu.albany.budgettracker.budget.expenditure.Expenditure;
import edu.albany.budgettracker.budget.expenditure.ExpenditureEnum;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
*
* Project Name: Final Project - Budget Tracker
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* @file Person.java is an abstract object that defines a person in the program. It also has a print Budget method that
* 	all person objects have access to.
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
public abstract class Person {
	
	private String firstName;
	private String lastName;
	private double income;
	private int age;
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
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
	 * This function looks at the budgets expenditures, checking if they are null at-first
	 * 	if they are null, this prints a budget with details determined only from netincome and deductions
	 * 	else if they are not, this prints a budget with details determined from an accumulation on the 
	 * 	expenditures
	 * 
	 * @param input the Budget that is to be printed
	 */
	public void printBudget(Budget input) {
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~BUDGET~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
		System.out.println("Age: " + this.getAge());
		
		if(input.getExpenditures() == null) {
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			
			System.out.println("Yearly income: " + formatter.format(input.getNetIncome()));
			//System.out.println("Yearly deductions: " + formatter.format(input.getDeductions()));
			//System.out.println("Net-Income: " + formatter.format(input.getNetIncome() - input.getDeductions()));
			
			System.out.println("\nSuggested yearly expenditure amounts: ");
			double savings = 0; double personal = 0;
			
			//Loop through expenditure enums
			for(ExpenditureEnum e : ExpenditureEnum.values()) {
				System.out.println(e.getName() + " : " + formatter.format(e.getPercentage()*input.getNetIncome()));
				if(e.getName().equals("savings")) {
					savings = e.getPercentage()*input.getNetIncome();
				}
				if(e.getName().equals("personal")) {
					personal = e.getPercentage()*input.getNetIncome();
				}
			}
			
			//Print details
			System.out.println("\nWith the savings of: " + formatter.format(savings) + " each year."
					+ "\n" + this.getFirstName() + " could retire in " + Math.round(1000000/savings) + " years with " + formatter.format(savings*(1000000/savings)) + " in savings.");
			
			System.out.println("That is the age of: " + (this.age + Math.round(1000000/(savings))));
			
			System.out.println("\nIncluding personal allowances of " + formatter.format(personal) + "\n"+ this.getFirstName() + " could retire in " + Math.round(1000000/(savings+personal)) + " years with " + formatter.format((savings+personal)*(1000000/(savings+personal))) + " in savings.");
			
			System.out.println("That is the age of: " + (this.age + Math.round(1000000/(savings+personal))));
			
		} else {
			
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			System.out.println("Yearly income: " + formatter.format(input.getNetIncome()));

			double total = 0;
			double totalHOUSING = 0;
			double totalTRANSPORTATION = 0;
			double totalFOOD = 0;
			double totalDEBT_PAYMENTS = 0;
			double totalPERSONAL = 0;
			double totalSAVINGS = 0;
			double totalUTILITIES = 0;
			double totalCLOTHING = 0;
			double totalMEDICAL = 0;
			
			
			//Loop through all expenditures of person
			for(Expenditure e : input.getExpenditures()) {
				if(e.getType().equals(ExpenditureEnum.HOUSING)) {
					totalHOUSING += e.getAmount()*e.getRepeat().getPartsInYear();
					total += e.getAmount()*e.getRepeat().getPartsInYear();
					
				} else if(e.getType().equals(ExpenditureEnum.TRANSPORTATION)) {
					totalTRANSPORTATION += e.getAmount()*e.getRepeat().getPartsInYear();
					total += e.getAmount()*e.getRepeat().getPartsInYear();

				} else if(e.getType().equals(ExpenditureEnum.FOOD)) {
					totalFOOD += e.getAmount()*e.getRepeat().getPartsInYear();
					total += e.getAmount()*e.getRepeat().getPartsInYear();

				} else if(e.getType().equals(ExpenditureEnum.DEBT_PAYMENTS)) {
					totalDEBT_PAYMENTS += e.getAmount()*e.getRepeat().getPartsInYear();
					total += e.getAmount()*e.getRepeat().getPartsInYear();

				} else if(e.getType().equals(ExpenditureEnum.PERSONAL)) {
					totalPERSONAL += e.getAmount()*e.getRepeat().getPartsInYear();
					total += e.getAmount()*e.getRepeat().getPartsInYear();

				} else if(e.getType().equals(ExpenditureEnum.SAVINGS)) {
					totalSAVINGS += e.getAmount()*e.getRepeat().getPartsInYear();
					total += e.getAmount()*e.getRepeat().getPartsInYear();

				} else if(e.getType().equals(ExpenditureEnum.UTILITIES)) {
					totalUTILITIES += e.getAmount()*e.getRepeat().getPartsInYear();
					total += e.getAmount()*e.getRepeat().getPartsInYear();

				} else if(e.getType().equals(ExpenditureEnum.CLOTHING)) {
					totalCLOTHING += e.getAmount()*e.getRepeat().getPartsInYear();
					total += e.getAmount()*e.getRepeat().getPartsInYear();

				} else if(e.getType().equals(ExpenditureEnum.MEDICAL)) {
					totalMEDICAL += e.getAmount()*e.getRepeat().getPartsInYear();
					total += e.getAmount()*e.getRepeat().getPartsInYear();

				}
			}
			
			//Print details
			System.out.println(this.getFirstName() + " spends an estimated amount of " + formatter.format(total) + " per year."
					+ "\n " + formatter.format(totalHOUSING) + " on housing "
					+ "\n " + formatter.format(totalTRANSPORTATION) + " on transportation "
					+ "\n " + formatter.format(totalFOOD) + " on food "
					+ "\n " + formatter.format(totalDEBT_PAYMENTS) + " on debt payments "
					+ "\n " + formatter.format(totalPERSONAL) + " on personal "
					+ "\n " + formatter.format(totalSAVINGS) + " on savings "
					+ "\n " + formatter.format(totalUTILITIES) + " on utilities "
					+ "\n " + formatter.format(totalCLOTHING) + " on clothing "
					+ "\n " + formatter.format(totalMEDICAL) + " on medical \n");

			System.out.println(this.getFirstName() + " should spend these amounts per year."
					+ "\n " + formatter.format(ExpenditureEnum.HOUSING.getPercentage()*input.getNetIncome()) + " on housing "
					+ "\n " + formatter.format(ExpenditureEnum.TRANSPORTATION.getPercentage()*input.getNetIncome()) + " on transportation "
					+ "\n " + formatter.format(ExpenditureEnum.FOOD.getPercentage()*input.getNetIncome()) + " on food "
					+ "\n " + formatter.format(ExpenditureEnum.DEBT_PAYMENTS.getPercentage()*input.getNetIncome()) + " on debt payments "
					+ "\n " + formatter.format(ExpenditureEnum.PERSONAL.getPercentage()*input.getNetIncome()) + " on personal "
					+ "\n " + formatter.format(ExpenditureEnum.SAVINGS.getPercentage()*input.getNetIncome()) + " on savings "
					+ "\n " + formatter.format(ExpenditureEnum.UTILITIES.getPercentage()*input.getNetIncome()) + " on utilities "
					+ "\n " + formatter.format(ExpenditureEnum.CLOTHING.getPercentage()*input.getNetIncome()) + " on clothing "
					+ "\n " + formatter.format(ExpenditureEnum.MEDICAL.getPercentage()*input.getNetIncome()) + " on medical ");
			
			double savings = totalSAVINGS;
			double personal = totalPERSONAL;
			
			double rsavings = ExpenditureEnum.SAVINGS.getPercentage()*input.getNetIncome();
			double rpersonal = ExpenditureEnum.PERSONAL.getPercentage()*input.getNetIncome();
			
			//Print more interesting information
			System.out.println("\nWith the savings of: " + formatter.format(savings) + " each year."
					+ "\n " + this.getFirstName() + " could retire in " + Math.round(1000000/savings) + " years with " + formatter.format(savings*(1000000/savings)) + " in savings.");
			
			System.out.println("That is the age of: " + (this.age + Math.round(1000000/(savings))));
			
			System.out.println("\nIncluding personal allowances of " + formatter.format(personal) + "\n"+ this.getFirstName() + " could retire in " + Math.round(1000000/(savings+personal)) + " years with " + formatter.format((savings+personal)*(1000000/(savings+personal))) + " in savings.");
			
			System.out.println("That is the age of: " + (this.age + Math.round(1000000/(savings+personal))));
			
			System.out.println();
			
			System.out.println("\nWith the recommended savings of: " + formatter.format(rsavings) + " each year."
					+ "\n " + this.getFirstName() + " could retire in " + Math.round(1000000/rsavings) + " years with " + formatter.format(rsavings*(1000000/rsavings)) + " in savings.");
			
			System.out.println("That is the age of: " + (this.age + Math.round(1000000/(rsavings))));
			
			System.out.println("\nIncluding the recommeded personal allowances of " + formatter.format(rpersonal) + "\n"+ this.getFirstName() + " could retire in " + Math.round(1000000/(rsavings+rpersonal)) + " years with " + formatter.format((rsavings+rpersonal)*(1000000/(rsavings+rpersonal))) + " in savings.");
			
			System.out.println("That is the age of: " + (this.age + Math.round(1000000/(rsavings+rpersonal))));

		}		
	}
}
