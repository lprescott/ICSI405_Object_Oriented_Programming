package edu.albany.hw4.driver;

import java.util.Random;

import edu.albany.hw4.binaryword.BinaryWord;
import edu.albany.hw4.semigroup.PositiveInteger;

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
* Driver.java attempts to demonstrate the functionality of hw4's concrete classes and the additional 
* static methods with a suite of appropriate unit tests that show the generic static methods 
* working for both types of semigroups.
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class Driver {

	public static void main(String[] args) {
		
		//BinaryWord Unit Tests
		System.out.printf("%35s", "BinaryWord Testing\n");
		
		BinaryWord test1 = new BinaryWord("01101000011001010110110001101100011");
		BinaryWord test2 = new BinaryWord("01101000011001010110110001101100011");

		System.out.printf("\n%-15s%-22s\n","test1:", test1);
		System.out.printf("%-15s%-22s\n","complement:", test1.complement());
		
		System.out.printf("\n%-15s%-22s\n","test2:", test2);
		System.out.printf("%-15s%-22s\n","complement:", test2.complement());
		
		System.out.println("\ntest1.equals(test2)?");
		System.out.println(test1.equals(test2));
		
		System.out.println("\ntest1.equals(test2.complement())?");
		System.out.println(test1.equals(test2.complement()));
		
		System.out.println("\ntest1.complement().equals(test2.complement())?");
		System.out.println(test1.complement().equals(test2.complement()));
		
		
		//PositiveInteger Unit Tests
		System.out.printf("%35s", "PositiveInteger Testing\n\n");

		int sum = 0;
		PositiveInteger operateSum = new PositiveInteger(0);
		PositiveInteger[] posInts = new PositiveInteger[10];
		Random rand = new Random();
		for(int i = 0; i < 10; i++) {
			posInts[i] = new PositiveInteger(rand.nextInt(250) + 1);
			System.out.println("New \"PositiveInteger\" obj. created: " + posInts[i]);
			sum += posInts[i].getValue();
			operateSum.setValue(operateSum.operate(posInts[i].getValue()));
		}
		System.out.printf("\n%-25s%-30s\n","Sum using classical means: ", sum);
		System.out.printf("%-25s%-30s\n","Sum using operate function: ", operateSum);
		System.out.print("Equals? "); System.out.print(operateSum.equals(new PositiveInteger(sum)));
		
		
		//RGBColor Unit Tests
		
		
		//Other Required Unit Tests
	}

}
