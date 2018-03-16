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
public class Truck extends Vehicle{
    
   private int numTrailer = 0;
   
   @Override
   public int calcTripCost(){
       if(numTrailer == 1)
           return 1250;
       else if(numTrailer > 1)
           return 1500;
       return 1500;
   }
   
   public Truck(String regNo, String make, int numTrailer){
       super(regNo, make);
       this.numTrailer = numTrailer;
   }
   
   public int getNumTrailer()
   {
       return numTrailer;
   }

    public static void main(String[] args) {
        Vehicle truck = new Truck("EK6 70AG", "Hyunday", 3);
        System.out.println(truck.calcTripCost());
    }
}