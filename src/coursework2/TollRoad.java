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


    public void addCustomer(CustomerAccount acc) {
        collection.add(acc);
    }

    public CustomerAccount findCustomer(String regNum) throws CustomerNotFoundException {
        for (CustomerAccount cust : collection) {   // Looping through; name : looping FROM
            if(cust.getVehicle().getRegNo().equals(regNum)){
                return cust;
            }
        }
        throw new CustomerNotFoundException("Customer not found ...");
    }

    public void chargeCustomer(String registrationNumber) throws InsufficientAccountBalanceException, CustomerNotFoundException {
        CustomerAccount findCust = findCustomer(registrationNumber);
        moneyMade = moneyMade + findCust.makeTrip();
    }



}
