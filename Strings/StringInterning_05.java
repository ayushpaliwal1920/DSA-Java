package Strings;

public class StringInterning_05 {

    // Interning = String Interning in Java is a process of storing only one copy of each distinct String value,  which must be immutable.
        
    // Immutability of string : strings value cannot be changed but we can modify 

    // why immutability ? =. because of interning type problem.
    public static void main(String[] args) {
        String s = "hello";
        String x = "hello";

        x = "Mello"; // s =? will s also be changed => answer is no new string Mello will be created in heap and x will store stack pointer that points to 'Mello' string

        System.out.println(s);
        System.out.println(x); // Strings are immutable cannot be changed in memory only new string can created


        // Modifying the value of string :

        x = s.substring(0,2)  + "y" + s.substring(3);

        System.out.println(x); // x is modified but string is not changed new string "heylo" is created and x is storing stack pointer which points to the 'heylo' string in heap
    }

}
