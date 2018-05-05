package edu.albany.hw5.command;

import java.io.File;
import java.util.regex.Pattern;

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
* @file Command.java is the abstract implementation of a command object.
* 
*  
* It has a self-referenced instance of itself, therefore a singleton.
* 
* 		There are three method that are used for parameter-checking.
* 
* 		1. isValidFile ~ checks if a supplied file path exists, is not a directory and is readable.
* 
* 		2. isValidPattern ~ uses the Pattern object to check if the supplied String is a valid
* 							regular expression.
* 
* 		3. isValidOption ~ checks the supplied string to see if the supplied option is valid,
* 							as of now -- it only accepts "-n"
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
public abstract class Command {
	
	private static Command instance;

	/**
	 * checks if a supplied file path exists, is not a directory and is readable.
	 * 
	 * @param arg the string supplied to check
	 * @return true if valid
	 */
	public static boolean isValidFile(String arg){
		
		File fp = new File(arg);
		
		if(fp.exists() && !fp.isDirectory() && fp.canRead()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * uses the Pattern object to check if the supplied String is a valid
	 * 	regular expression.
	 * 
	 * @param arg the string supplied to check
	 * @return true if valid
	 */
	public static boolean isValidPattern(String arg) {
		
		try {
			Pattern.compile(arg);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	/**
	 * checks the supplied string to see if the supplied option is valid,
	 * 	as of now -- it only accepts "-n"
	 * 
	 * @param arg the string supplied to check
	 * @return true if valid
	 */
	public static boolean isValidOption(String arg) {
		
		switch(arg) {
			case "-n" : return true;
			default : return false;
		}
	}


	/**
	 * @return the instance
	 */
	public static Command getInstance() {
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(Command instance) {
		Command.instance = instance;
	}

}
