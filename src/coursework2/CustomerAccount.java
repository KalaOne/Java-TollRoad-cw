/*
 * Java Coursework Toll Road.
 * Customer Account class.
 * Author : Kaloyan Valchev 100137489
 */
package coursework2;

public class CustomerAccount implements Comparable<CustomerAccount>{
    //eNum for values for discounts
    private enum DiscountType {
        NONE, STAFF, FRIENDS_AND_FAMILY
    }
    //Variables used by customer
    private final String custFName;
    private final String custLName;
    private final Vehicle vehicle;
    private int accBalance = 0;
    //setting default discount type to be NONE
    private DiscountType discType = DiscountType.NONE;

    //Set Staff discount to account
    public void activateStaffDisc() {
        discType = DiscountType.STAFF;
    }

    // Set Friends and family discount to account.
    public void activateFFDisc() {
            discType = DiscountType.FRIENDS_AND_FAMILY;
    }

    //deactivate discount = setting to NONE
    public void deadctivateDisc() {
        discType = DiscountType.NONE;
    }

    //add money to balance
    public void addFunds(int cash) {
        accBalance += cash;
    }
    //Constructor for cust.Account 
    public CustomerAccount(String custFName, String custLName, Vehicle vehicle, int balance) {
        this.custFName = custFName;
        this.custLName = custLName;
        this.vehicle = vehicle;
        this.accBalance = balance;
        this.discType = DiscountType.NONE;

    }
    //Overriding compareTo method to compare customer accounts and return different value
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
        //if discount is STAFF - reducing the price by 50%
        if (discType == DiscountType.STAFF) {
            amount = (int) (amount * 0.5);
        //if discount is Friends and Family - reducing the price by 10%
        } else if (discType == DiscountType.FRIENDS_AND_FAMILY) {
            amount = (int) (amount * 0.9);
        }
        // If the account balance is less than the cost of the trip
        //throws exception for insufficient money
        if (accBalance < amount) {
            throw new InsufficientAccountBalanceException("Not enough money!");
        }
        //reducing the account balance with the cost of the trip.
        accBalance = accBalance - amount;
        return amount; // returns the cost of the trip.
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
// Test main.
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
