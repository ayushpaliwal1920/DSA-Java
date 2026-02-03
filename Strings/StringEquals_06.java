package Strings;

public class StringEquals_06 {

    /*
    str.equals() ans '==' => uses for comparing two strings we mostly uses str.equals() 
    
    */
    public static void main(String[] args) {

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        // for "==" operator checks address and  address should be same for true answer. it does not checks the string value

        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  // false

        // for "equals()" function check address and also the string value , ans return answer true if the strins are same

        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true

    }
}
