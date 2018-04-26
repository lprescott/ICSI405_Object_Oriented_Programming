package com.hasu.observer;

import java.util.Observable;
import java.util.Observer;

public class Observer1 implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(String.format("I am observing %s with value %s", o, arg));
	}

	
}
