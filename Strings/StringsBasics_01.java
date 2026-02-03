package Strings;

import java.util.Scanner;

public class StringsBasics_01 {

    // Declaration and initialization : String s = "hello"

    // Taking input : next() and nextLine()

    // charAt() and length() => length() gives length of the string
    //                          charAt() gives character at index given.

    // indexOf() and compareTo() => The indexOf() method in Java is used to find the index of the first occurrence of a specified character or substring within a string, ArrayList, LinkedList, StringBuffer, or StringBuilder. 
    //                           => The compareTo() method in Java is used to compare the current object with a specified object to establish a natural ordering

    // contains() ans startsWith() => The contains() Used to check if a substring exists inside a string.
    //                             => The startsWith() startsWith() is a String method used to check whether a string begins with a specific prefix.

    // toLowerCase, toUpperCase and concat => for lowercase , uppercase and concatinate the string 
    


    public static void main(String[] args){
        // Strings is just array of characters :

        String str = "Ayush Paliwal";
        System.out.println("str : "+str);

        // input String :

        Scanner sc = new Scanner(System.in);
        // String s = sc.next();
        System.out.println("Enter a string : ");
        // String s = sc.nextLine();
        // System.out.println(s);

        // length() : space also counted as character 

        System.out.println("Length of string str : "+ str.length());

        // charAt : used to retrieve a specific character from a string, space is also counted

        char ch = str.charAt(5);
        System.out.println("Char at index 6 :" + ch);

        // indexOf : first occurence of given character in a string 

        int idx = str.indexOf("u");
        System.out.println("Index of u in str : "+ idx);

        // compareTo(): string str == gtr => answer = 0  
        //              string str > gtr  => answer = +ve( >0,lexographically)
        //              string str < gtr  => answer = -ve( <0,lexographically)

        String gtr = "Dyush Paliwal";

        System.out.println(str.compareTo(gtr));
        System.out.println(gtr.compareTo(str));

        // contains() : used to check substring belong to the string or not

        System.out.println("SubString 'sh' belongs to 'str' or not : " + str.contains("sh"));
        System.out.println("SubString 'wl' belongs to 'str' or not : " + str.contains("wl"));

        // startsWith() : used to check starting substring exist or not 

        System.out.println("String 'str' startsWith Substring 'Ayu' or not : " + str.startsWith("Ayu"));
        System.out.println("String 'str' startsWith substring 'Pal' or not : " + str.startsWith("Pal"));

        // endsWith() :

        System.out.println("String 'str' endsWith Substring 'wal' or not : " + str.endsWith("wal"));


        // toLowercase =>

        System.out.println("Str to lowercase : " +str.toLowerCase() );
    
        // toUpperCase =>

        System.out.println("Str to uppercase : " +str.toUpperCase() );

        // concat() =>

        System.out.println("Concatination of str and gtr : " + str.concat(gtr));
        System.out.println("Concatination of gtr and str : " + gtr.concat(" " + str));



        

        




    }
}
