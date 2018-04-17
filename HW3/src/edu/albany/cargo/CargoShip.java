package edu.albany.cargo;

import edu.albany.ship.Ship;

/*
 * This CargoShip object defines the child CargoShip object.
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
