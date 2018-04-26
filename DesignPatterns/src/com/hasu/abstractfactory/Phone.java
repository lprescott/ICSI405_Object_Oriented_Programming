package com.hasu.abstractfactory;

public class Phone {
	protected String name;
	
	public Phone(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
