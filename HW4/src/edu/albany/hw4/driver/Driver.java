package edu.albany.hw4.driver;

import java.util.Random;

import edu.albany.hw4.binaryword.BinaryWord;
import edu.albany.hw4.semigroup.PositiveInteger;
import edu.albany.hw4.semigroup.RGBColor;

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
		
		//BinaryWord Tests
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
		
		
		//PositiveInteger Tests
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
		
		//RGBColor Tests
		System.out.printf("\n\n%35s", "RGBColor Testing\n\n");

		RGBColor testColor1 = new RGBColor(215, 210, 0);
		RGBColor testColor2 = new RGBColor(0, 252, 251);
		System.out.printf("%-15s%-30s\n","testColor1: ", testColor1);
		System.out.printf("%-15s%-30s\n","testColor2: ", testColor2);
		System.out.print("Equals? "); System.out.print(testColor1.equals(testColor2));

		System.out.println("\n\nComplement of testColor1? "); System.out.print(testColor1.complement());
		System.out.println("\nOperate on testColor1 and 2? "); System.out.print(testColor1.operate(testColor2));

		//Other Required Unit Tests
	}

}
