package edu.albany.budgettracker.budget.expenditure;

public enum Regularity {
	DAILY("daily", 365),
	WEEKLY("weekly", 52.17857),
	MONTHLY("montly", 12),
	SEMI_ANNUALLY("semi-annually", 2),
	ANNUALLY("annually", 1);

	private double partsInYear;
	private String name;
	
	Regularity(String name, double partsInYear){
		this.name = name;
		this.partsInYear = partsInYear; 
	}

	/**
	 * @return the partsInYear
	 */
	public double getPartsInYear() {
		return partsInYear;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
