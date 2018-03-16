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
public class Car extends Vehicle {
    // int for number of seats in a car
    private int numOfSeats;

    //overriding the calcTripCost function to return different values than parent
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
        super(regNo, make);
        //using parent class (Vehicle) constructor
//        this.regNo      = regNo;
//        this.make       = make;
        this.numOfSeats = numOfSeats;
    }

    // accessing the number of seats
    public int getNumOfSeats() {
        return numOfSeats;
    }

    public static void main(String[] args) {
        Vehicle car = new Car("EK6 70AG", "Hyunday", 7);
        System.out.println(car.calcTripCost());
    }

}