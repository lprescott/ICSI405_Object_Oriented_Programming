package edu.albany.generics.ex2;

public abstract class Shape<T, U extends Number> implements IShape<T> {

	private U x;
	private U y;
	
	public Shape(U x, U y){
		this.x = x;
		this.y = y;
	}

	public U getX() {
		return x;
	}

	public void setX(U x) {
		this.x = x;
	}

	public U getY() {
		return y;
	}

	public void setY(U y) {
		this.y = y;
	}

	//Leaving the interface method abstract
	
	
}
