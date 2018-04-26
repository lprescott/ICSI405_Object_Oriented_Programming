package edu.alb;

import java.util.Collection;

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
