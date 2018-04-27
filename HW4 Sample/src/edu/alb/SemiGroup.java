package edu.alb;

import java.util.Collection;

public abstract class SemiGroup<T> {
	public abstract T operate(T b);

	// fix and use - may fix method signature if required
	public static <T> T combine(Collection<T> list){
		return null;
	}
}
	
