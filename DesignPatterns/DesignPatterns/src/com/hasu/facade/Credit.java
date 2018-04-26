package com.hasu.facade;

public class Credit
{
	public boolean HasGoodCredit(Customer c)
	{
		System.out.println("Check credit for " + c.name);
		return true;
	}
}
