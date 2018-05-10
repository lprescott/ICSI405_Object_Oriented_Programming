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

/*
* @author Luke R. Prescott 
* Student ID: 001252879
*
* Project Name: Final Project - Budget Tracker
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* @file Driver.java accepts no command lines arguments, all interaction is through scanners via the command prompt.
* 	Driver attempts to create one or more Person objects, that will contain the information necessary to create a 
* 	relavent budget, and other interesting information.
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
			
			//One Person
			boolean isUser = true;
			User newUser = new User();
			
			//Create budget, assign budget, then print
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
			
			//More than one person
			System.out.print("\n \t"+ ++qCount +") Are you creating a family budget for those " + personCount + " people? "
					+ "\n \t(String) ");
			
			//Determine if a family budget is to be created
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
				
				//Family budget
				Family family = new Family();
				ArrayList<Person> members = new ArrayList<Person>();
				
				//Loop through all people
				for(int i = 0; i < personCount; i++) {
					if(i == 0) {
						System.out.println("\n\t\tPerson: " + (i+1) + " (User):");
						
						//Creating new user if first
						User newUser = new User();
						
						//Creating, assigning, and adding person to list
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
						
						//Non user **MEMBER**
						System.out.println("\n\t\tPerson: " + (i+1) + ":");
						
						//Create assign then add person to list
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
				
				
				//Finally assign family and print
				family.setMembers(members);
				Budget familyBudget = family.createBudget(family);
				family.printBudget(familyBudget);

				
			} else {
				
				//Non family budget
				@SuppressWarnings("unused")
				ArrayList<Person> people = new ArrayList<Person>();
				
				//Loop through all people, creating and printing consecuative budgets instead of creating
				//	a family budget.
				for(int i = 0; i < personCount; i++) {
					if(i == 0) {
						
						//USER
						System.out.println("\n\t\tPerson: " + (i+1) + " (User):");
						
						User newUser = new User();
						Budget returnable = getBudget(qCount, scanner, true, newUser, false);

						//Create budget, assign budget, then print

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
						
						//MEMBER
						System.out.println("\n\t\tPerson: " + (i+1) + ":");
						
						Member newMember = new Member();
						Budget returnable = getBudget(qCount, scanner, false, newMember, false);
						
						//Create budget, assign budget, then print

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

	/**
	 * This function gets user input from the command line, creating a budget after referecning the flags isUser, isFamily.
	 * 
	 * @param qCount the question count
	 * @param scanner the scanner that is being used
	 * @param isUser is the supplied person a user
	 * @param newUser the user to assign buget to if supploied
	 * @param isFamily is the user a member of the family
	 * @return the created budget
	 */
	public static Budget getBudget(int qCount, Scanner scanner, boolean isUser, Person newUser, boolean isFamily) {
		
		int budgetViaExpenditures = 0;
		
		//Not a family
		if(isFamily == false) {
		
			//Different prints if a user
			if(isUser == true) {
				System.out.print("\n \t" + ++qCount + ") Are you creating your budget via expenditures(1) or yearly figures(2). Type (3) for help."
						+ "\n \t(int) ");
			} else {
				System.out.print("\n \t" + ++qCount + ") Are you creating their budget via expenditures(1) or yearly figures(2). Type (3) for help."
						+ "\n \t(int) ");
			}
			
			int intAnswer = 0;
			
			//Get answer
			try {
				intAnswer = scanner.nextInt();
				scanner.nextLine();
			} catch(Exception e) {
				System.out.println("\n Invalid input. Exiting...");
				scanner.close();
				System.out.println(" Done.");
				return null;
			}
			
			
			//Print help
			if(intAnswer == 3) {
				System.out.print("\n\t --via expenditures: User will create a budget by inputting one day's, week's, or month's, etc. expenditures.\n"
						+ "\t --via yearly figures: User will create a budget by inputting one year's figures (net-income, etc.)."
						+ "\n\n \t(int) ");
				
				//Get answer
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
		
		//Get person details
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
		
		//if the user, say hello
		if (isUser == true) System.out.print("\n \t\tHello " + newUser.getFirstName() + ".");
		
		
		//Budget is created with expenditures
		if(budgetViaExpenditures == 1) {
			
			
			//Get regularity
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
			
			//Check regularity
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
			
			//Now entering expenditures
			ArrayList<Expenditure> expenditures = new ArrayList<Expenditure>();
			System.out.println("\n\t\tEnter all " + temp.getName() + " expenditures, or \"end\" to stop.");				
			
			String userInput;
			String type;
			int count = 0;
			
			//Get expenditures details
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
			    
				//Check if valid expenditure
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
			    
			    //Get user input
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

			//Print output
			System.out.println("\n \t\tCreating budget...");
			Budget testBudget = new Budget(netIncome, 0, expenditures.toArray(new Expenditure[expenditures.size()]));
			System.out.println("\n \t\tDone.");

			return testBudget;

			
		//Is a family
		} else {
			
			//Loop through income, deductions printing new budget
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
			
			//print output
			System.out.println("\n \t\tCreating budget...");
			Budget testBudget = new Budget(netIncome, deductions, null );
			System.out.println("\n \t\tDone.");
			
			return testBudget;

		}
		
	}
}
