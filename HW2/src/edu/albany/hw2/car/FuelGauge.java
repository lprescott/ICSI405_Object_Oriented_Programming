package edu.albany.hw2.car;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: Feb 24th, 2018
*
* Project Name: HW2
* Package Name: edu.albany.hw2.car
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* The FuelGauge.java object fulfills the following requirements:
* 
*	This class will simulate a fuel gauge.
*	See instance variables below.
*
*	This class has two functions:
*	incrementFuel - This function increments the amount of fuel by 1 gallon. This simulates putting fuel
*		in the car (The car can hold max 15 gallons).
*
*	decrementFuel - This function decrements the amount of fuel by 1 gallon, if the amount of fuel is 
*	greater than 0 gallons. This simulates burning fuel as the car runs.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class FuelGauge {
	
	//Instance variable(s)
	private double currentFuel;

	//Constructor(s)
	public FuelGauge(double currentFuel) {
		this.currentFuel = currentFuel;
	}
	
	public FuelGauge() {
		this.currentFuel = 0;
	}
	
	//Getter(s) and setter(s)
	public double getCurrentFuel() {
		return currentFuel;
	}

	public void setCurrentFuel(double currentFuel) {
		this.currentFuel = currentFuel;
	}
	
	public void incrementFuel() {
		if(this.currentFuel < 15) {
			currentFuel ++;
		}
	}
	
	public void decrementFuel() {
		if(this.currentFuel > 0) {
			currentFuel --;
		}
	}
}
