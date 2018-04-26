package com.hasu.adapter;

/// <summary>
/// The 'Adapter' class
/// </summary>
public class RichCompound extends Compound
{
	private ChemicalDatabank bank;

	// Constructor
	public RichCompound(String name)
	{
		super(name);
	}

	@Override
	public void display()
	{
		// The Adaptee
		bank = new ChemicalDatabank();

		boilingPoint = bank.GetCriticalPoint(chemical, "B");
		meltingPoint = bank.GetCriticalPoint(chemical, "M");
		molecularWeight = bank.GetMolecularWeight(chemical);
		molecularFormula = bank.GetMolecularStructure(chemical);

		super.display();
		System.out.println(String.format(" Formula: %s", molecularFormula));
		System.out.println(String.format(" Weight : %s", molecularWeight));
		System.out.println(String.format(" Melting Pt: %s", meltingPoint));
		System.out.println(String.format(" Boiling Pt: %s", boilingPoint));
	}
}

