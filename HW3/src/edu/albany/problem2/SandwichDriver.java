package edu.albany.problem2;

import java.text.NumberFormat;
import java.util.Random;

import edu.albany.person.customer.Customer;
import edu.albany.person.employee.cashier.Cashier;
import edu.albany.person.employee.sandwichmaker.SandwichMaker;
import edu.albany.person.employee.sandwichmaker.SandwichMaker.Sandwich;

public class SandwichDriver {

	public static void main(String[] args) {
		
		//Currency format
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		//Play with these variables if needed
		Customer business_man = new Customer("John", "Rockefeller", 15032.26);
		Cashier college_student = new Cashier("Luke", "Prescott", 001, 100.55);
		SandwichMaker cook = new SandwichMaker("Jane", "Doe", 002, null, 0);
		
		//Modelling the purchase of the sandwich
		//Display sandwich options and prices
		System.out.println(String.format("Menu:\n%-25s%s" , "Sandwich:", "Price:" ));
		for(Sandwich s: Sandwich.values()) {
			System.out.println(s);
		}
		
		System.out.println("\nThe cashier, " + college_student.toString());
		System.out.println(business_man.toString() + ".");
		
		//Cashier greets the customer
		System.out.println("\n\"Hello sir, what can I get you?\"");
		//Customer chooses sandwich (Randomly using random number generator)
		Random rand = new Random();
		int choice = rand.nextInt(5); 
		Sandwich chosen_sandwich = null;
		
		int count = 0;
		for(Sandwich s2: Sandwich.values()) {
			if(choice == count) {
				chosen_sandwich = s2;
			}
			count++;
		}
		
		int num_sandwiches = rand.nextInt(5) + 1;
		System.out.println("\"I will take " + num_sandwiches + " " + chosen_sandwich.getName() + "(s).\"");
		System.out.println("\"Sure, that will be " + formatter.format(num_sandwiches * chosen_sandwich.getPrice()) + ".\"");
		System.out.println("\"Here you go.\"");
		System.out.println("\"Have a nice day! You sandwich will be brought to your table.\"");
		
		//Customer transfers funds
		transaction(business_man, college_student, cook, num_sandwiches, chosen_sandwich);

		//Print details
		System.out.println("\nThe cashier, " + college_student.toString() + ".");
		System.out.println("" + business_man.toString() + ".");
		System.out.println("The cook, " + cook.toString());

		
	}

	private static void transaction(Customer business_man, Cashier college_student, SandwichMaker cook,
			int num_sandwiches, Sandwich chosen_sandwich) {
		double transaction_total = num_sandwiches * chosen_sandwich.getPrice();
		
		business_man.setDisposable_income(business_man.getDisposable_income() - transaction_total);
		college_student.setCash_register_amount(college_student.getCash_register_amount() + transaction_total);
		cook.setCurrent_sandwich(chosen_sandwich); 
		cook.setNum_current_sandwiches(num_sandwiches);
	}

}
