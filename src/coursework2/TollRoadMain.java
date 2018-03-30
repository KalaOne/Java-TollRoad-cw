/*
 * Java Coursework Toll Road.
 * Main class for the coursework. Toll Road Main
 * Author : Kaloyan Valchev 100137489
 */
package coursework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class TollRoadMain extends TollRoad {
    //Method that reads and creates a toll road from given file.
    public static TollRoad initialiseTollRoadFromFile() {
        TollRoad newRoad = new TollRoad(); // creating new tollRoad that will be returned later.
        //Try catch - in case of errors.
        try {
            //Setting file path.
            File file = new File("customerData.txt"); 
            //Creating a scanner for the given file path
            Scanner scan = new Scanner(file);
            //Breaking down the file to hash key '#'
            scan.useDelimiter("#");
            //creating variables to store info from file
            Scanner nextScan;
            String vehicleType, regNum, vehicleInfo, fName, lName, discountType, make;
            int startingBalance;

            while (scan.hasNext()) { // looping through file until there are no next elements left.
                nextScan = new Scanner(scan.next());
                //breaking the segment into comas ',' so we can take individual elements.
                nextScan.useDelimiter(",");
                //Taking individual variables from file.
                vehicleType = nextScan.next();
                regNum = nextScan.next();
                fName = nextScan.next();
                lName = nextScan.next();
                make = nextScan.next();
                vehicleInfo = nextScan.next();
                startingBalance = Integer.parseInt(nextScan.next());
                discountType = nextScan.next();

                if (vehicleType.equals("Car")) {  //Checking if Car
                    //Creating a new customer account with the given values
                    CustomerAccount cust = new CustomerAccount(fName, lName, new Car(regNum, make, Integer.parseInt(vehicleInfo)), startingBalance);
                    //Setting the discount type to appropriate
                    if (discountType.equals("STAFF")) {
                        cust.activateStaffDisc();
                    } else if (discountType.equals("FRIENDS_AND_FAMILY")) {
                        cust.activateFFDisc();
                    } else {
                        cust.deadctivateDisc();
                    }
                    newRoad.addCustomer(cust);  // creating new customer account with car
                } else if (vehicleType.equals("Van")) {  //Checking if Van 
                    //Creating a new customer account with the given values
                    CustomerAccount cust = new CustomerAccount(fName, lName, new Van(regNum, make, Integer.parseInt(vehicleInfo)), startingBalance);
                    //Setting the discount type to appropriate
                    if (discountType.equals("STAFF")) {
                        cust.activateStaffDisc();
                    } else if (discountType.equals("FRIENDS_AND_FAMILY")) {
                        cust.activateFFDisc();
                    } else {
                        cust.deadctivateDisc();
                    }
                    newRoad.addCustomer(cust); // creating new customer account with van
                } else {  //Checking if Truck
                    //Creating a new customer account with the given values
                    CustomerAccount cust = new CustomerAccount(fName, lName, new Truck(regNum, make, Integer.parseInt(vehicleInfo)), startingBalance);
                    //Setting the discount type to appropriate
                    if (discountType.equals("STAFF")) {
                        cust.activateStaffDisc();
                    } else if (discountType.equals("FRIENDS_AND_FAMILY")) {
                        cust.activateFFDisc();
                    } else {
                        cust.deadctivateDisc();
                    }
                    newRoad.addCustomer(cust);// creating new customer account with truck
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Couldn't read file... (Intiliatise From File)");
        }
        return newRoad;  // returning the road with new customer accounts.
    }

    public static void simulateFromFile(TollRoad road) throws FileNotFoundException, CustomerNotFoundException {
        //Method that reads given road. Charge customers or adds money to their accounts.
        try { //Try catch - in case of errors.
            //Creating a file path
            File file = new File("transactions.txt");
            //Creating a scanner with the given file path.
            Scanner scan = new Scanner(file);
            scan.useDelimiter("\\$"); // splitting items where Dollar sign is.
            // Creating variables used to store info from file.
            Scanner scanNext;
            String function;
            String registerNum = null;
            int amount;
            while (scan.hasNext()) { //looping through file until there are no next elements left
                
                scanNext = new Scanner(scan.next());
                scanNext.useDelimiter(",");
                function = scanNext.next();
                
                if (function.equals("addFunds")) { // if segment starts with 'addFunds'
                    registerNum = scanNext.next(); //save reg num and amount
                    amount = Integer.parseInt(scanNext.next());
                    // Adding funds to existing customer if they exist
                    // If not, throws exception
                    try {
                        road.findCustomer(registerNum).addFunds(amount);
                        System.out.println(registerNum + ": " + amount + " added ");

                    } catch (CustomerNotFoundException exception) {
                        System.out.println(registerNum + ": addFunds failed. Customer does not exist...");
                    }
                }
                else  { // if segment starts with makeTrip
                    registerNum = scanNext.next(); // save only regNum
                    try {// Charging customer if they exist and have enough money
                        // If not, throws exception
                        road.chargeCustomer(registerNum);
                        System.out.println(registerNum + ": Trip completed successfully.");
                        System.out.println("Toll Road has made " + road.getMoneyMade() +" cash so far.");
                    } catch (InsufficientAccountBalanceException exception) {
                        System.out.println(registerNum + ": makeTrip failed. Insufficient funds.");
                    } catch (CustomerNotFoundException ex) {
                        System.out.println(registerNum + ": makeTrip failed. Insufficient funds.");
                        ex.toString();
                    }
                }
                
            }

        } catch (IOException notFound) {
            System.out.println("Cant read file (from Simulate)");
        }
        System.out.println("\n");
        System.out.println("Toll road made " + road.getMoneyMade() + " cash. Filthy rich!");
    }

    public static void main(String[] args) throws FileNotFoundException, CustomerNotFoundException {
        TollRoadMain myMoneyMakingScheme = new TollRoadMain();
        simulateFromFile(initialiseTollRoadFromFile());

    }

}
