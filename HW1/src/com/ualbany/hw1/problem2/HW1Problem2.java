package com.ualbany.hw1.problem2;

//Imported libraries:
import java.util.Random;

/**
 * @author Luke R. Prescott
 * Student ID: 001252879
 * 
 * Start Date: Feb 11, 2018
 *
 * Project Name: HW1
 * Package Name: com.ualbany.hw1.problem2
 * 
 * This class only contains methods for use in Problem2Driver.java.
 * 
 *  multiple - determines whether or not a supplied numerator and denominator divide evenly
 *  remainder - determines the remainder of a supplied numerator and 7
 *  distance - determines the distance of two supplied x, y points
 *  tenFlipsOfACoin - prints the result of a coin flip 10 times using java.util.Random; 
 */
public class HW1Problem2 {
	
	/**
	 * multiple returns true if the supplied first integer is divisible 
	 * 	evenly by the supplied second one 
	 * 
	 * @param first the numerator
	 * @param second the denominator
	 * @return a boolean value if first%second == 0
	 */
	public static boolean multiple(int first, int second) {
		if(first % second == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * remainder returns the remainder of a supplied integer divided by 7
	 * 
	 * @param numerator an integer
	 * @return the remainder of the supplied value divided by 7
	 */
	public static int remainder(int numerator) {
		return numerator % 7;
	}
	
	/**
	 * distance returns the distance of two supplied points
	 * 
	 * https://en.wikipedia.org/wiki/Distance
	 * 
	 * @param x1 the x-coordinate of the first point
	 * @param y1 the y-coordinate of the first point
	 * @param x2 the x-coordinate of the second point
	 * @param y2 the y-coordinate of the second point
	 * @return the calculated distance between the supplied two points
	 */
	public static double distance(double x1, double y1, double x2, double y2) {
	
		return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));	
	}
	
	/**
	 * tenFlipsOfACoin prints to standard output 10 times:
	 * 	"Heads" or "Tails"
	 */
	public static void tenFlipsOfACoin() {
		
		int headCount = 0, tailCount = 0;
		
		//Create a new instance of the Random object
		Random random = new Random();
		
		System.out.println(); //Print a line for better formatting

		//For loop 10-times
		for(int i = 0; i < 10; i++) {
			if (random.nextBoolean()) {
				System.out.println((i+1) + ": Heads");
				headCount++;
			} else {
				System.out.println((i+1) + ": Tails");
				tailCount++;
			}
		}
		//Print total of each count
		System.out.println("\nHeads: " + headCount + "; Tails: " + tailCount + ".\n");
	}
	
}
