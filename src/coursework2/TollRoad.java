/*
 * Java Coursework Toll Road.
 * Toll Road class.
 * Author : Kaloyan Valchev 100137489
 */
package coursework2;

import java.util.ArrayList;


public class TollRoad {
    //Variable moneyMade and arraylist of customer accounts
    public int moneyMade;
    ArrayList<CustomerAccount> collection = new ArrayList<CustomerAccount>();


    // Default constructor
    public TollRoad() {
        moneyMade = 0;
    }

    // Accessor methods
    public int getMoneyMade() {
        return moneyMade;
    }

    // Method adding a customer to the arraylist of customers.
    public void addCustomer(CustomerAccount acc) {
        collection.add(acc);
    }
    //Method finding the customer given register number.
    //Throws exception if customer is not found.
    public CustomerAccount findCustomer(String regNum) throws CustomerNotFoundException {
        for (CustomerAccount cust : collection) {   // Looping through; name : looping FROM
            if(cust.getVehicle().getRegNo().equals(regNum)){ //if the given reg Num exists, returns the customer
                return cust;
            }
        }
        throw new CustomerNotFoundException("Customer not found ...");
    }
    //Method that charges the passed registration number.
    //Throws exception if customer not found AND/OR customer doesn't have enough cash.
    public void chargeCustomer(String registrationNumber) throws InsufficientAccountBalanceException, CustomerNotFoundException {

        moneyMade += findCustomer(registrationNumber).makeTrip();
    }
}
