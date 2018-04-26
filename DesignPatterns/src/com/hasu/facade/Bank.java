package com.hasu.facade;

public class Bank
{
	public boolean HasSufficientSavings(Customer c, int amount)
	{
		System.out.println("Check bank for " + c.name);
		return true;
	}
}