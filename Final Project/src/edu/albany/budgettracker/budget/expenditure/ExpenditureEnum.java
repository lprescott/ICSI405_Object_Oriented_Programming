package edu.albany.budgettracker.budget.expenditure;

public enum ExpenditureEnum {
	HOUSING(.35),
	TRANSPORTATION(.15),
	FOOD(.15),
	DEBT_PAYMENTS(.10),
	PERSONAL(.07),
	SAVINGS(.06),
	UTILITIES(.05),
	CLOTHING(.04),
	MEDICAL(.03);

	private double percentage;
	
	ExpenditureEnum(double percentage){
		this.percentage = percentage;
	}

	/**
	 * @return the percentage
	 */
	public double getPercentage() {
		return percentage;
	}
}
