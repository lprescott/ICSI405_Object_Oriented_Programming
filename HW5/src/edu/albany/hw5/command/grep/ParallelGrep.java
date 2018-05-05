package edu.albany.hw5.command.grep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
* @file Parallel.java is the parallel implementation of grep
* 					it splits the inputed file by 2, 
* 					searching through each half with different threads. 	
* 
* 
* It takes commands in the form:
* 					ParallelGrep -option pattern filePath
* 
*					-option ~ only -n is accepted thus far, prints the lines that a given pattern have appeared in.
*
*					pattern ~ any regular expression is accepted, to be searched for
*
*					filePath ~ can be the local path or an absolute path value
*
*
* The Unix grep program finds lines that match a regular expression. This is a java version of grep.
* 
* 
*~~~~~~~~~~~~~~INFO~~~~~~~~~~~~~~~
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
public class ParallelGrep extends Command{
	
	private static ParallelGrep instance;
	
	private String option; //the accepted option, -n for now
	private String pattern; //pattern is the regular expression to search for
	private String file; //file is the absolute path, or local path of a file to search in
	
	/**
	 * This main method can accept three arguments, option, pattern then file/
	 * 
	 * @param args -option pattern file
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
			//System.out.println("(parallel)");
			//System.out.println("grep " + args[0] + " \'" + args[1] + "\' " + args[2]);

			//Checking for valid commands
			if ((isValidOption(args[0]) && (isValidPattern(args[1]) && (isValidFile(args[2]))))) {
				
				//Create a new command instance and call execute with valid args
				instance = new ParallelGrep();
				instance.setOption(args[0]);
				instance.setPattern(args[1]);
				instance.setFile(args[2]);
				
				//Execute
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
		System.out.println(String.format("\ntiming%10sms", (System.nanoTime() - start)/1000000)); 
	}	
	
	/**
	 * This function takes no parameters, and enacts upon the singleton parallelgrep a few iterative steps, to 
	 * 	start the parallel process.
	 * 
	 * 	That is, split the input into two equal-sized regions, then look for instances of the regular expression in
	 * 	each region.
	 * 	
	 */
	public void execute() {
		
		//Use the below method findSplit to determine where to split the input file.
		long fileSplit = findSplit(this.getFile());
		
		//Check if file split was unable to complete
		if(fileSplit == 0) {
			System.out.println("fileSplit was unable to complete.");
		}
		
		//Initialize two arraylists for the first and second half of the inputted files data
		ArrayList<String> firstHalf = new ArrayList<String>();
		ArrayList<String> secondHalf = new ArrayList<String>();

		//Initialize lineNumber, and charNumber counts to 0
		int lineNumber = 0; int charNumber = 0;
		
		//Try catch the creation of a BufferedReader br, to loop through the inputfile line by line
		try (BufferedReader br = new BufferedReader(new FileReader(this.getFile()))) {
			
			//Initialize a String that contains each line, temporarily 
			String line;
			
			//While there are more lines
		    while ((line = br.readLine()) != null) {
		    	
		    	//Incrememnt counts
		    	lineNumber ++;
		    	charNumber += line.length();
		    	
		    	//Depending on the locatoin, add to the first or second half
		    	if(charNumber < fileSplit) {
		    		firstHalf.add(lineNumber + ":" + line);
		    	} else {
		    		secondHalf.add(lineNumber + ":" + line);
		    	}
		    	
		    }
		}
		catch (IOException e) {
			e.getLocalizedMessage();
		}
	

		//Create a thread to loop through the solutions created by calling grep function
			//	on firstHalf ArrayList
		Thread thread1 = new Thread() {
		    public void run() {
				for(String s : grep(firstHalf)) {
					System.out.println(s);
				} 
		    }
		};

		
		//Create a thread to loop through the solutions created by calling grep function
			//	on secondHalf ArrayList, in the thread joing to thread1 and therefore,
			// wait for thread1 to complete.
		Thread thread2 = new Thread() {
		    public void run() {
		    	
		    	//temp stores the solutions to be printed after thread1's completion
				ArrayList<String> temp;
				temp = grep(secondHalf);
				try {
					thread1.join();
					for(String s : temp) {
						System.out.println(s);
					} 
				} catch (InterruptedException e) {
					
					e.getLocalizedMessage();
				}
			}
		};

		//Start the threads
		thread1.start();
		thread2.start();
		
		//Complete by joining thread2 to main thread
		try {
			thread2.join();
		} catch (InterruptedException e) {
			
			e.getLocalizedMessage();
		}
	}

	/**
	 * 
	 * @param half is one half of the input file
	 * @return the returnable arraylist that contains lines with instances pattern param.
	 */
	private ArrayList<String> grep(ArrayList<String> half){
		
		//Returnable contains the lines that contatin this instance's pattern
		ArrayList<String> returnable = new ArrayList<String>();
		for(String searcher : half) {
			if(searcher.contains(this.getPattern())) {
				returnable.add(searcher);
			}
		}
		
		return returnable;
	}

	/*
	 * The findSplit method returns a long value thats the closest right whitespace index to the center of the 
	 * 	supplied file.
	 */
	private long findSplit(String filePath) {
		
		//Variables for creating the file and reader
		File fp = new File(filePath);
		BufferedReader reader;
		
		//Get the length and mathematically closes split
		long fileLength = fp.length();
		long split = Math.round(fileLength/2);
		
		//Try catch the read through of each character of the input file
	
		try { reader = new BufferedReader(new FileReader(this.getFile()));

			//count and int ch to hold characters
			int ch; int count = 0;
			
			//While there are more characters
			while((ch = reader.read()) != -1) {
				
				//increment count, and cast int ch to a char
				@SuppressWarnings("unused")
				char character = (char) ch;
				count++;
			  
				//If we are above the split, and its whitespace close reader and return counts
				if(count > split && Character.isWhitespace(ch)) {
					reader.close();
					return count;
				}
			}
			
			reader.close();
				
		  //catch exceptions
		} catch (FileNotFoundException e) {
			
			e.getLocalizedMessage();
		} catch (IOException e) {
			
			e.getLocalizedMessage();
		}
		
		//finally return 0 
		return 0;
			
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
