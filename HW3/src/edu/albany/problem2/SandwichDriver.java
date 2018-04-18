package edu.albany.problem2;

import java.text.NumberFormat;
import java.util.Random;
import edu.albany.person.customer.Customer;
import edu.albany.person.employee.cashier.Cashier;
import edu.albany.person.employee.sandwichmaker.SandwichMaker;
import edu.albany.problem2.Menu.Sandwich;
import edu.albany.transaction.Transaction;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: April 17th, 2018
*
* Project Name: HW3
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* SandwichDriver.java simulates a single order at a sandwich shop. The number of sandwiches chosen and 
* the choice of said sandwiches are random.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class SandwichDriver {

	public static void main(String[] args) {
		
		//Currency format
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		//Customer, Cashier, SandwvivavvvichMaker created
		Customer customer = new Customer("Jane", "Doe", 20.32); //fN, lN, Cash
		Cashier cashier = new Cashier("Luke", "Prescott", 282.55); //fN, lN, Register Amount
		SandwichMaker cook = new SandwichMaker("John", "Smith", null); //fN, lN, current_orders
		
		//Printing the menu
		Menu.printMenu();

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
		
		//Customer illustrates choice
		System.out.print("\n\t\"I would like a...");
		for(Sandwich s: sandwiches_ordered) {
			System.out.print("\n\t " + s.getName());
		} System.out.println("\"");

		//A new transaction object is created with the sandwiches_ordered
		Transaction test_transaction = new Transaction(sandwiches_ordered);

		
		//The cashier requests payment
		System.out.println("\n\t\"Sure, that will be " + formatter.format(test_transaction.getPrice() + test_transaction.getTax()) + " including tax"+ ".\"");
		
		try {
			//The cashier attempts to receive payment from the customer
			//This will fail if the register has too much or the customer has too little
			Cashier.authenticate(customer, cashier, test_transaction);

		} catch(Exception e) {
			System.out.println("\n\t" + e.getLocalizedMessage());
			return;
		}
		
		//The cashier has successfully authenticated the transaction at this point
		System.out.println("\n\t\"Here you go.\"");
		System.out.println("\n\t\"Have a nice day! Here is your receipt.\"\n");
		
		//Print the receipt upon getting to this point
		test_transaction.printReceipt(customer, cashier, cook);
		
		//The sandwiches makes gets assigned the current transaction
		SandwichMaker.setCurrent_transaction(test_transaction);
		
		//The sandwich maker makes the sandwich(es)
		SandwichMaker.completeOrder();
	}
}
