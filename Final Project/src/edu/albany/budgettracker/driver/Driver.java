package edu.albany.budgettracker.driver;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.albany.budgettracker.budget.Budget;
import edu.albany.budgettracker.budget.expenditure.Expenditure;
import edu.albany.budgettracker.budget.expenditure.ExpenditureEnum;
import edu.albany.budgettracker.budget.expenditure.Regularity;
import edu.albany.budgettracker.person.Family;
import edu.albany.budgettracker.person.Person;
import edu.albany.budgettracker.person.member.Member;
import edu.albany.budgettracker.person.user.User;

public class Driver {

	public static void main(String[] args) {

		//Create a scanner that will hold user input
		Scanner scanner = new Scanner(System.in);
		
		//Boolean values to determine if a family budget is being created or a budget is being made using expenditures
		int isFamilyBudget;
		int budgetViaExpenditures = 0;
		
		//The number of questions asked
		int qCount = 0;
		
		int personCount = 0; //A count to hold the number of persons
		
		//Variables to contains user answers
		String stringAnswer; 
		
		//Welcome the user, printing project details:
		System.out.print(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.format("\n %-15s %s\n %-15s %s\n %-15s %s\n %-15s %s\n", "Author:", 
				"Luke Robert Prescott", "Student ID:", "001252879", "Class:", "ICSI-405", "Project:", "Final");
		
		System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		//Get number of people
		System.out.print("\n Welcome to a budget tracker written purely in java."
				+ "\n Let us start with a few simple questions:"
				+ "\n\n \t" + ++qCount + ") How many people are you creating a budget for? "
				+ "\n \t(int) ");
		
		//try catch the scanner of an int
		try {
			personCount = scanner.nextInt();
			scanner.nextLine();
			
		} catch(InputMismatchException e) {
			System.out.println("\n Invalid input. Exiting...");
			scanner.close();
			System.out.println(" Done.");
			return;
		}

		//Check number of people
		if(personCount < 1) {
			System.out.println("\n Invalid input. Exiting...");
			scanner.close();
			System.out.println(" Done.");
			return;
			
		} else if(personCount == 1) {
			
			
			User singleUser = new User();
			
			System.out.print("\n \t" + ++qCount + ") Are you creating your budget via expenditures(1) or yearly figures(2). Type (3) for help."
					+ "\n \t(int) ");
			
			int intAnswer = scanner.nextInt();
			scanner.nextLine();
			
			if(intAnswer == 3) {
				System.out.print("\n\t --via expenditures: User will create a budget by inputting one day's, week's, or month's, etc. expenditures.\n"
						+ "\t --via yearly figures: User will create a budget by inputting one year's figures (net-income, deductions, etc.)."
						+ "\n\n \t(int) ");
				intAnswer = scanner.nextInt();
				scanner.nextLine();
				if(intAnswer == 3) {
					System.out.println("\n Invalid input. Exiting...");
					scanner.close();
					System.out.println(" Done.");
					return;
				}
			} 		
			
			if(intAnswer == 1) budgetViaExpenditures = 1;

			try {
				System.out.print("\n \t"+ ++qCount +") First name? "
						+ "\n \t(String) ");
				singleUser.setFirstName(scanner.nextLine());
				
				System.out.print("\n \t"+ ++qCount +") Last name? "
						+ "\n \t(String) ");
				singleUser.setLastName(scanner.nextLine());
				
				System.out.print("\n \t"+ ++qCount +") Age? "
						+ "\n \t(int) ");
				singleUser.setAge(scanner.nextInt());
				scanner.nextLine();
				
				System.out.print("\n \t"+ ++qCount +") Income? "
						+ "\n \t(double) $");
				singleUser.setIncome(scanner.nextDouble());
				scanner.nextLine();
				
			} catch(InputMismatchException e) {
				System.out.println("\n Invalid input. Exiting...");
				scanner.close();
				System.out.println(" Done.");
				return;
			}
			
			System.out.print("\n \tHello " + singleUser.getFirstName() + " " + singleUser.getLastName() + " age, " + singleUser.getAge() + ".");
			
			
			if(budgetViaExpenditures == 1) {
				System.out.print("\n \t"+ ++qCount +") Regularity (Daily, Weekly, Monthly, Semi-Annually, Annually)? "
						+ "\n \t(String) ");				
				String regularity = scanner.nextLine().toLowerCase();
				
				Regularity temp;
				
				if(regularity.equals(Regularity.DAILY.getName())) {
					temp = Regularity.DAILY;
					
				} else if(regularity.equals(Regularity.WEEKLY.getName())) {
					temp = Regularity.WEEKLY;

				} else if(regularity.equals(Regularity.MONTHLY.getName())) {
					temp = Regularity.MONTHLY;

				} else if((regularity.equals(Regularity.SEMI_ANNUALLY.getName()))) {
					temp = Regularity.SEMI_ANNUALLY;

				} else if(regularity.equals(Regularity.ANNUALLY.getName())) {
					temp = Regularity.ANNUALLY;

				} else {
					System.out.println("\n Invalid input. Exiting...");
					scanner.close();
					System.out.println(" Done.");
					return;
				}
				
				ArrayList<Expenditure> expenditures = new ArrayList<Expenditure>();
				System.out.println("\n\tOkay, please enter all " + temp.getName() + " expenditures amounts, then type, or \"end\" to stop."
						+ "\n \t(Double/end) ");				
				
				String userInput;
				String type;
				
				do {
					ExpenditureEnum tempreg;
					
					System.out.print("\tType (clothing, debt payments, food, housing, medical, personal, savings, transportation, utilities): ");
				    type = scanner.nextLine();
				    
				    if(type.toLowerCase().equals("end")) {
				    	break;
				    } else if(type.toLowerCase().equals(ExpenditureEnum.CLOTHING.getName())) {
				    	tempreg = ExpenditureEnum.CLOTHING;
					} else if(type.toLowerCase().equals(ExpenditureEnum.DEBT_PAYMENTS.getName())) {
				    	tempreg = ExpenditureEnum.DEBT_PAYMENTS;
					} else if(type.toLowerCase().equals(ExpenditureEnum.FOOD.getName())) {
				    	tempreg = ExpenditureEnum.FOOD;
					} else if(type.toLowerCase().equals(ExpenditureEnum.HOUSING.getName())) {
				    	tempreg = ExpenditureEnum.HOUSING;
					} else if(type.toLowerCase().equals(ExpenditureEnum.MEDICAL.getName())) {
				    	tempreg = ExpenditureEnum.MEDICAL;
					} else if(type.toLowerCase().equals(ExpenditureEnum.PERSONAL.getName())) {
				    	tempreg = ExpenditureEnum.PERSONAL;
					} else if(type.toLowerCase().equals(ExpenditureEnum.SAVINGS.getName())) {
				    	tempreg = ExpenditureEnum.SAVINGS;
					} else if(type.toLowerCase().equals(ExpenditureEnum.TRANSPORTATION.getName())) {
				    	tempreg = ExpenditureEnum.TRANSPORTATION;
					} else if(type.toLowerCase().equals(ExpenditureEnum.UTILITIES.getName())) {
				    	tempreg = ExpenditureEnum.UTILITIES;
					} else {
						System.out.println("\n Invalid input. Exiting...");
						scanner.close();
						System.out.println(" Done.");
						return;
					}
				    
				    System.out.print("\tAmmount: ");
				    userInput = scanner.nextLine();
				    
				    Expenditure expenditure = new Expenditure(Double.parseDouble(userInput), null, temp);
				    expenditures.add(expenditure);
				}
				while (!"end".equals(userInput));
				
				Budget testBudget = new Budget(0, 0, expenditures.toArray(new Expenditure[expenditures.size()]));

				singleUser.printBudget(testBudget);

				
			} else {
				
				Double netIncome, deductions;
	
				netIncome = singleUser.getIncome();
				System.out.println("Your income is: " + netIncome);
				
				System.out.print("\n \t"+ ++qCount +") Deductions? "
						+ "\n \t(Double) ");
				deductions = scanner.nextDouble();
				scanner.nextLine();
				
				Budget testBudget = new Budget(netIncome, deductions, null );
				
				singleUser.printBudget(testBudget);

			}
		} else if(personCount > 1) {
			System.out.print("\n \t"+ ++qCount +") Are you creating a family budget for those " + personCount + " people? "
					+ "\n \t(String) ");
			
			try {
				stringAnswer = scanner.next(); 
				
				if(stringAnswer.toLowerCase().contains("yes") || stringAnswer.toLowerCase().contains("y")) {
					isFamilyBudget = 1;
				} else if (stringAnswer.toLowerCase().contains("no") || stringAnswer.toLowerCase().contains("n")) {
					isFamilyBudget = 2;
				} else {
					System.out.println("\n Invalid input. Exiting...");
					scanner.close();
					System.out.println(" Done.");
					return;
				}
				
			} catch(InputMismatchException e) {
				System.out.println("\n Invalid input. Exiting...");
				scanner.close();
				System.out.println(" Done.");
				return;
			}
			
			if(isFamilyBudget == 1) {
				
			} else {
				
			}
		} 

		scanner.close();
	}
}
