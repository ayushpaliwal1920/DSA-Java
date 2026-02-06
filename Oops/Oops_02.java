package Oops;

public class Oops_02 {

    // Getters and setters :

    /*
    Getter in Java: Getter returns the value (accessors), it returns the value of data type int, String, double, float, etc. For the program's convenience, the getter starts with the word "get" followed by the variable name.

    Setter in Java: While Setter sets or updates the value (mutators). It sets the value for any variable used in a class's programs. and starts with the word "set" followed by the variable name. 

   */

    // this keyword : The this keyword refers to the current object in a method or constructor.



    // Constructor :
   /*
     A constructor in Java is a special member that is called when an object is created. It initializes the new object’s state.
      It is used to set default or user-defined values for the object's attributes

   */

    //   final keyword : a non-access modifier used to restrict the user from changing variables, methods, and classes.

    //   static keyword :  a non-access modifier used to declare members that belong to the class itself, rather than to any specific instance (object) of the class

    // static functions : This method belongs to the class itself, rather than any specific object (instance) of that class, and can be called without creating an instance. 
  //  static used if we Want to access a function in the class through just classsname.funxtion not by objects
    public static void main(String[] args) {

        cars c1 = new cars("defennder","fff",8796,99086);
        cars c2 = new cars("defender","ggg",234,234444);
        cars c3 = new cars(7867,9876);
        cars c4 = new cars(); // default constructor

        System.out.println(c1.name);
        System.out.println(c2.model);
        System.out.println(c3.getNumberPlate() + "," + c3.getRc());
        System.out.println(c1.wheels);


        System.out.println(cars.getnumberOfcars()); // without static = 2 , with static = 3
        System.out.println(cars.getnumberOfcars()); // without static = 2 , with static = 3
        System.out.println(cars.getnumberOfcars()); // without static = 2 , with static = 3

        System.out.println(cars.getnumberOfcars()); // fxn calls only when method is static
        
        c1.setNumberPlate(4589);  // setter 
        System.out.println(c1.getNumberPlate());  // getter 

        
    }
}
