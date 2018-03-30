/*
 * Java Coursework Toll Road.
 * Truck class, extending Vehicle.
 * Author : Kaloyan Valchev 100137489
 */
package coursework2;

public class Truck extends Vehicle{
   //Integer for number of trailers. 
   private int numTrailer = 0;
   //Overriding calcTripCost to return different values.
   @Override
   public int calcTripCost(){
       if(numTrailer == 1)
           //if trailers are 1, returns 1250
           return 1250;
       else
           // If trailers are more than 1, return 1500
           return 1500;
   }
   //Constructor to make Truck
   public Truck(String regNo, String make, int numTrailer){
       super(regNo, make); //Using parrent class for registerNumber and make
       
       this.numTrailer = numTrailer;
   }
   //Accessing method for number of trailers.
   public int getNumTrailer()
   {
       return numTrailer;
   }
//Test main.
    public static void main(String[] args) {
        Vehicle truck = new Truck("EK6 70AG", "Hyunday", 3);
        System.out.println(truck.calcTripCost());
    }
}