package Oops;

// Class in different file but same package.

public class cars {

     public String name;  // sare packages mai use krne k liye public kra h 

     String model;
 
     private int numberplate;

     private int rc;

     final int wheels = 4 ;

     private static int numberOfCars = 1; // class dependent not object dependent


    //  Constructor :

     public cars(){}  // default constructor 
     public cars(String name , String model){ // parameterized constructor 
        
        this.name  = name;
        this.model = model;

     }
     public cars(int numberplate, int rc){
        this.numberplate = numberplate;
        this.rc = rc;
     }

     public cars(String name , String model , int numberplate , int rc){
        this.name = name;
        this.model = model;
        this.numberplate = numberplate;
        this.rc = rc;
        numberOfCars++;
     }

    //  getter :

     public int getNumberPlate(){
        return numberplate;
     }
      
    //  setter :

    public void setNumberPlate(int number){
        numberplate = number;
    }

    // this keyword : this represents the attribute of current class.
    //                yha this.rc means vo val rc jo humne uper declare kiya h and int rc matlab jo passed value h.

    public void setRc(int rc){ // setter
        this.rc = rc;
    }

    public int getRc(){ // getter
        return rc;
    }

    public static int getnumberOfcars(){
      return numberOfCars;
    }
    
}
