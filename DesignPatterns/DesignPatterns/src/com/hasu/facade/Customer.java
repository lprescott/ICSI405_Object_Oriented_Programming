package com.hasu.facade;

public class Customer
{
	protected String name;
	
	Customer(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
