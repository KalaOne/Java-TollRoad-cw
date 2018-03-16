/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework2;

/**
 *
 * @author Home
 */
public abstract class Vehicle {
    //int for make and register number of a vehicle
    public String regNo;
    public String make;
    
    //basic constructor
    public Vehicle(String regNo, String make){
        this.regNo = regNo;
        this.make  = make;
    }
    
    public abstract int calcTripCost();

    //accessor for register no and make
    public String getRegNo(){
        return regNo;
    }
    public String getMake(){
        return make;
    }
}

