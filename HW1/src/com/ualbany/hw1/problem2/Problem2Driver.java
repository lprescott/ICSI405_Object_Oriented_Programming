package com.ualbany.hw1.problem2;

//Imported libraries:
import java.util.Scanner;

/**
 * @author Luke R. Prescott
 * Student ID: 001252879
 * 
 * Start Date: Feb 11, 2018
 *
 * Project Name: HW1
 * Package Name: com.ualbany.hw1.problem2
 * 
 * This class is the driver class to test the file HW1Problem2 and its methods for accuracy.
 * It also provides a simple command line driven interface between the user and below methods by
 * accepting integers 0-4:
 * 
 * 	0. Stop.
 *  1. multiple - determines whether or not a supplied numerator and denominator divide evenly
 *  2. remainder - determines the remainder of a supplied numerator and 7
 *  3. distance - determines the distance of two supplied x, y points
 *  4. tenFlipsOfACoin - prints the result of a coin flip 10 times using java.util.Random; 
 */
public class Problem2Driver extends HW1Problem2{

	/**
	 * @param args none accepted
	 */
	public static void main(String[] args) {
		
		//Create a scanner that stores the users input
		Scanner scanner = new Scanner(System.in);
		int userInput;
		
		//Print explanation of interface
		System.out.println("Which function would you like to call?\n"
				+ "\t0. End the program.\n"
				+ "\t1. multiple - determines whether or not a supplied numerator and denominator divide evenly\n"
				+ "\t2. remainder - determines the remainder of a supplied numerator and 7\n"
				+ "\t3. distance - determines the distance of two supplied x, y points\n"
				+ "\t4. tenFlipsOfACoin - prints the result of a coin flip 10 times using java.util.Random; \n"
				+ "Please enter a # from 0-4:");

		//Loop that continues until 0 is entered
		while(true) {
			
			//Accept user input
			userInput = scanner.nextInt();
			
			//End the program.
			if (userInput == 0) {
				 System.out.println("Stopping...");
				 break;
				 
			}
			//multiple
			else if (userInput == 1) {
				
				//New scanner and variables for function arguments
				@SuppressWarnings("resource") //Suppressed because you don't want to close System.in
				Scanner scan1 = new Scanner(System.in);
				int first, second;
				
				//Accept user input
				System.out.println("Please enter the numerator (int): ");
				first = scan1.nextInt();
				System.out.println("Please enter the denominator (int): ");
				second = scan1.nextInt();
				
				//Print answer to cmdline
				if (multiple(first, second) == true) {
					System.out.println("That divides evenly. |" + first + " % " + second + "| = " + first%second + ".\n");
				} else {
					System.out.println("That doesn't divide evenly. |" + first + " % " + second + "| = " + first%second  + ".\n");
				}
				
			}
			//remainder
			else if (userInput == 2) {

				//New scanner and variables for function arguments
				@SuppressWarnings("resource") //Suppressed because you don't want to close System.in
				Scanner scan2 = new Scanner(System.in);
				int numerator;
				
				//Accept user input
				System.out.println("\nPlease enter the numerator (int): ");
				numerator = scan2.nextInt();
				
				//Print answer to cmdline
				if (remainder(numerator)==0) {
					System.out.println("That divides evenly. |" + numerator + " % 7| = " + remainder(numerator) + ".\n");
				} else {
					System.out.println("That doesn't divide evenly. |" + numerator + " % 7| = " + remainder(numerator) + ".\n");
				}
				
			} 
			//distance
			else if (userInput == 3) {

				//New scanner and variables for function arguments
				@SuppressWarnings("resource") //Suppressed because you don't want to close System.in
				Scanner scan3 = new Scanner(System.in);
				double x1, y1, x2, y2;
				
				//Accept user input
				System.out.println("Please enter x1 (double): ");
				x1 = scan3.nextDouble();
				System.out.println("Please enter y1 (double): ");
				y1 = scan3.nextDouble();
				
				System.out.println("Please enter x2 (double): ");
				x2 = scan3.nextDouble();
				System.out.println("Please enter y2 (double): ");
				y2 = scan3.nextDouble();
				
				//Print answer to cmdline
				System.out.println("The distance between a p1(" + x1 + "," + y1 + ") and a p2(" + x2 + "," + y2 + ") is: " + distance(x1, y1, x2, y2) + ".\n");
				
			} 
			//tenFlipsOfACoin
			else if (userInput == 4) {
				tenFlipsOfACoin();
				
			} else {
				System.out.println("ERROR: User input not from 0-4.");
				
			}
			
			//Print out prompt
			System.out.println("Please enter a # from 0-4 (0 to stop):");

		}
		
		//Close the scanner and end
		scanner.close();	
		System.out.println("Stopped.");
	}
}
