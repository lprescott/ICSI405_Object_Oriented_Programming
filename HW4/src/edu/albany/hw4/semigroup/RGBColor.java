package edu.albany.hw4.semigroup;

import edu.albany.hw4.Complementable;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: April 25th, 2018
*
* Project Name: HW4
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* RGBColor.java extends SemiGroup and implements Complementable.
* 
* 	Therefore, it overrides the required functions complementable and operate.
* 
* 	Its values are integers, r g and b. Like a standard color scheme.
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class RGBColor extends SemiGroup<RGBColor> implements Complementable<RGBColor>{

	//Instance Variable(s)
	private int r;
	private int g;
	private int b;
	
	//Constructor
	public RGBColor() {}
	
	//This constructor accepts three integers
	public RGBColor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	/*
	 *  The complement operation
	 * 	gives a new color whose components are each 255 minus the original.
	 */
	@Override
	public RGBColor complement() {
		return new RGBColor(255 - this.getR(), 255 - this.getG(), 255 - this.getB());
	}

	/*
	 *  The operate method returns 
	 *  the (integer) average of the components of the two input colors.
	 */
	@Override
	public RGBColor operate(RGBColor b) {
		int avgr = (this.getR() + b.getR())/2;
		int avgg = (this.getG() + b.getG())/2;
		int avgb = (this.getB() + b.getB())/2;
		return new RGBColor(avgr, avgg, avgb);
	}

	/**
	 * @return the r
	 */
	public int getR() {
		return r;
	}

	/**
	 * @param r the r to set
	 */
	public void setR(int r) {
		this.r = r;
	}

	/**
	 * @return the g
	 */
	public int getG() {
		return g;
	}

	/**
	 * @param g the g to set
	 */
	public void setG(int g) {
		this.g = g;
	}

	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(int b) {
		this.b = b;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * This toString methods prints the three instance variables of the RGBColor class.
	 */
	@Override
	public String toString() {
		return "(" + r + ", " + g + ", " + b + ")";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * This equals methods compares a RGBColor object with another object.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RGBColor other = (RGBColor) obj;
		if (b != other.b)
			return false;
		if (g != other.g)
			return false;
		if (r != other.r)
			return false;
		return true;
	}

}
