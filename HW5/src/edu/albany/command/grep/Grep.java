package edu.albany.command.grep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.albany.command.Command;

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
* @file Grep.java is the non-parrallel implementation of grep
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
public class Grep extends Command{
	
	private static Grep instance;
	
	/**
	 * This main method can accept one arguments, a string to be searched for, that is optionally
	 * surrounded by quotes. Any regular expressions are acceptable.
	 * 
	 * @param args the searchable regular expression
	 */
	public static void main(String[] args) {

		//Instance variable(s)
		int argCount;
				
		//Assign argCount to the length of args
		argCount = args.length;
				
		//If there were 3 arguments supplied
		if(argCount == 3) {
			System.out.println("grep " + args[0] + " \'" + args[1] + "\' " + args[2]);
			
			/*
			 * $ grep -n "unix" geekfile.txt
			 * 	Output:
			 * 1:unix is great os. unix is opensource. unix is free os.
			 * 4:uNix is easy to learn.unix is a multiuser os.Learn unix .unix is a powerful. 
			 * 
			 */	

			//Checking for valid commands
			if ((isValidOption(args[0]) && (isValidPattern(args[1]) && (isValidFile(args[2]))))) {
				
				//Create a new command instance and call execute with valid args
				instance = new Grep();
				
				final long startTime = System.currentTimeMillis();
				instance.execute(args);
				final long endTime = System.currentTimeMillis();

				System.out.println("Total execution time: " + (endTime - startTime) );
				
			} else if (!isValidOption(args[0])){
				
				System.out.println("in-valid option");
			} else if (!isValidPattern(args[1])){
				
				System.out.println("in-valid pattern");
			} else if (!isValidFile(args[2])){
				
				System.out.println("in-valid file");
			}
		
			
		} else {
			System.out.println("This program expects three command line arguments.");
		}
		
		
	}

	@Override
	public void execute(String [] args) {
		
		String pattern; //pattern is the regular expression to search for
		String file; //file is the absolute path, or local path of a file to search in
		
		//Assign to args
		pattern = args[1];
		file = args[2];
		
		int count = 0;		
		File fp = new File(file);
		
		try {
			Scanner sc = new Scanner(fp);
			
			while(sc.hasNextLine()) {
				final String tempLine = sc.nextLine();
				count++;
				
				if(tempLine.contains(pattern)) {
					System.out.println(count + ":" + tempLine);
				}
			}
			sc.close();
			
		} catch (FileNotFoundException e) {

			System.out.println("in-valid file");
		}
	}
}
