package edu.albany.budgettracker.person;

import java.text.NumberFormat;

import edu.albany.budgettracker.budget.Budget;
import edu.albany.budgettracker.budget.expenditure.Expenditure;
import edu.albany.budgettracker.budget.expenditure.ExpenditureEnum;
import edu.albany.budgettracker.budget.expenditure.Regularity;
import edu.albany.budgettracker.person.member.Member;
import edu.albany.budgettracker.person.user.User;

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
			
			for(ExpenditureEnum e : ExpenditureEnum.values()) {
				System.out.println(e.getName() + " : " + formatter.format(e.getPercentage()*input.getNetIncome()));
				if(e.getName().equals("savings")) {
					savings = e.getPercentage()*input.getNetIncome();
				}
				if(e.getName().equals("personal")) {
					personal = e.getPercentage()*input.getNetIncome();
				}
			}
			
			System.out.println("\nWith the savings of: " + savings + " each year."
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
