package com.hasu.facade;

public class FacadeMain {
	public static void main(String[] args) {
		Mortgage m = new Mortgage();
		Customer c = new Customer("Harry");
		System.out.println(String.format("Eligibility for %s: %s", c.name, m.IsEligible(c, 10000)));
	}
}
