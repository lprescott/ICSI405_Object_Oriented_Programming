package edu.albany.cargo;

import edu.albany.ship.Ship;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: April 16th, 2018
*
* Project Name: HW2
* Package Name: edu.albany.cargo
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* The CargoShip.java object fulfills the following requirements:
* 
*   1. A field for the cargo capacity in tonnage (int)
*   2. A constructor and appropriate accessors and mutators
*   3. A toString method that overrides the toString method in the base class. The CargoShip class’s
*      toString method should display only the ship’s name and the ship’s cargo capacity
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class CargoShip extends Ship{
    
    /*
    * This field is the CargoShip object's passengers
    */
    private int cargo_capacity;

    /*
    * This constructor expects the CargoShip object's name, year built, and cargo capacity.
    */
    public CargoShip(String new_ship_name, String new_year_built, int new_cargo_capacity){
        super(new_ship_name, new_year_built);
        set_cargo_capacity(new_cargo_capacity);
    }

    /*
    * This method gets the CargoShip object's cargo capacity.
    */
    public int get_cargo_capacity(){
        return this.cargo_capacity;
    }

    /*
    * This method sets the CargoShip object's cargo capacity.
    */
    public void set_cargo_capacity(int new_cargo_capacity){
        this.cargo_capacity = new_cargo_capacity;
    }

    /*
    * This toString methods displays the CargoShip's name and the cargo 
    * capacity.
    */
    @Override
    public String toString(){
        return "Ship name: " + this.get_ship_name() 
            + "\nCargo capacity: " + this.get_cargo_capacity();
    }
}
