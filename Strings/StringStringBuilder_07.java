package Strings;


public class StringStringBuilder_07 {

    // Declerations and Initialization : 

    // 1. StringBuilder str = new StringBuilder();
    // 2. StringBuilder str = new StringBuilder("Hello")
    // 3. StringBuilder str = new StringBuilder(Capacity: 30/32)
   
    // NOte : Important feature of StringBuilder is that we can change the string's index after initialization.

    //  FUNCTIONS :

    /*
    1. append(ch) : uses for adding new string with old one , like concatination.
    2. setCharAt(int, char) : uses for manipulating strings.
    3. insert(int,char/string) : uses for inserting char/string at particular index.
    4. deleteCharAt(int) : uses for deleting char at particular index.
    5. delete(int start,int end) : uses for deleting string from start index t0 end index-1;
    6. replace(int start,int end,string) : uses for replacing string from start index to end index-1 with new string.
    7. reverse() : uses for reversing the string.
    8. toString() : converts StringBuilder to String.
    9. length() : returns the length of string.
    10. capacity() : returns the current capacity of string.
    11. ensureCapacity(int) : ensures that the capacity is at least equal to the specified minimum.
    12. trimToSize() : trims the capacity to be the string's current length.
    13. charAt(int) : returns the char at particular index.
    14. subSequence(int start,int end) : returns the subsequence from start index to end index-1.
    15. substring(int start,int end) : returns the substring
    */

    public static void main(String[] args) {
        
        StringBuilder s1 = new StringBuilder("Hello");
        StringBuilder s2 = new StringBuilder(); // by default capacity 16
        StringBuilder s3 = new StringBuilder(40); // capacity = 40

        // Input to StringBuilder 

        // StringBuilder s4 = new StringBuilder(sc.nextLine());

        // append() :

        s1.append("world");
        System.out.println(s1); // Helloworld
        
        // setCharAt() :

        s1.setCharAt(0,'M'); 
        System.out.println(s1); // Melloworld

        // insert():

        s1.insert(2,'y');
        System.out.println(s1); // Myelloworld

        // deleteCharAt():

        s1.deleteCharAt(6);
        System.out.println(s1); // Myellowrld

        // delete(int start,int end):

        s1.delete(2,4); 
        System.out.println(s1); // Myorld

    
       
    }
}
