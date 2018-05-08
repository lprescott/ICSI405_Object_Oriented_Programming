package edu.albany.budgettracker.budget.expenditure;

public enum Regularity {
	DAILY(365),
	WEEKLY(52.17857),
	MONTHLY(12),
	SEMI_ANNUALLY(2),
	ANNUALLY(1);

	private double partsInYear;
	
	Regularity(double partsInYear){
		this.partsInYear = partsInYear; 
	}

	/**
	 * @return the partsInYear
	 */
	public double getPartsInYear() {
		return partsInYear;
	}
}
