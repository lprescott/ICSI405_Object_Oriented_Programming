package edu.albany.cargo;

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
* The Ship.java object fulfills the following requirements:
* 
*   1. A field for the name of the ship (string)
*   2. A field for the year that the ship was built (string)
*   3. A constructor and appropriate accessors and mutators
*   4. A toString method that displays the ship’s name and the year it was built
*
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
public class Ship{
    
    /*
    * These fields contain the Ship object's name and year built.
    */
    private String ship_name;
    private String year_built;

    /*
    * This constructor expects both the Ship object's name and year built.
    */
    public Ship(String new_ship_name, String new_year_built){
        set_ship_name(new_ship_name);
        set_year_built(new_year_built);
    }

    /*
    * These methods get the Ship object's name and year built.
    */
    public String get_ship_name(){
        return this.ship_name;
    }
    public String get_year_built(){
        return this.year_built;
    }

    /*
    * These methods set the Ship object's name and year built.
    */
    public void set_ship_name(String new_ship_name){
        this.ship_name = new_ship_name;
    }
    public void set_year_built(String new_year_built){
        this.year_built = new_year_built;
    }

    /*
    * This toString methods displays the Ship's name and the year 
    * it was built.
    */
    @Override
    public String toString(){
        return "Ship name: " + this.get_ship_name() 
            + "\nYear built: " + this.get_year_built();
    }
}
