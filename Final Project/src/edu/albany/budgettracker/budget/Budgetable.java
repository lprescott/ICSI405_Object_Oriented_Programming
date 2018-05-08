package edu.albany.budgettracker.budget;

public interface Budgetable<T> {
	public Budget createBudget(Budgetable<T> input);
}
