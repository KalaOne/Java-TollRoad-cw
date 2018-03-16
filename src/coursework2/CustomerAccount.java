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
public class CustomerAccount implements Comparable<CustomerAccount>{



    private enum DiscountType {
        NONE, STAFF, FRIENDS_AND_FAMILY
    }

    private final String custFName;
    private final String custLName;
    private final Vehicle vehicle;
    private int accBalance = 0;
    private DiscountType discType = DiscountType.NONE;

    //Set Staff discount to account
    public void activateStaffDisc() {
        discType = DiscountType.STAFF;
    }

    // if acc doesnt have "Staff" discount, then set to Friends and family
    public void activateFFDisc() {
        if (discType != DiscountType.STAFF) {
            discType = DiscountType.FRIENDS_AND_FAMILY;
        }
    }

    //deactivate discount
    public void deadctivateDisc() {
        discType = DiscountType.NONE;
    }

    //add money to balance
    public void addFunds(int cash) {
        accBalance += cash;
    }
    //Constructor for cust.Account passing values
    public CustomerAccount(String custFName, String custLName, Vehicle vehicle, int balance) {
        this.custFName = custFName;
        this.custLName = custLName;
        this.vehicle = vehicle;
        this.accBalance = balance;
        this.discType = DiscountType.NONE;

    }

    @Override
    public int compareTo(CustomerAccount custAcc){
        if(this.vehicle.regNo.compareTo(custAcc.vehicle.regNo) > 0 ){
            return 1;
        }
        else if(this.vehicle.regNo.compareTo(custAcc.vehicle.regNo) < 0 ){
            return -1;
        }
       else{
            return 0;
        }

    }
    // Make trip method, returning the cost of the trip.
    public int makeTrip() throws InsufficientAccountBalanceException {  //CREATE EXCEPTION CLASS!
        int amount = vehicle.calcTripCost();
        if (discType == DiscountType.STAFF) {
            amount = (int) (amount * 0.5);
        } else if (discType == DiscountType.FRIENDS_AND_FAMILY) {
            amount = (int) (amount * 0.9);
        }

        if (accBalance < amount) {
            throw new InsufficientAccountBalanceException("Not enough money!");
        }
        accBalance = accBalance - amount;
        return amount;
    }
    // Accessor methods
    public String getCustFName() {
        return custFName;
    }

    public String getCustLName() {
        return custLName;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public int getBalance(){
        return accBalance;
    }

    public DiscountType getDiscType(){
        return discType;
    }

    public static void main(String[] args){
        CustomerAccount custom = new CustomerAccount("Name", "Not a name",new Car("EH515KX","Porche", 4), 400);
        CustomerAccount custom2 = new CustomerAccount("Pete", "Surname",new Van("Bro12ugh","Ford", 700), 800);
        CustomerAccount custom3 = new CustomerAccount("Fran", "Last name",new Truck("Kiz12me","Volvo", 1), 1500);
        CustomerAccount custom4 = new CustomerAccount("Jake", "Thompson",new Van("He11No","Tesla", 330), 100);
        CustomerAccount custom5 = new CustomerAccount("Jake", "Thompson",new Van("He11No","Tesla", 330), 100);

        System.out.println(custom.compareTo(custom2)); //1
        System.out.println(custom2.compareTo(custom3)); // -1
        System.out.println(custom3.compareTo(custom4)); //1
        System.out.println(custom4.compareTo(custom)); //1
        System.out.println(custom5.compareTo(custom4)); //0
    }
   
}
