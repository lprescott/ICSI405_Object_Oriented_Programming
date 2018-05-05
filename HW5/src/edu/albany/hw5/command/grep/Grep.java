package edu.albany.hw5.command.grep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.albany.hw5.command.Command;

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
* @file Grep.java is the non-parallel implementation of grep
* 
*  
* It takes commands in the form:
* 					grep -option pattern filePath
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
public class Grep extends Command{
	
	private static Grep instance;
	
	private String option; //the accepted option, -n for now
	private String pattern; //pattern is the regular expression to search for
	private String file; //file is the absolute path, or local path of a file to search in
	
	/**
	 * This main method can accept one arguments, a string to be searched for, that is optionally
	 * surrounded by quotes. Any regular expressions are acceptable.
	 * 
	 * @param args the searchable regular expression
	 */
	public static void main(String[] args) {
		
		//Check start time
		final long start = System.nanoTime();

		//Instance variable(s)
		int argCount;
				
		//Assign argCount to the length of args
		argCount = args.length;
				
		//If there were 3 arguments supplied
		if(argCount == 3) {
			System.out.println("grep " + args[0] + " \'" + args[1] + "\' " + args[2]);

			//Checking for valid commands
			if ((isValidOption(args[0]) && (isValidPattern(args[1]) && (isValidFile(args[2]))))) {
				
				//Create a new command instance and call execute with valid args
				instance = new Grep();
				instance.setOption(args[0]);
				instance.setPattern(args[1]);
				instance.setFile(args[2]);
				
				instance.execute();
				
			  //Print correct error output
			} else if (!isValidOption(args[0])){
				
				System.out.println("in-valid option");
			} else if (!isValidPattern(args[1])){
				
				System.out.println("in-valid pattern");
			} else if (!isValidFile(args[2])){
				
				System.out.println("in-valid file");
			}
		
		  //Print expectation of args
		} else {
			System.out.println("This program expects three command line arguments.");
		}
		
		//Print timing
		//Print timing
		System.out.println(String.format("timing%10sms", (System.nanoTime() - start)/1000000)); 
		
	}

	/**
	 * This function uses the pattern, and file arguments to implement grep in java.
	 * 	This function is not parallel.
	 */
	public void execute() {
		
		//Set count and open file
		int count = 0;		
		File fp = new File(this.getFile());
		
		try {
			
			//Scan every line, incrementing count and using contains to search for pattern
			Scanner sc = new Scanner(fp);
			
			while(sc.hasNextLine()) {
				final String tempLine = sc.nextLine();
				count++;
				
				//Print the lines of found patterns
				if(tempLine.contains(this.getPattern())) {
					System.out.println(count + ":" + tempLine);
				}
			}
			sc.close();
			
		} catch (FileNotFoundException e) {

			//Print in-valid file error
			System.out.println("in-valid file");
		}
	}
	
	/**
	 * @return the option
	 */
	public String getOption() {
		return option;
	}


	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}


	/**
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}


	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}


	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}


	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}
}
