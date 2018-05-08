package edu.albany.budgettracker.driver;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.albany.budgettracker.budget.Budget;
import edu.albany.budgettracker.person.Family;
import edu.albany.budgettracker.person.Person;
import edu.albany.budgettracker.person.member.Member;
import edu.albany.budgettracker.person.user.User;

public class Driver {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int isFamilyBudget;
		int budgetViaExpenditures;
		
		int qCount = 0;
		
		int personCount = 0;
		String q2;
		int choice;
		
		//Welcome the user, printing project details:
		System.out.format("\n %-15s %s\n %-15s %s\n %-15s %s\n %-15s %s\n", "Author:", 
				"Luke Robert Prescott", "Student ID:", "001252879", "Class:", "ICSI-405", "Project:", "Final");
		System.out.print("\n Welcome to a budget tracker written purely in java."
				+ "\n Let us start with a few simple questions:"
				+ "\n\n \t" + ++qCount + ") How many people are you creating a budget for? "
				+ "\n \t(int) ");
		
		try {
			personCount = scanner.nextInt(); 
			
		} catch(InputMismatchException e) {
			System.out.println("\n Invalid input. Exiting...");
			scanner.close();
			System.out.println(" Done.");
			return;
		}

		if(personCount < 1) {
			System.out.println("\n Invalid input. Exiting...");
			scanner.close();
			System.out.println(" Done.");
			return;
			
		} else if(personCount == 1) {
			budgetViaExpenditures = budget(++qCount);
			
			if(budgetViaExpenditures == -1) {
				System.out.println("\n Invalid input. Exiting...");
				scanner.close();
				System.out.println(" Done.");
				return;
			}
			
			User singleUser = new User();
			
			Budget singleBudget = new Budget();
			
			singleBudget = singleUser.createBudget(singleUser);
			
			singleBudget.printDetails();
			
		} else if(personCount > 1) {
			System.out.print("\n \t"+ ++qCount +") Are you creating a family budget for those " + personCount + " people? "
					+ "\n \t(String) ");
			
			try {
				q2 = scanner.next(); 
				
				if(q2.toLowerCase().contains("yes") || q2.toLowerCase().contains("y")) {
					isFamilyBudget = 1;
				} else if (q2.toLowerCase().contains("no") || q2.toLowerCase().contains("n")) {
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
				
				Family singleFamily = new Family();
				User singleUser = new User();
				singleFamily.getMembers().add(singleUser);
				
				for(int x = 1; x < personCount; x++) {
					Member tempMember = new Member();
					singleFamily.getMembers().add(tempMember);
				}
				
				Budget familyBudget = new Budget();
				familyBudget = singleFamily.createBudget(singleFamily);
				
			} else {
				
				Person[] members = new Person[personCount];
				Budget[] budgets = new Budget[personCount];
				
				User singleUser = new User();
				members[0] = singleUser;
				budgets[0] = singleUser.createBudget(singleUser);
				
				for(int x = 1; x < personCount; x++) {
					Member tempMember = new Member();
					members[x] = tempMember;
					budgets[x] = tempMember.createBudget(tempMember);

				}
			}
		} 

		scanner.close();
	}

	private static int budget(int qCount) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\n \t" + qCount + ") Are you creating your budget via expenditures(1) or yearly figures(2). Type (3) for help."
				+ "\n \t(int) ");
		int choice = scanner.nextInt();
		
		if(choice == 1) {
			scanner.close();
			return 1;
		} else if(choice == 2) {
			scanner.close();
			return 0;
		} else if(choice == 3) {
			System.out.print("\n\t --via expenditures: User will create a budget by inputting one day's, week's, month's, etc. expenditures.\n"
					+ "\t --via yearly figures: User will create a budget by inputting one year's figures (net-income, deductions, etc.)."
					+ "\n\n \t(int) ");
			choice = scanner.nextInt();
			if(choice == 1) {
				scanner.close();
				return 1;
			} else if(choice == 2) {
				scanner.close();
				return 0;
			} else {
				scanner.close();
				return -1;
			}
		} else {
			scanner.close();
			return -1;
		}
	}
}
