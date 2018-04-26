package com.hasu.facade;

//Facade class
public class Mortgage
{
	private Bank bank = new Bank();
	private Loan loan = new Loan();
	private Credit credit = new Credit();

	public boolean IsEligible(Customer cust, int amount)
	{
		System.out.println(String.format("%s applies for %d loan\n",
				cust.name, amount));

		boolean eligible = true;

		// Check creditworthyness of applicant
		if (!bank.HasSufficientSavings(cust, amount))
		{
			eligible = false;
		}
		else if (!loan.HasNoBadLoans(cust))
		{
			eligible = false;
		}
		else if (!credit.HasGoodCredit(cust))
		{
			eligible = false;
		}

		return eligible;
	}
}
