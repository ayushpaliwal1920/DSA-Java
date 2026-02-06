package Oops;

public class Oops_01 {

    // Classes are the blueprints only.
    // Objects are the real world entity.and Objects are instance of class.

    // Arrays are for similar datatype and clases are for different datatype.


    // ==========Passing class to functions==========:
    /*
        . we have to declare the class outside the main
        . classes are passed by reference.
        . user defined data types.

    */

    //  ===============Access Modifiers ============:

    /*
            . Public  = all packages
            . Private = same class (no changes no access)
            . Default = same package only 
    
    */


    // Creating a new data type : Student is a datatype 
    public  static class Student {
        public String name ;
        int rno ;
        double percentage;
    }

    // change fxn :

      public static void change( Student  s){
            s.name = "xyz";
        }

    public static void main(String[] args) {

        // class inside Main function :

        class Car{
                String name;
                @SuppressWarnings("unused")
                String type;
                @SuppressWarnings("unused")
                int price;
        }
      
        // Object creation of Student datatype : Class_name obj_name = new Class_name();

        Student s1 = new Student();
        Student s2 = new Student();

        Car c1 = new Car();

        // accessing attributes of object x :

        s1.name = "Ayush";
        s1.rno = 6;
        s1.percentage = 76.44;

        System.out.println(s1.name +" "+ s1.rno +","+ s1.percentage);

        s2.name = "Rohit";
        s2.rno = 8;
        s2.percentage = 89;

        System.out.println(s2.name +" "+ s2.rno +"," + s2.percentage);

        c1.name = "Mercedus";
        c1.price = 900000;
        c1.type = "Sedan";

        System.out.println(c1.name);


        // new value to the same variable : updation
        s1.name = "Akash";
        System.out.println(s1.name);


        // after change fxn : name will change because of passed by reference.

        change(s1);
        System.out.println(s1.name);

        // accessing from different file

        cars c2 = new cars();

        // c2.numberplate = 9898; 

        // System.out.println(c2.numberplate);

        // default values :

        System.out.println(c2.model); // null

    }
}
