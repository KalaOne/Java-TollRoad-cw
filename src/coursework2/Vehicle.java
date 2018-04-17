/*
 * Java Coursework Toll Road.
 * Vehicle class, parrent for other vehicles.
 * Author : Kaloyan Valchev 100137489
 */
package coursework2;

public abstract class Vehicle {
    //int for make and register number of a vehicle
    public String regNo;
    public String make;
    
    //basic constructor
    public Vehicle(String regNo, String make){
        this.regNo = regNo;
        this.make  = make;
    }
    // basic calcTripCost function. Is overriden from other classes
    public abstract int calcTripCost();

    //accessor for register no and make
    public String getRegNo(){
        return regNo;
    }
    public String getMake(){
        return make;
    }
    
    @Override
    public String toString(){
       return "Register number is " + regNo + " and the make is " + make;
    }
}

