package edu.albany.hw4.semigroup;

import java.util.Collection;
import java.util.Iterator;

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
		
		T sum = list.iterator().next();
		Iterator<T> iterator = list.iterator();
		iterator.next();
		
		//Iterate through the collection after assigning sum to be the first 
		//	element and iterating once
		while ( iterator.hasNext()){
			T iteration = (T) iterator.next();
			sum = sum.operate(iteration);
     	}
		
		return sum;
	}
}
