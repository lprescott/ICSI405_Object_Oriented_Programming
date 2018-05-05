package edu.albany.hw5.command;

import java.io.File;
import java.util.regex.Pattern;

public abstract class Command {
	
	private static Command instance;

	/**
	 * 
	 * @param arg
	 * @return
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
	 * 
	 * @param arg
	 * @return
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
	 * 
	 * @param arg
	 * @return
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
