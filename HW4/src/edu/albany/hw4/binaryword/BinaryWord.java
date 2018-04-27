package edu.albany.hw4.binaryword;

import java.util.BitSet;

import edu.albany.hw4.Complementable;

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
* 	There is one constructor that accepts a String of binary values, zeros and ones.
* 
* 	The complement operation yields a bitwise inversion of the current word.
* 
* 	A toString and equals method have also been implemented, for comparing to other BinaryWords and 
* 	printing BinaryWords.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class BinaryWord implements Complementable<BitSet>{
	
	//Instance variable(s)
	private BitSet word;
	
	public BinaryWord() {}
	
	//This constructor accepts a String as a parameter and loops through the 
	//	length of the string assigning binary values when found to the instance 
	//	variable word.
	public BinaryWord(String newWord) {
		
		//Create a length integer and new BitSet with the supplied 
		//	String's length
		int length = newWord.length();
		word = new BitSet(length);
		
		//Loop through the String setting values of the instance var word
		for(int x = 0; x < length; x++) {
			if(newWord.charAt(x) == '1') {
				word.set(x, true);
			} else if (newWord.charAt(x) == '0') {
				word.set(x, false);
			} else {
				this.setWord(null);
			}
		}
		
		//Assign the newly created BitSet to the current objects word
		this.setWord(word);
	}
	
	/*
	 * This method overrides the required method in the interface complementable.
	 *	 It returns the bitwise complement of the current objects BitSet using a StringBuilder.
	 */
	@Override
	public BinaryWord complement() {
			
		//Create an Integer length and a new StringBuilder
		int length = this.getWord().length();
        StringBuilder newWord = new StringBuilder();

		//Loop through the current BitSet, adding OPPOSITE values to the new StringBuilder
		for(int x = 0; x < length; x ++) {
			if(this.getWord().get(x) == true) {
				newWord.append('0');
			} else if(this.getWord().get(x) == false) { 
				newWord.append('1'); 
			} else {
				return null;
			}
		}

		//Pass the created string to a BinaryWord constructor and return
		BinaryWord complementable = new BinaryWord(newWord.toString());
		return complementable;		
	}


	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * This toString method returns the BinaryWord's String representation by looping through the indexes of the BitSet,
	 * appending 0 or 1 depending to a new StringBuilder object.
	 */
	@Override
	public String toString() {
		
		//Create an Integer length and a new arraylist of chars w/ that length
		int length = this.getWord().length();
        StringBuilder newWord = new StringBuilder();

		
		//Loop through the current BitSet, adding the values to the new StringBuilder
		for(int x = 0; x < length; x ++) {
			if(this.getWord().get(x) == true) {
				newWord.append('1');
			} else if(this.getWord().get(x) == false) { 
				newWord.append('0'); 
			} else {
				return null;
			}
		}
		
		return newWord.toString();
		
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
		if (this == word) return true;
		if (word == null) return false;
		
		//Classes
		if (getClass() != word.getClass()) return false;
		
		//Casting and using BitSet's equals method
		BinaryWord other = (BinaryWord) word;
		if(this.getWord().equals(other.getWord())) {
			return true;
		} else {
			return false;
		}
	}
	
	//Getters and setters below
	
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
}
