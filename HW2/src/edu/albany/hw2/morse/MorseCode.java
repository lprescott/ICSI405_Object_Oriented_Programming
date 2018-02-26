package edu.albany.hw2.morse;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: Feb 25th, 2018
*
* Project Name: HW2
* Package Name: edu.albany.hw2.morse
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* The MorseCode.java file has one enumeration and two functions; they are as follows:
* 
* 1. enum Morse - This enumerations defines every possible character, digit, etc. that may need to be 
* 	converted and its respective morse-coded equivalent. It also defines the necessary constructors and 
* 	accessors. 
* 
* 2. stringToMorseCode - This function returns a StringBuffer which contains the morse-coded 
* 	equivalent of the string provided by calling letterToMorseCode.
* 
* 3. letterToMorseCode - This function returns a string and accepts one letter that is to be translated 
* 	to morse code by referencing the previously stated Morse enum.
* 
* * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* ******* EXPLAIN: What strategy you used to store the morse code encoding table and WHY? *******
*
*	I used an enumeration, as it can quickly and easily defines a complete listing of items in any 
* 	collection. Besides speed to create and readability, enumerations also other distinct advantages
*  	over if, else if and else statements including type safety. Also, I used an enumeration because 
*  	I wanted to familiarize myself with this very powerful tool in the java language.
*
* ********************************************************************************************* *
* 
*/
public class MorseCode {
	
	//Morse enumeration containing possible morse-code translations
	public enum Morse {
		
		//Punctuation
		//Space has been replaced with a "/ character for comprehension
	    SPACE(' ', "/"), 
	    COMMA(',', "--..--"),
	    PERIOD('.', ".-.-.-"),
	    QUESTIONMARK('?', "..--.."),
	    
	    //Digits
		ZERO('0', "-----"),
	    ONE('1', ".----"),
	    TWO('2', "..---"),
	    THREE('3', "...--"),
	    FOUR('4', "....-"),
	    FIVE('5', "....."),
	    SIX('6', "-...."),
	    SEVEN('7', "--..."),
	    EIGHT('8', "---.."),
	    NINE('9', "----."),

	    //Characters
		A(".-"),
	    B("-..."),
	    C("-.-."),
	    D("-.."),
	    E("."),
	    F("..-."),
	    G("--."),
	    H("...."),
	    I(".."),
	    J(".---"),
	    K("-.-"),
	    L(".-.."),
	    M("--"),
	    N("-."),
	    O("---"),
	    P(".--."),
	    Q("--.-"),
	    R(".-."),
	    S("..."),
	    T("-"),
	    U("..-"),
	    V("...-"),
	    W(".--"),
	    X("-..-"),
	    Y("-.--"),
	    Z("--..");
		
		//Instance variable(s)
	    private char ch;
	    private String morsecode;

	    //Constructor(s)
	    private Morse(char ch, String morsecode) {
	        this.ch = ch;
	        this.morsecode = morsecode;
	    }

	    private Morse(String morsecode) {
	        this.ch = this.name().charAt(0);
	        this.morsecode = morsecode;
	    }
	    
		/**
		 * @return the character
		 */
		public char getChar() {
			return ch;
		}

		/**
		 * @return the code
		 */
		public String getCode() {
			return morsecode;
		}

	}
	
	/*
	 * This function returns a StringBuffer which contains the morse-coded 
	 * equivalent of the string provided by calling letterToMorseCode.
	 */
	public static StringBuffer stringToMorseCode(String inString) {
		//Convert the supplied string called inString into a char array and 
		//loop through each index of the char array with a character ch
		
		//Create a new StringBuffer that will store the entirety of the morse coded String
		StringBuffer stringBuffer = new StringBuffer();
		
		for (char ch : inString.toCharArray()){
			
			if( ch == '\n') {
				//System.out.println();
				stringBuffer.append("\n");
				break;
			}
			
			//Check if letterToMorseCode returns null, then return null if so
			else if(letterToMorseCode(ch) == null) {
				return null;
			}
			
			//Else print the returned string from a called letterToMorse
			//System.out.print(letterToMorseCode(ch) + " ");
			stringBuffer.append(letterToMorseCode(ch) + " ");
		}
		
		//return the StringBuffer
		return stringBuffer;
	}
	
	/*
	 * This function returns a string and accepts one letter that is to be translated 
	 * to morse code by referencing the previously stated Morse enum.
	 */
	private static String letterToMorseCode(char letter) {
		//Convert the enumeration Morse to an array using values() and
		//loop through each index of the array using a Morse enum called searcher
		for(Morse searcher: Morse.values()) {
			//If the capitalized letter comparison is valid return the respective morse code
			if(searcher.getChar() == Character.toUpperCase(letter)) {
                return searcher.getCode();
            }
		}
		
		//Else return null
		return null;
	
	}
	
}