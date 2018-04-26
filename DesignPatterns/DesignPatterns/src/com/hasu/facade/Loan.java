package com.hasu.facade;

public class Loan
{
	public boolean HasNoBadLoans(Customer c)
	{
		System.out.println("Check loans for " + c.name);
		return true;
	}
}
