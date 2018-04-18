package edu.albany.cruise;

import edu.albany.cargo.Ship;

/*
* @author Luke R. Prescott 
* Student ID: 001252879
* 
* Start Date: April 16th, 2018
*
* Project Name: HW3
* 
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* The CruiseShip.java object fulfills the following requirements:
* 
*   1. A field for the maximum number of passengers (int)
*   2. A constructor and appropriate accessors and mutators
*   3. A toString method that overrides the toString method in the base class. The CruiseShip class’s
*      toString method should display only the ship’s name and the maximum number of passengers
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class CruiseShip extends Ship{
    
    /*
    * This field is the CruiseShip object's passengers
    */
    private int max_passengers;

    /*
    * This constructor expects the CruiseShip object's name, year built and maximum number of passengers.
    */
    public CruiseShip(String new_ship_name, String new_year_built, int new_max_passengers){
        super(new_ship_name, new_year_built);
        set_max_passengers(new_max_passengers);
    }

    /*
    * This method gets the CruiseShip object's maximum number of passengers.
    */
    public int get_max_passengers(){
        return this.max_passengers;
    }

    /*
    * This method sets the CruiseShip object's maximum number of passengers.
    */
    public void set_max_passengers(int new_max_passengers){
        this.max_passengers = new_max_passengers;
    }

    /*
    * This toString methods displays the CruiseShip's name and the maximum 
    * number of passengers
    */
    @Override
    public String toString(){
        return "Ship name: " + this.get_ship_name() 
            + "\nMaximum passengers: " + this.get_max_passengers();
    }
}
