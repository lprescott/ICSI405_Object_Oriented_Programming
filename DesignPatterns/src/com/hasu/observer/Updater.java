package com.hasu.observer;

import java.util.Observable;

public class Updater extends Observable{
	
	protected int value = 1;

	public void update(){
		value ++ ;
		System.out.println("Updating..");
		System.out.println("Notifying observers");
		setChanged();
		notifyObservers(value);
	}
}
