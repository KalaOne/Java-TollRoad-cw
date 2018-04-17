/*
 * Java Coursework Toll Road.
 * Car class, extending Vehicle.
 * Author : Kaloyan Valchev 100137489
 */
package coursework2;

public class Car extends Vehicle {
    // integer for number of seats in a car
    private int numOfSeats;

    //overriding the calcTripCost function to return different values than parrent
    @Override
    public int calcTripCost() {
        if (numOfSeats <= 5)
            //if #seats is less or = to 5, return 500
            return 500;
        else
            // if greater than 5, return 600
            return 600;
    }

    //constructor for setting all values in car
    public Car(String regNo, String make, int numOfSeats) {
        super(regNo, make); //using parent class for registerNumber and make
        
        this.numOfSeats = numOfSeats;
    }

    // accessing method for number of seats
    public int getNumOfSeats() {
        return numOfSeats;
    }
    @Override
    public String toString(){
       return "Register number is " + regNo + " and the make is " + make + "and the number of seats are " + numOfSeats;
    }
//Test main.
    public static void main(String[] args) {
        Vehicle car = new Car("EK6 70AG", "Hyunday", 7);
        System.out.println(car.calcTripCost());
    }

}