package edu.albany.generics.ex2;

public class Square extends Rectangle{

	public Square(double length) {
		super(length, length);
	}
	
	public Square(int x, int y, double length) {
		super(x, y, length, length);
	}

}
