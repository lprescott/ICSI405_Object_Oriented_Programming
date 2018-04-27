package edu.albany.hw4.semigroup;

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
	
	/*
	 *  Combine computes & accumulates the 
	 *  operator results sequentially for all the elements in a Collection of any
	 *  Semigroup objects.
	 */
	public static <T extends SemiGroup<T>> T combine(Collection<T> list) {
		
		//Initialize to null
		T sum = null;
		
		//Loop through list
		for(T iterator : list) {
			sum = sum.operate(iterator);
		}
		
		//return sum, the accumulation of operate
		return sum;	
	}
}
