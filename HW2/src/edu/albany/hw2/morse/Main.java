package edu.albany.hw2.morse;

//imported libraries
import java.util.Scanner;

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
* The Main.java file fulfills the following requirements:
* 
* This program can ask the user to enter a string and then converts that string into Morse code. It can also accept
* a command line argument of said string. It uses hyphens for dashes and periods for dots.
* 
* Slashes were added between words for legibility and an error check for unknown characters was done.
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
public class Main {

	/*
	 * This main method can accept one arguments, a string to be converted to morse-code, that is 
	 * surrounded by quotes. Also possible is single characters, numbers punctuation an spacing.
	 */
	public static void main(String[] args) {
		
		//Instance variable(s)
		int argCount;
		String input;
				
		//Assign argCount to the length of args
		argCount = args.length;
		
		//If there were arguments supplied
		if(argCount != 0) {
			
			//One argument supplied
			if (argCount == 1) {
				
				//Print text and then call stringToMorseCode
				System.out.println("\nMorse code generation: ");
				
				//Check if the function stringToMorseCode returns null, then print
				if(MorseCode.stringToMorseCode(args[0]).equals(null)) {
					System.out.println("Unkown token encountered.");
				} else {
					System.out.println(MorseCode.stringToMorseCode(args[0]));
				}
				
				
			} else { //More than one arguments supplied
				System.out.println("Too many arguments supplied. \nWas the text to be converted to morse code surrounded by quotes?");
			}

		} else {
			
			//Print prompt
			System.out.println("Please enter a string to convert into morse code: ");
		
			//Create a scanner that takes user input
			@SuppressWarnings("resource") //Suppressed because stdin. should never be closed
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();
			
			//Print text and then call stringToMorseCode
			System.out.println("\nMorse code generation: ");
			
			//Check if the function stringToMorseCode returns null, then print
			if(MorseCode.stringToMorseCode(input) == null) {
				System.out.println("ERROR: Unkown token encountered.");
			} else {
				System.out.println(MorseCode.stringToMorseCode(input));
			}
		}

	}

}
