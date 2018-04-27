package edu.albany.hw4.driver;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;

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
		System.out.println("----------------BinaryWord Testing: ----------------");
		
		//Creation
		BinaryWord test1 = new BinaryWord("01101000011001010110110001101100011");
		BinaryWord test2 = new BinaryWord("01101000011001010110110001101100011");

		//toString of BinaryWords and complements
		System.out.printf("\n%-15s%-22s\n","test1:", test1);
		System.out.printf("%-15s%-22s\n","complement:", test1.complement());
		System.out.printf("\n%-15s%-22s\n","test2:", test2);
		System.out.printf("%-15s%-22s\n","complement:", test2.complement());
		
		//Testing equality and complements
		System.out.println("\ntest1.equals(test2)?");
		System.out.println(test1.equals(test2));
		System.out.println("\ntest1.equals(test2.complement())?");
		System.out.println(test1.equals(test2.complement()));
		System.out.println("\ntest1.complement().equals(test2.complement())?");
		System.out.println(test1.complement().equals(test2.complement()));
		
		
		//PositiveInteger Tests
		System.out.println("\n----------------PositiveInteger Testing: ----------------\n");

		//Variables used for testing
		int sum = 0;
		PositiveInteger operateSum = new PositiveInteger(0);
		PositiveInteger[] posInts = new PositiveInteger[10];
		Random rand = new Random();
		
		//Create a collection of PositiveIntegers
		Collection<PositiveInteger> collection =  new ArrayList<PositiveInteger>();
		
		//Loop ten times, creating positiveinteger objects randomly for testing
		for(int i = 0; i < 10; i++) {
			PositiveInteger temp  = new PositiveInteger(rand.nextInt(250) + 1);
			posInts[i] = temp;
			System.out.println("\"PositiveInteger\" created: " + posInts[i]);
			sum += posInts[i].getValue();
			operateSum.setValue(operateSum.operate(posInts[i]).getValue());
			collection.add(temp);
		}
		
		//Printing of sums, calculated by normal addition, the operate and combine functions
		int combineSum = PositiveInteger.combine(collection).getValue();
		PositiveInteger combinePositiveInteger = PositiveInteger.combine(collection);
		System.out.printf("\n%-25s%-30s\n","Sum using classical means: ", sum);
		System.out.printf("%-25s%-30s\n","Sum using operate function: ", operateSum);
		System.out.printf("%-25s%-30s\n","Sum using combine function: ", combineSum);
		System.out.print("Equal? "); System.out.print(operateSum.equals(new PositiveInteger(sum)) 
				&& operateSum.equals(combinePositiveInteger));
				
		//RGBColor Tests
		System.out.println("\n\n----------------RGBColor Testing: ----------------\n");

		//Create a collection of RGBColors
		Collection<RGBColor> collection2 =  new ArrayList<RGBColor>();

		//Create print and add RGBObjects
		RGBColor testColor1 = new RGBColor(215, 210, 0);
		RGBColor testColor2 = new RGBColor(0, 252, 251);
		RGBColor testColor3 = new RGBColor(0, 252, 251);
		System.out.printf("%-15s%-30s\n","testColor1: ", testColor1);
		System.out.printf("%-15s%-30s\n","testColor2: ", testColor2);
		System.out.printf("%-15s%-30s\n","testColor3: ", testColor3);
		System.out.print("\ntestColor1.equals(testColor2)? "); System.out.print(testColor1.equals(testColor2));
		System.out.print("\ntestColor2.equals(testColor3)? "); System.out.print(testColor2.equals(testColor3));
		collection2.add(testColor1);
		collection2.add(testColor2);
		collection2.add(testColor3);

		//Print complements
		System.out.println("\n\nComplement of testColor1: "); System.out.print(testColor1.complement());
		System.out.println("\nOperate on testColor1 and 2: "); System.out.print(testColor1.operate(testColor2));
		System.out.println("\nCombine on collection of testColor1, 2, and 3: "); System.out.print(RGBColor.combine(collection2));
	}
}
