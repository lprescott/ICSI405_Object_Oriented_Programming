package com.ualbany.hw1.problem3;

//Imported Libraries:
import java.text.DecimalFormat;

/**
 * @author Luke R. Prescott
 * Student ID: 001252879
 * 
 * Start Date: Feb 11, 2018
 *
 * Project Name: HW1
 * Package Name: com.ualbany.hw1.problem3
 * 
 * Bank – Bank is “associated” with the checking account. Bank has a String name and address.
 * 
 */
public class Bank {

	/**
	 * This main method is used to test all objects and their methods in the package com.ualbany.hw1.problem3
	 * 
	 * @param args no args accepted
	 */
	public static void main(String [] args) {
		
		// Simulate a person arriving to the bank (print the person’s name, and the bank’s name). 
		//Create new addresses
		Address personAddress = new Address("1234 Main St.", "Apartment 201", "Albany", "New York" , "12309");
		Address bankAddress = new Address("1234 South St.", "First Floor", "Albany", "New York" , "12309");
		
		//Create new bank and person
		Person aPerson = new Person("Luke", "Prescott", personAddress, null);
		Bank aBank = new Bank("CapCom FCU", bankAddress, null);
		
		//Print respective information using newly created objects
		System.out.println("Person name: " + aPerson.getFirstName() + " " + aPerson.getLastName() + ".");
		System.out.println("Bank name: " + aBank.getName() + ".\n");

		// Then simulate the person opening an account with initial deposit of $1000. 
		System.out.println("Opening account with $1000...");
		CheckingBankAccount aAccount = new CheckingBankAccount(1000);
		aPerson.setBankAccount(aAccount); //Assign the bank account to the person
		aBank.setAccount(aAccount); //and the bank
		
		// Simulate a deposit of $1000 and a withdrawal of $500. 
		// Every time a withdrawal or deposit happens, a receipt is printed with the name,
		// address of the person and his/her current balance.
		
		System.out.println("\nDepositing $1000...");
		aAccount.deposit(1000);
		printReceipt(aPerson);
		
		System.out.println("\nWithdrawing $500...");
		aAccount.withdraw(500);
		printReceipt(aPerson);

	}
	
	//Instance variables:
	private String name;
	private Address localAddress;
	private CheckingBankAccount Account;
	
	//Getters and Setters:
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the localAddress
	 */
	public Address getLocalAddress() {
		return localAddress;
	}
	/**
	 * @param localAddress the localAddress to set
	 */
	public void setLocalAddress(Address localAddress) {
		this.localAddress = localAddress;
	}
	/**
	 * @return the account
	 */
	public CheckingBankAccount getAccount() {
		return Account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(CheckingBankAccount account) {
		Account = account;
	}
	
	//Constructor(s):
	
	/**
	 * @param name
	 * @param localAddress
	 * @param account
	 */
	public Bank(String name, Address localAddress, CheckingBankAccount account) {
		this.name = name;
		this.localAddress = localAddress;
		Account = account;
	}
	
	//Method(s):
	
	/*
	 * printReceipt accepts a person as a parameter
	 * Every time a withdrawal or deposit happens, printReceipt is called, printing the name, address 
	 * of the person and his/her current balance.
	 * 
	 * @param person the accepted person objects
	 */
	public static void printReceipt(Person person) {
		//Creates a new decimal format that rounds to two decimal points, i.e. money
    	DecimalFormat money = new DecimalFormat("#.00");
    	
		System.out.println("----------------Receipt---------------\n"
				+ "\tFirst Name: " + person.getFirstName() + "\n"
				+ "\tLast Name: " + person.getLastName() + "\n"
				+ person.getHomeAddress().toString() 
				+ "\tBalance: $" + money.format(person.getBankAccount().getValue())
				+ "\n--------------------------------------");
	}
}
