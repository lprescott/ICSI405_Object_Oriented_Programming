package com.hasu.observer;

public class ObserverMain {
	public static void main(String[] args) {
		Observer1 o1 = new Observer1();
		Observer2 o2 = new Observer2();
		
		Updater up = new Updater();
		up.addObserver(o1);
		up.addObserver(o2);
		
		up.update();
		up.update();
		up.update();
	}
}
