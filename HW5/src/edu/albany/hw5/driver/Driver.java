package edu.albany.hw5.driver;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import edu.albany.hw5.command.Command;
import edu.albany.hw5.command.grep.Grep;
import edu.albany.hw5.command.grep.ParallelGrep;


/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: May 2nd, 2018
*
* Project Name: HW5
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* @file Driver.java accepts command lines arguments the same as grep or parallelgrep, but runs both as to more easily
*					compare the two.
* 
*  
* It takes commands in the form:
* 					driver -option pattern filePath
* 
*					-option ~ only -n is accepted thus far, prints the lines that a given pattern have appeared in.
*
*					pattern ~ any regular expression is accepted, to be searched for
*
*					filePath ~ can be the local path or an absolute path value
*

* The Unix grep program finds lines that match a regular expression. This is a java version of grep.
* 
* 
*~~~~~~~~~~~~~~INFO~~~~~~~~~~~~~~~
*
* 
* The Unix grep program finds lines that match a regular expression. This is a java version of grep.
* 
* This project fulfills the following requirements:
* 
* 	Make this implementation run faster by running it in a multithreaded way. Split each input file 
* into two equal sized regions, and look for instances of the regular expression in each region, in a separate thread. 
* The second thread should not output any lines until the first thread is done; instead, it should simply 
* record the matching lines internally, so that it can operate in parallel with the first thread, and wait until 
* the first thread is done before outputting anything based on its records. If an input line straddles the 
* boundary between the two regions, or begins at the very start of the second region, the first thread (and 
* not the second thread) should output the line. 
* 
* 	Measure the performance of the original Java grep (non-parallel), 
* compared to your modified (parallel) version, and compare both to GNU grep. 
* 
* 	You may add timings directly in your java code in your main method 
* (beginning and at end of scope)
* 
* 	Make sure your JAVA versions expect command line args in same format as the grep command does. 
* For now, only the above type of args need to be handled.
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*
*/
public class Driver {

	/**
	 * This main method can accept three arguments, option, pattern then file/
	 * 
	 * @param args -option pattern file
	 */
	public static void main(String[] args) {

		//Instance variable(s)
		int argCount;
				
		//Assign argCount to the length of args
		argCount = args.length;
				
		//If there were 3 arguments supplied
		if(argCount == 3) {
			//System.out.println("grep " + args[0] + " \'" + args[1] + "\' " + args[2]);

			//Checking for valid commands
			if ((Command.isValidOption(args[0]) && (Command.isValidPattern(args[1]) && (Command.isValidFile(args[2]))))) {
				
				//Change output stream as to stop Grep and ParallelGrep from printing to stdout
			    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
			    PrintStream printstream = new PrintStream(outstream);
			    PrintStream oldstream = System.out;
			    System.setOut(printstream);
			    
			    //Time both grep and parallelgrep individually
				final long grepStart = System.nanoTime();
				Grep.main(args);
				long grepTime =  (System.nanoTime() - grepStart)/1000000;
				
				final long parallelStart = System.nanoTime();
				ParallelGrep.main(args);
				long parallelTime =  (System.nanoTime() - parallelStart)/1000000;

				//Return to old out stream
			    System.out.flush();
			    System.setOut(oldstream);

			    //Print timings, difference and notes
			    System.out.println("For grep output, call Grep or ParallelGrep directly -- this class is for timing purposes.\n"
			    		+ "Note that this class still takes output as Grep and ParallelGrep do.\n");
			    
			    System.out.printf("%-30.30s  %-30s%n", "Grep timing", grepTime + "ms");
			    System.out.printf("%-30.30s  %-30s%n", "ParallelGrep timing", parallelTime + "ms");

			    System.out.printf("\n%-30.30s  %-30s%n", "difference", grepTime-parallelTime + "ms");

			  //Print correct error output
			} else if (!Command.isValidOption(args[0])){
				
				System.out.println("in-valid option");
			} else if (!Command.isValidPattern(args[1])){
				
				System.out.println("in-valid pattern");
			} else if (!Command.isValidFile(args[2])){
				
				System.out.println("in-valid file");
			}
		
		  //Print expectation of args
		} else {
			System.out.println("This program expects three command line arguments.");
		}
	}
}
