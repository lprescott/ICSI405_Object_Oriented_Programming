package edu.albany.generics.ex2;

public class Rectangle extends Shape<Double, Integer> {
	
	private double length;
	private double width;
	
	public Rectangle(int x, int y, double length, double width ){
		super(x,y);
		this.length = length;
		this.width = width;
	}

	public Rectangle(double length, double width ){
		this(0, 0, length, width);
	}
	
	@Override
	public Double getArea() {
		return length * width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
}
