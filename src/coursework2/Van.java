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
public class Van extends Vehicle{
    //int for payload of the van
    private int payLoad = 0;
    
    //overrides the function to return different values from parrent class
    @Override
    public int calcTripCost(){
        if(payLoad <= 600)
            //if payload is less or = to 600kg, then charges £5
            return 500;
        else if(payLoad>600 && payLoad<= 800)
            //else if its between 600 and 800, charges £7.50
            return 750;
        else
            // everything above 800 charges a tenner
            return 1000;
    }
    
    //constructor for setting all values in Van 
    public Van (String regNo, String make, int payLoad){
        super (regNo, make); // using parent constructor (Vehicle)
        this.payLoad = payLoad;
    }
    
    //accessing payload
    public int getPayLoad(){
        return payLoad;
    }
    public static void main(String[] args) {
        Vehicle van = new Van("KGZ 15F", "Mercedess", 665);
        System.out.println(van.calcTripCost());
    }
}
