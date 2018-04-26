package com.hasu.adapter;

/// <summary>
/// The 'Target' class
/// </summary>
public class Compound
{
	protected String chemical;
	protected float boilingPoint;
	protected float meltingPoint;
	protected double molecularWeight;
	protected String molecularFormula;

	// Constructor
	public Compound(String chemical)
	{
		this.chemical = chemical;
	}

	public void display()
	{
		System.out.println(String.format("\nCompound: %s ------ ", chemical));
	}
}
