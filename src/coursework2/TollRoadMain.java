/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author zrt15fsu
 */
public class TollRoadMain extends TollRoad{

     
    
    public TollRoad initialiseTollRoadFromFile(){

        try{
            TollRoad newRoad = new TollRoad();
            File file = new File("customerData.txt");
            Scanner scan = new Scanner(file);
            scan.useDelimiter("#");
            Scanner nextScan;
            String vehicleType, regNum, vehicleInfo, fName, lName, discountType, make;
            int startingBalance;
            
            
            while(scan.hasNext()){
                nextScan = new Scanner(scan.next());
                nextScan.useDelimiter(",");
                //Taking individual variables from file.
                vehicleType = nextScan.next();
                regNum = nextScan.next();
                fName = nextScan.next();
                lName = nextScan.next();
                make = nextScan.next();
                vehicleInfo = nextScan.next();
                startingBalance =Integer.parseInt(nextScan.next());
                discountType = nextScan.next();
                
                if (vehicleType.equals("Car")){  //Checking if car
                    CustomerAccount cust = new CustomerAccount(fName, lName, new Car(regNum, make, Integer.parseInt(vehicleInfo)),startingBalance);
                    //Setting the discount type to appropriate
                    if(discountType.equals("STAFF")){
                        cust.activateStaffDisc();
                    }
                    else if(discountType.equals("FRIENDS_AND_FAMILY")){
                        cust.activateFFDisc();
                    }
                    else 
                        cust.deadctivateDisc();
                newRoad.addCustomer(cust);  // creating new customer account with car
                }
                
                if (vehicleType.equals("Van")){  //Checking if Van 
                    CustomerAccount cust = new CustomerAccount(fName, lName, new Van(regNum, make, Integer.parseInt(vehicleInfo)),startingBalance);
                    //Setting the discount type to appropriate
                    if(discountType.equals("STAFF")){
                        cust.activateStaffDisc();
                    }
                    else if(discountType.equals("FRIENDS_AND_FAMILY")){
                        cust.activateFFDisc();
                    }
                    else 
                        cust.deadctivateDisc();
                newRoad.addCustomer(cust); // creating new customer account with van
                }
                
                if (vehicleType.equals("Truck")){  //Checking if Truck
                    CustomerAccount cust = new CustomerAccount(fName, lName, new Truck(regNum, make, Integer.parseInt(vehicleInfo)),startingBalance);
                    //Setting the discount type to appropriate
                    if(discountType.equals("STAFF")){
                        cust.activateStaffDisc();
                    }
                    else if(discountType.equals("FRIENDS_AND_FAMILY")){
                        cust.activateFFDisc();
                    }
                    else 
                        cust.deadctivateDisc();
                newRoad.addCustomer(cust);// creating new customer account with truck
                }
              
            }
            //Add vehicles to customer
            //Add customer to arraylist
            //Week 3: UML Class Diagrams - Scanner
            //Create car/van/truck based on variables. 
            //Use constructor for the type of vehicle
            //Create new custommer(start with temp cust) 
            
                        
        }
        catch (Exception ex){
           ex.printStackTrace();
            System.out.println("Couldn't read file... (Intiliatise From File)");
        }
        return new TollRoad();
    }
    
// left to do: Read file
//If addFunds - cust.addFunds(regNum, amount)
//try (
//print out *regNum* : *amount* added succesfully
//
//If operation != complete, *regNum* : addFunds failed. CustomerAccount doesnt exist
//catch(CustomerNotFoundException)
//else - makeTrip (regNum)
    public void simulateFromFile(TollRoad road) throws FileNotFoundException, CustomerNotFoundException{
        
        try{
            File file = new File("transactions.txt");
            Scanner scan = new Scanner(file);
            scan.useDelimiter("\\$");
            
            Scanner scanNext;
            String function, registerNum;
            int amount;
            while (scan.hasNext()){
                
                scanNext = new Scanner(scan.next());
                scanNext.useDelimiter(",");
                function = scanNext.next();
                
                if(function.equals("addFunds")){ // if segment starts with addFunds
                    registerNum = scanNext.next(); //save reg num AND amount
                    amount = Integer.parseInt(scanNext.next());
                    // Adding funds to existing customer if they exist
                    try{
                        road.findCustomer(registerNum).addFunds(amount);
                        System.out.println(registerNum +": "+ amount + " added ");
                    }
                    catch(CustomerNotFoundException exception){
                        System.out.println(registerNum + ": addFunds failed. Customer does not exist...");
                    }
                }
                else // if segment starts with makeTrip
                    registerNum = scanNext.next(); // save only regNum
                    try{
                        road.findCustomer(registerNum).makeTrip();
                        System.out.println(registerNum + ": Trip completed successfully.");
                    }
                    catch(InsufficientAccountBalanceException exception){
                        System.out.println(registerNum + ": makeTrip failed. Insufficient funds.");
                    } catch(CustomerNotFoundException ex){
                        System.out.println(registerNum + ": makeTrip failed. Insufficient funds.");
                        ex.toString(); 
                    }
            }
            
        }
        catch (IOException notFound){
            System.out.println("Cant read file (from Simulate)");
        }
    }

     
   
    public static void main(String[] args) throws FileNotFoundException, CustomerNotFoundException {
        TollRoadMain myMoneyMakingScheme = new TollRoadMain();
        TollRoad tollRoad = new TollRoad();
        myMoneyMakingScheme.initialiseTollRoadFromFile();
        myMoneyMakingScheme.simulateFromFile(tollRoad);
        System.out.println(tollRoad.moneyMade);
        
    }
    
}
