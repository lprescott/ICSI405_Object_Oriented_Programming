package edu.albany.transaction;

import java.text.DecimalFormat;

import edu.albany.person.employee.sandwichmaker.SandwichMaker.Sandwich;

public class Transaction {
	
	private static int count = 0;
	private Sandwich[] order;

	/**
	 * @return the order
	 */
	public Sandwich[] getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Sandwich[] order) {
		this.order = order;
	}
	/**
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public static void setCount(int count) {
		Transaction.count = count;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		
		final DecimalFormat df = new DecimalFormat("#.##");

		double count = 0;
		for(Sandwich s : this.getOrder()) {
			count += s.getPrice();
		}

		return Double.parseDouble(df.format(count));
	}


	
	public Transaction(Sandwich[] new_order){
		this.order = new_order;
		count++;
	}
	
	public void printReceipt() {
		
		System.out.println("Receipt (Order # " + Transaction.getCount() + "): ");
		System.out.println("-------------------------------");
		System.out.println(String.format("%-25s%s" , "Total", "Price"));
		System.out.println("-------------------------------");
		for(Sandwich s : this.getOrder()) {
			System.out.println(s.toString());
		}
		System.out.println("-------------------------------");
		System.out.println(String.format("%-25s$%s" , "Total", this.getPrice()));

		
	}

}
