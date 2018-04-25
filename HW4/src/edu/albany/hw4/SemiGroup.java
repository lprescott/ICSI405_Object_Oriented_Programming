package edu.albany.hw4;

import java.util.Collection;

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
* SemiGroup.java defines an abstract, typed class Semigroup<T> that specififes an operator operation, 
* 	which takes one argument. 
* 	
* 	The combine method will compute & accumulate the operator results sequentially for all the elements 
*  	in a Collection
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public abstract class SemiGroup<T> {
	public abstract T operate(T b);
	// fix and use - may fix method signature if required
	public static <T> T combine(Collection<T> list){
		return null;
	}
}
