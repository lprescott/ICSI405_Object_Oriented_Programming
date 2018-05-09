package edu.albany.budgettracker.budget;

import java.util.Arrays;

import edu.albany.budgettracker.budget.expenditure.Expenditure;

public class Budget {
	
	private double netIncome;
	private double deductions;
	private Expenditure[] expenditures;
	
	public Budget(double netIncome, double deductions, Expenditure[] expenditures) {
		this.setNetIncome(netIncome);
		this.setDeductions(deductions);
		this.setExpenditures(expenditures);
	}

	public Budget() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the netIncome
	 */
	public double getNetIncome() {
		return netIncome;
	}

	/**
	 * @param netIncome the netIncome to set
	 */
	public void setNetIncome(double netIncome) {
		this.netIncome = netIncome;
	}

	/**
	 * @return the deductions
	 */
	public double getDeductions() {
		return deductions;
	}

	/**
	 * @param deductions the deductions to set
	 */
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	/**
	 * @return the expenditures
	 */
	public Expenditure[] getExpenditures() {
		return expenditures;
	}

	/**
	 * @param expenditures the expenditures to set
	 */
	public void setExpenditures(Expenditure[] expenditures) {
		this.expenditures = expenditures;
	}

	@Override
	public String toString() {
		return "Budget [netIncome=" + netIncome + ", deductions=" + deductions + ", expenditures="
				+ Arrays.toString(expenditures) + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(deductions);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Arrays.hashCode(expenditures);
		temp = Double.doubleToLongBits(netIncome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Budget other = (Budget) obj;
		if (Double.doubleToLongBits(deductions) != Double.doubleToLongBits(other.deductions))
			return false;
		if (!Arrays.equals(expenditures, other.expenditures))
			return false;
		if (Double.doubleToLongBits(netIncome) != Double.doubleToLongBits(other.netIncome))
			return false;
		return true;
	}

}
