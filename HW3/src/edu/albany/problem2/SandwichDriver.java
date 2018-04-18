package edu.albany.problem2;

import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

import edu.albany.person.customer.Customer;
import edu.albany.person.employee.cashier.Cashier;
import edu.albany.person.employee.sandwichmaker.SandwichMaker;
import edu.albany.person.employee.sandwichmaker.SandwichMaker.Sandwich;
import edu.albany.transaction.Transaction;

public class SandwichDriver {

	public static void main(String[] args) {
		
		//Currency format
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		//Customer, Cashier, SandwvivavvvichMaker created
		Customer customer = new Customer("Jane", "Doe", 20.32); //fN, lN, Cash
		Cashier cashier = new Cashier("Luke", "Prescott", 282.55); //fN, lN, Register Amount
		SandwichMaker cook = new SandwichMaker("John", "Smith", null); //fN, lN, current_orders
		
		//Printing the menu
		printMenu();
		
	    Scanner keyboard = new Scanner(System.in);


		//Cashier greets the customer
		System.out.println("\n\t\"Hello, what can I get you?\"");
		
		//Customer chooses a number  of sandwiches 
		//(Randomly using random number generator)
		Random rand = new Random();
		int num_sandwiches = rand.nextInt(Sandwich.getCount()) + 1;
		
		int temp;
		//Populate the number of sandwiches with random sandwiches
		Sandwich[] sandwiches_ordered = new Sandwich[num_sandwiches];
		for(int i = 0; i < num_sandwiches; i++) {
			temp = rand.nextInt(Sandwich.getCount())+1;
			switch (temp) {
	        	case 1:  sandwiches_ordered[i] = Sandwich.BBQ;
	            	break;
	            case 2:  sandwiches_ordered[i] = Sandwich.BLT;
	                break;
	            case 3:  sandwiches_ordered[i] = Sandwich.GRILLEDCHEESE;
	                break;
	            case 4:  sandwiches_ordered[i] = Sandwich.MEATBALL;
	                break;
	            case 5:  sandwiches_ordered[i] = Sandwich.TURKEY;
	                break;		
			}
		}
		
		System.out.print("\n\t\"I would like a...");
		for(Sandwich s: sandwiches_ordered) {
			System.out.print("\n\t " + s.getName());
		} System.out.println("\"");

		Transaction test_transaction = new Transaction(sandwiches_ordered);
				
		System.out.println("\n\t\"Sure, that will be " + formatter.format(test_transaction.getPrice()) + ".\"");
		
		try {
			Cashier.authenticate(customer, cashier, test_transaction);
			test_transaction.printReceipt(customer, cashier, cook);
		} catch(Exception e) {
			System.out.println("\n\t" + e.getLocalizedMessage());
			return;
		}
		
		System.out.println("\n\t\"Here you go.\"");
		System.out.println("\n\t\"Have a nice day! Here is your receipt.\"\n");
		SandwichMaker.completeOrder(test_transaction);
		
	}

	private static void printMenu() {
		
		String seperator = "-------------------------------";
		
		System.out.println("Menu\n" + seperator);
		System.out.println(String.format("%-25s%s" , "Type", "Price" + "\n" + seperator));
		for(Sandwich s: Sandwich.values()) {
			System.out.println(s);
		} System.out.println(seperator);
	}
}
