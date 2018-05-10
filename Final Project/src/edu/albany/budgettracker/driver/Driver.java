package edu.albany.budgettracker.driver;

import java.util.ArrayList;
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
			
		} catch(Exception e) {
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
			boolean isUser = true;
			User newUser = new User();
			
			Budget returnable = getBudget(qCount, scanner, isUser, newUser, false);

			
			if(returnable == null) {
				return;
			} else {
				newUser.setUserID(personCount);
				newUser.setPersonalBudget(returnable);
				newUser.setHasGroupBudget(false);
				newUser.printBudget(returnable);
			}
			
			
		} else if(personCount > 1) {
			System.out.print("\n \t"+ ++qCount +") Are you creating a family budget for those " + personCount + " people? "
					+ "\n \t(String) ");
			
			try {
				stringAnswer = scanner.nextLine(); 
				
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
				
			} catch(Exception e) {
				System.out.println("\n Invalid input. Exiting...");
				scanner.close();
				System.out.println(" Done.");
				return;
			}
			
			if(isFamilyBudget == 1) {
				
				Family family = new Family();
				ArrayList<Person> members = new ArrayList<Person>();
				
				for(int i = 0; i < personCount; i++) {
					if(i == 0) {
						System.out.println("\n\t\tPerson: " + (i+1) + " (User):");
						
						User newUser = new User();
						Budget returnable = getBudget(qCount, scanner, true, newUser, true);

						
						if(returnable == null) {
							System.out.println("\n Unknown error. Exiting...");
							scanner.close();
							System.out.println(" Done.");
							return;
						} else {
							newUser.setUserID(personCount);
							newUser.setPersonalBudget(returnable);
							newUser.setHasGroupBudget(false);
							//newUser.printBudget(returnable);
						}
						
						members.add(newUser);
						
					} else {
						System.out.println("\n\t\tPerson: " + (i+1) + ":");
						
						Member newMember = new Member();
						Budget returnable = getBudget(qCount, scanner, false, newMember, true);
						
						if(returnable == null) {
							System.out.println("\n Unknown error. Exiting...");
							scanner.close();
							System.out.println(" Done.");
							return;
						} else {
							newMember.setPersonalBudget(returnable);
							//newMember.printBudget(returnable);
						}
						
						members.add(newMember);

					}
				}
				
				family.setMembers(members);
				Budget familyBudget = family.createBudget();
				family.printBudget(familyBudget);

				
			} else {
				
				ArrayList<Person> people = new ArrayList<Person>();
				
				for(int i = 0; i < personCount; i++) {
					if(i == 0) {
						System.out.println("\n\t\tPerson: " + (i+1) + " (User):");
						
						User newUser = new User();
						Budget returnable = getBudget(qCount, scanner, true, newUser, false);

						
						if(returnable == null) {
							System.out.println("\n Unknown error. Exiting...");
							scanner.close();
							System.out.println(" Done.");
							return;
						} else {
							newUser.setUserID(personCount);
							newUser.setPersonalBudget(returnable);
							newUser.setHasGroupBudget(false);
							newUser.printBudget(returnable);
						}
						
						newUser.printBudget(returnable);
						
					} else {
						System.out.println("\n\t\tPerson: " + (i+1) + ":");
						
						Member newMember = new Member();
						Budget returnable = getBudget(qCount, scanner, false, newMember, false);
						
						if(returnable == null) {
							System.out.println("\n Unknown error. Exiting...");
							scanner.close();
							System.out.println(" Done.");
							return;
						} else {
							newMember.setPersonalBudget(returnable);
							newMember.printBudget(returnable);
						}
						
						newMember.printBudget(returnable);
					}
				}
			}
		} 

		scanner.close();
	}

	private static Budget getBudget(int qCount, Scanner scanner, boolean isUser, Person newUser, boolean isFamily) {
		
		int budgetViaExpenditures = 0;
		
		if(isFamily == false) {
		
			if(isUser == true) {
				System.out.print("\n \t" + ++qCount + ") Are you creating your budget via expenditures(1) or yearly figures(2). Type (3) for help."
						+ "\n \t(int) ");
			} else {
				System.out.print("\n \t" + ++qCount + ") Are you creating their budget via expenditures(1) or yearly figures(2). Type (3) for help."
						+ "\n \t(int) ");
			}
			
			int intAnswer = 0;
			
			try {
				intAnswer = scanner.nextInt();
				scanner.nextLine();
			} catch(Exception e) {
				System.out.println("\n Invalid input. Exiting...");
				scanner.close();
				System.out.println(" Done.");
				return null;
			}
			
			
			if(intAnswer == 3) {
				System.out.print("\n\t --via expenditures: User will create a budget by inputting one day's, week's, or month's, etc. expenditures.\n"
						+ "\t --via yearly figures: User will create a budget by inputting one year's figures (net-income, etc.)."
						+ "\n\n \t(int) ");
				try {
					intAnswer = scanner.nextInt();
					scanner.nextLine();
				} catch(Exception e) {
					System.out.println("\n Invalid input. Exiting...");
					scanner.close();
					System.out.println(" Done.");
					return null;
				}
				
				if(intAnswer == 3) {
					System.out.println("\n Invalid input. Exiting...");
					scanner.close();
					System.out.println(" Done.");
					return null;
				}
			} 		
			
			if(intAnswer == 1 ) budgetViaExpenditures = 1;
		
		} 
		
		
		try {
			System.out.print("\n \t"+ ++qCount +") First name? "
					+ "\n \t(String) ");
			newUser.setFirstName(scanner.nextLine());
			
			System.out.print("\n \t"+ ++qCount +") Last name? "
					+ "\n \t(String) ");
			newUser.setLastName(scanner.nextLine());
			
			System.out.print("\n \t"+ ++qCount +") Age? "
					+ "\n \t(int) ");
			newUser.setAge(scanner.nextInt());
			scanner.nextLine();
			
			System.out.print("\n \t"+ ++qCount +") Income? "
					+ "\n \t(double) $");
			newUser.setIncome(scanner.nextDouble());
			scanner.nextLine();
			
		} catch(Exception e) {
			System.out.println("\n Invalid input. Exiting...");
			scanner.close();
			System.out.println(" Done.");
			return null;
		}
		
		if (isUser == true) System.out.print("\n \t\tHello " + newUser.getFirstName() + ".");
		
		
		if(budgetViaExpenditures == 1) {
			
			
			if(isUser == true) {
				System.out.print("\n\n \t"+ ++qCount +") What is the regularity of your expenditures (Daily, Weekly, Monthly, Semi-Annually, Annually)? "
						+ "\n \t(String) ");	
			} else {
				System.out.print("\n\n \t"+ ++qCount +") What is the regularity of their expenditures (Daily, Weekly, Monthly, Semi-Annually, Annually)? "
						+ "\n \t(String) ");	
			}
			String regularity = null;
			
			try {
				regularity = scanner.nextLine().toLowerCase();
			} catch(Exception e) {
				System.out.println("\n Invalid input. Exiting...");
				scanner.close();
				System.out.println(" Done.");
				return null;
			}
			
			Regularity temp;
			
			if(regularity.contains(Regularity.DAILY.getName().toLowerCase())) {
				temp = Regularity.DAILY;
				
			} else if(regularity.contains(Regularity.WEEKLY.getName().toLowerCase())) {
				temp = Regularity.WEEKLY;

			} else if(regularity.contains(Regularity.MONTHLY.getName().toLowerCase())) {
				temp = Regularity.MONTHLY;

			} else if((regularity.contains(Regularity.SEMI_ANNUALLY.getName().toLowerCase()))) {
				temp = Regularity.SEMI_ANNUALLY;

			} else if(regularity.contains(Regularity.ANNUALLY.getName().toLowerCase())) {
				temp = Regularity.ANNUALLY;

			} else {
				System.out.println("\n Invalid input. Exiting...");
				scanner.close();
				System.out.println(" Done.");
				return null;
			}
			
			ArrayList<Expenditure> expenditures = new ArrayList<Expenditure>();
			System.out.println("\n\t\tEnter all " + temp.getName() + " expenditures, or \"end\" to stop.");				
			
			String userInput;
			String type;
			int count = 0;
			
			do {
				ExpenditureEnum tempreg;
				
				System.out.print("\n \t\t" + ++count + ") Expenditure type (clothing, debt payments, food, housing, medical, personal, savings, transportation, utilities):"
						+ "\n \t\t(String) ");	
				
				try {
					type = scanner.nextLine();
				} catch(Exception e) {
					System.out.println("\n Invalid input. Exiting...");
					scanner.close();
					System.out.println(" Done.");
					return null;
				}
			    
			    if(type.toLowerCase().equals("end")) {
			    	
					break;
			    } else if(type.toLowerCase().contains(ExpenditureEnum.CLOTHING.getName())) {
			    	tempreg = ExpenditureEnum.CLOTHING;
				} else if(type.toLowerCase().contains(ExpenditureEnum.DEBT_PAYMENTS.getName())) {
			    	tempreg = ExpenditureEnum.DEBT_PAYMENTS;
				} else if(type.toLowerCase().contains(ExpenditureEnum.FOOD.getName())) {
			    	tempreg = ExpenditureEnum.FOOD;
				} else if(type.toLowerCase().contains(ExpenditureEnum.HOUSING.getName())) {
			    	tempreg = ExpenditureEnum.HOUSING;
				} else if(type.toLowerCase().contains(ExpenditureEnum.MEDICAL.getName())) {
			    	tempreg = ExpenditureEnum.MEDICAL;
				} else if(type.toLowerCase().contains(ExpenditureEnum.PERSONAL.getName())) {
			    	tempreg = ExpenditureEnum.PERSONAL;
				} else if(type.toLowerCase().contains(ExpenditureEnum.SAVINGS.getName())) {
			    	tempreg = ExpenditureEnum.SAVINGS;
				} else if(type.toLowerCase().contains(ExpenditureEnum.TRANSPORTATION.getName())) {
			    	tempreg = ExpenditureEnum.TRANSPORTATION;
				} else if(type.toLowerCase().contains(ExpenditureEnum.UTILITIES.getName())) {
			    	tempreg = ExpenditureEnum.UTILITIES;
				} else {
					System.out.println("\n Invalid input. Exiting...");
					scanner.close();
					System.out.println(" Done.");
					return null;
				}
			    
			    System.out.print("\n\t\t" + count + ") Enter expenditure amount."
						+ "\n \t\t(double) ");
			    
			    try {
			    	 userInput = scanner.nextLine();
			    } catch(Exception e) {
					System.out.println("\n Invalid input. Exiting...");
					scanner.close();
					System.out.println(" Done.");
					return null;
				}
			    
			    Expenditure expenditure = new Expenditure(Double.parseDouble(userInput), tempreg, temp);
			    expenditures.add(expenditure);
			}
			while (!"end".equals(userInput));
			double netIncome = newUser.getIncome();

			System.out.println("\n \t\tCreating budget...");
			Budget testBudget = new Budget(netIncome, 0, expenditures.toArray(new Expenditure[expenditures.size()]));
			System.out.println("\n \t\tDone.");

			return testBudget;

			
		} else {
			
			Double netIncome, deductions;

			netIncome = newUser.getIncome();
			
			System.out.print("\n\n \t"+ ++qCount +") Deductions? "
					+ "\n \t(Double) ");
			try {
				deductions = scanner.nextDouble();
				scanner.nextLine();
			} catch(Exception e) {
				System.out.println("\n Invalid input. Exiting...");
				scanner.close();
				System.out.println(" Done.");
				return null;
			}
			
			
			System.out.println("\n \t\tCreating budget...");
			Budget testBudget = new Budget(netIncome, deductions, null );
			System.out.println("\n \t\tDone.");
			
			return testBudget;

		}
		
	}
}
