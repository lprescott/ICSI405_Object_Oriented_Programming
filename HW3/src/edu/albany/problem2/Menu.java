package edu.albany.problem2;

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
* Menu.java defines the current menu that the Sandwich shop has, formatted as an enumeration. 
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class Menu {
	public enum Sandwich {
		
	    TURKEY("Turkey Sandwich", 5.89), 
	    BBQ("BBQ Sandwich", 4.25),
	    BLT("BLT Sandwich", 4.51),
	    MEATBALL("Meatball Sandwich", 5.55),
	    GRILLEDCHEESE("Grilled-Cheese Sandwich", 3.25);
		
		//Instance variables
		private String name;
		private double price;
		
		//A static variable defining the number of items on the menu
		private static int count = 5;
		
		/*
		 * Constructor that takes a new name and price
		 */
		Sandwich(String new_name, double new_price) {
			this.name = new_name;
			this.price = new_price;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the price
		 */
		public double getPrice() {
			return price;
		}

		/**
		 * @return the count
		 */
		public static int getCount() {
			return count;
		}
		
		/*
		 * This function returns the sandwich item's name and price in a well formatted string.
		 */
		public String toString() {
			return String.format("%-25s$%s" , this.getName(), this.getPrice());
		}
		
		/*
		 * The printMenu loops through the Menu formatting and print the menu to aid in the
		 * simulation.
		 */
		public static void printMenu() {
			String seperator = "-------------------------------";
			System.out.println("Menu\n" + seperator);
			System.out.println(String.format("%-25s%s" , "Type", "Price" + "\n" + seperator));
			for(Sandwich s: Sandwich.values()) {
				System.out.println(s);
			} System.out.println(seperator);
		}
	}
}
