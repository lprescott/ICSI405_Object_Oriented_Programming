package edu.albany.hw2.stock;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: Feb 24th, 2018
*
* Project Name: HW2
* Package Name: edu.albany.hw2.stock
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* The StockTester.java file fulfills the following requirements:
* 
* Write a test program that creates a Stock object with the stock symbol MSFT and the previous closing 
* stock price of 58.9. Set a new current price to 59 and display the price change percentage. Repeat 
* for one other company.
* 
* Output:
* The percent change for the Microsoft stock is: 0.16977928692699734%
* The percent change for the Apple stock is: 17.75362318840579%
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

public class StockTester {

	/*
	 * The main method where testing will occur.
	 */
	public static void main(String[] args) {
		
		//Write a test program that creates a Stock object with the stock symbol MSFT and the previous 
		//closing stock price of 58.9. 
		Stock MicrosoftStock = new Stock(Stock.Symbol.MSFT); 
		MicrosoftStock.setPreviousClosingPrice(58.9);
		
		//Set a new current price to 59 and display the price change percentage.
		MicrosoftStock.setCurrentPrice(59);
		System.out.println("The percent change for the Microsoft stock is: " + MicrosoftStock.getChangePercent() + "%");
		
		//Repeat for one other company.
		Stock AppleStock = new Stock(Stock.Symbol.AAPL); 
		AppleStock.setPreviousClosingPrice(55.2);
		AppleStock.setCurrentPrice(65);
		System.out.println("The percent change for the Apple stock is: " + AppleStock.getChangePercent() + "%");
	}
}
