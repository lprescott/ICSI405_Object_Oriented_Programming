package edu.albany.generics.ex1;

public class Rectangle implements IShape<Double> {
	
	private int x;
	private int y;
	private double length;
	private double width;
	
	public Rectangle(int x, int y, double length, double width ){
		this.x = x;
		this.y = y;
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
