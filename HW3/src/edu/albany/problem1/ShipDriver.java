package edu.albany.problem1;

import edu.albany.cargo.CargoShip;
import edu.albany.cruise.CruiseShip;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: April 16th, 2018
*
* Project Name: HW2
* Package Name: edu.albany.ship
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* The TestCase.java object fulfills the following requirements:
* 
*	1. Demonstrate the classes in a program that has a Ship array. 
*	2. Assign various Ship, CruiseShip and CargoShip objects to the array elements. 
*	3. The program should then step through the array, calling each object’s toString method.
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class ShipDriver {

	public static void main(String[] args) {
		//1. Demonstrate the classes in a program that has a Ship array. 
		Ship[] shipArray = new Ship[6];

		//2. Assign various Ship, CruiseShip and CargoShip objects to the array elements. 
		Ship testShip1 = new Ship("Test Ship 1", "2018");
		Ship testShip2 = new Ship("SS #2", "1997");

		CargoShip testCargo1 = new CargoShip("Test Cargo-Ship 1", "1956", 10100);
		CargoShip testCargo2 = new CargoShip("SS Heavy", "1989", 90512);

		CruiseShip testCruise1 = new CruiseShip("Test Cruise-Ship 1", "1980", 1232);
		CruiseShip testCruise2 = new CruiseShip("SS Layback", "1962", 9432);

		shipArray[0] = testShip1;
		shipArray[1] = testShip2;
		shipArray[2] = testCargo1;
		shipArray[3] = testCargo2;
		shipArray[4] = testCruise1;
		shipArray[5] = testCruise2;
		
		//3. The program should then step through the array, calling each object’s toString method.
		for(int i = 0; i < shipArray.length; i++){
			System.out.println(shipArray[i].toString() + "\n");
		}
	}

}
