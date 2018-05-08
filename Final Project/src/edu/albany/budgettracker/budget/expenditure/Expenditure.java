package edu.albany.budgettracker.budget.expenditure;

public class Expenditure {
	
	private double amount;
	private ExpenditureEnum type;
	private Regularity repeat;
	
	/**
	 * @param amount
	 * @param type
	 * @param repeat
	 */
	public Expenditure(double amount, ExpenditureEnum type, Regularity repeat) {
		super();
		this.setAmount(amount);
		this.setType(type);
		this.setRepeat(repeat);
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the type
	 */
	public ExpenditureEnum getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ExpenditureEnum type) {
		this.type = type;
	}

	/**
	 * @return the repeat
	 */
	public Regularity getRepeat() {
		return repeat;
	}

	/**
	 * @param repeat the repeat to set
	 */
	public void setRepeat(Regularity repeat) {
		this.repeat = repeat;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((repeat == null) ? 0 : repeat.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Expenditure other = (Expenditure) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (repeat == null) {
			if (other.repeat != null)
				return false;
		} else if (!repeat.equals(other.repeat))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Expenditure [amount=" + amount + ", type=" + type + ", repeat=" + repeat + "]";
	}
	
	
	
}
