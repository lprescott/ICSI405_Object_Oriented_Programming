package edu.albany.hw4;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: April 25th, 2018
*
* Project Name: HW4
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* Binary.java implements the Complementable interface with BitSet as its underlying storage container. 
* 	
* 	There are two constructors, one that accepts a String that it will create a BitSet with the supplied 
* 	values, and another that accepts a Integer which calls the previously mentioned constructor with 
* 	a string representation of the Integer supplied.
* 
* 	The complement operation yields a bitwise inversion of the word.
* 
* 	A toString and equals method have also been implemented, the equals method accepts any wordect
* 	and the toString method calls BitSet's toString.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class BinaryWord implements Complementable<BitSet>{
	
	//Instance variable(s)
	private BitSet word;

	/**
	 * @return the word
	 */
	public BitSet getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(BitSet word) {
		this.word = word;
	}
	
	//This constructor converts the supplied Integer to a String and calls
	//	the constructor that accepts Strings.
	public BinaryWord(Integer newWord) {
		this(Integer.toString(newWord));
	}
	
	//This constructor accepts a String as a parameter and loops through the 
	//	length of the string assigning binary values when found to the instance 
	//	variable word.
	public BinaryWord(String newWord) {
		
		//Create a length integer and new BitSet with the supplied 
		//	String's length
		int length = newWord.length();
		word = new BitSet(length);
		
		//Loop through the String setting values of the intance var word
		for(int x = 0; x < length; x++) {
			if(newWord.charAt(x) == '1') {
				word.set(x, 1);
			} else if (newWord.charAt(x) == '0') {
				word.set(x, 0);
			} else { //If a non-binary val is detected, throw an exception
				throw new IllegalArgumentException("Non-binary values detected.");
			}
		}
	}
	
	//This method @overrides the complementables defined complement method.
	//	It yields a bitwise conversion of the word by looping through the current BitSet
	//	and adding opposite values to a new Complementable<BitSet> using a constructor.
	@Override
	public BinaryWord complement() {
		//Create an Integer length and a new arraylist of chars w/ that length
		int length = this.getWord().length();
		List<Character> newWord = new ArrayList<Character>();
		
		//Loop through the current BitSet, adding OPPOSITE values to the new arraylist
		for(int x = 0; x < length; x ++) {
			if(this.getWord().get(x) == true) {
				newWord.add('0');
			} else if(this.getWord().get(x) == false) { 
				newWord.add('1'); 
			} else new IllegalArgumentException("Non-binary values detected.");
		}     //If a non-binary val is detected, throw an exception
		
		//Pass the created string to a BinaryWord constructor and return
		BinaryWord complementable = new BinaryWord(newWord.toString());
		return complementable;
	}


	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * This toString method returns the BinaryWord's String representation by calling BitSet's toString
	 */
	@Override
	public String toString() {
		return word.toString();
	}

	/*
	 * (non-Javadoc
	 * 0
	 * @see java.lang.Object#equals(java.lang.Object)
	 *
	 * This equals method attempts to compare the passed wordect with the current BitSet by comparing references,
	 * 	then classes, then casting and comparing using BitSet's equals method.
	 */
	@Override
	public boolean equals(Object word) {
		//References
		if (this == word)
			return true;
		if (word == null)
			return false;
		//Classes
		if (getClass() != word.getClass())
			return false;
		//Casting and using BitSet's equals method
		BinaryWord other = (BinaryWord) word;
		if(!this.getWord().equals(other)) {
			return false;
		}
		return true;
	}
}
