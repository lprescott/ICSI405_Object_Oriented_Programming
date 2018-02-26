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
* The Stock.java file fulfills the following requirements:
* 
* 	1. A Symbol enum field named symbol for the stock’s symbol
* 
* 	2. A double data field name previousClosingPrice that stores the stock price for the previous day
* 	
* 	3. A double data field named currentPrice that stores the stock price for the current time
* 	
* 	4. A constructor that creates a stock with specified symbol and name
* 	
* 	5. The accessor functions for all data fields
* 	
* 	6. The mutator functions for previousClosingPrice and currentPrice
* 	
* 	7. A function named getChangePercent() that returns the percentage changed from previousClosingPrice 
* 	to currentPrice
* 	
* 	8. The Enum “Symbol” – will be used to denote stock for companies
* 		a. Declare the stock symbols for the following: Microsoft, Apple, Google, Amazon, AT&T
* 		b. The symbol should have a string value which is the company name
* 		c. Example Symbol.MSFT represents Microsoft stock.
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

/*
 * The Stock object contains a symbol enumerated with its name, a previous and current price.
 */
public class Stock {
	
	//Instance Variable(s)
	Symbol symbol;
	double previousClosingPrice;
	double currentPrice;
	
	//Enumeration(s)
	public enum Symbol {
		MSFT("Microsoft"),
		AAPL("Apple"),
		GOOG("Google"),
		AMZN("Amazon"),
		ATT("AT&T");
		
		//Company name of each symbol
		private String name;
		
		//Constructor
		private Symbol(String name){
			this.name = name;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return this.name;
		}
	}
	
	//Constructor(s)
	public Stock(Symbol inSymbol) {
		this.symbol = inSymbol;
	}
	
	//Getters and setters
	
	/**
	 * @return the symbol
	 */
	public Symbol getSymbol() {
		return symbol;
	}

	/**
	 * @return the previousClosingPrice
	 */
	public double getPreviousClosingPrice() {
		return previousClosingPrice;
	}

	/**
	 * @return the currentPrice
	 */
	public double getCurrentPrice() {
		return currentPrice;
	}

	/**
	 * @param previousClosingPrice the previousClosingPrice to set
	 */
	public void setPreviousClosingPrice(double previousClosingPrice) {
		this.previousClosingPrice = previousClosingPrice;
	}

	/**
	 * @param currentPrice the currentPrice to set
	 */
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	/*
	 * @return  the percentage changed from previousClosingPrice to currentPrice
	 */
	double getChangePercent() {
		return ((this.getCurrentPrice() - this.getPreviousClosingPrice()) / this.getPreviousClosingPrice()) * 100;
	}
}
