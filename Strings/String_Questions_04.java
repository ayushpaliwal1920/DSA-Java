package Strings;
import java.util.Scanner;

//  ================== String Question and Patterns =======================
public class String_Questions_04 {

    /*
             Q1.  given a string s, print all substrings of s .

    input = "abcd" , Output = a,ab,abc,abcd,b,bcd,c,cd,d
     */

    static void allSubstring(String s){

        for(int i = 0 ; i< s.length() ; i++){

            for(int j =i+1; j<=s.length(); j++){

                System.out.print(s.substring(i,j) + " ");

            }
        }
    }

    /*
            Q2: Given a string , the task is to toggle all the characters of the string.i.e convert Uppercase to lowerecase and viceversa.
    */

    static void toggleString(StringBuilder s){
        // A = 65 , a = 97 , 0 = 48 , 
        

     for(int i= 0 ; i<s.length();i++){
      // check -> alphabet is small or capital
       
        boolean flag = true; // true => capital
        char ch = s.charAt(i);
        int asci = (int)ch;

        if(ch == ' '){ continue;}

        if(asci >= 97){
            flag = false;
        }
        
        if(flag == true ){
            asci += 32;
            char dh = (char)asci; 
            s.setCharAt(i, dh);
        }else{
            // small
            asci -= 32;
            char dh = (char)asci;
            s.setCharAt(i, dh);
        }
    }
}

     static void toggleString(String s){
        // FOR STRING =>

             for(int i= 0 ; i<s.length();i++){
      // check -> alphabet is small or capital
       
        boolean flag = true; // true => capital
        char ch = s.charAt(i);
        int asci = (int)ch;

        if(ch == ' '){ continue;}

        if(asci >= 97){
            flag = false;
        }
        
        if(flag == true ){
            asci += 32;
            char dh = (char)asci; 

            // THIS IS THE CHANGE :

            s = s.substring(0,i) + dh + s.substring(i+1);

        }else{
            // small
            asci -= 32;
            char dh = (char)asci;

            // This is the change 

            s = s.substring(0,i) + dh + s.substring(i+1);
        }
    }

    }

    /*
    
    Q3.     Given a string s , return the number of palindromic substring in it.

    */

    static void ispalindrom(String s){
        StringBuilder gtr = new StringBuilder(s);
        gtr.reverse();
        String s1 = gtr + "";
        if(s.equals(s1)){
            System.out.println("Palindrom");
        }else{
            System.out.println("Not Palindrom");
        }
    }

    static boolean ispalindrom2(String str){
        int st =0 ;
        int end = str.length()-1;

        boolean flag = true;

        while( st < end){
            if(str.charAt(st)!=str.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
    return true;
     
    }

    static void palindromicSubstring(String s){

        int count = 0;
        
        // we will use allStubstring method and isPlaindrom method see :

        for(int i=0 ; i< s.length() ; i++){
            for(int j = i+1  ;j <= s.length() ; j++){
                if(ispalindrom2(s.substring(i,j)) == true){
                    System.out.print(s.substring(i,j) + " ");
                    count++;
                }
            }
        }
         System.out.println("\nNumber of palindroimic substring in a given substring  is : " + count);
    
    }

    /*
    
    Q4 : Given a program to reverse a each word in string :

    Input = > I am an educator  , Output => I ma na rotacude

    */

    static void reverseWordInSentence(String str){

        String ans = "";

        StringBuilder sb = new StringBuilder(""); // empty StringBuilder

        for(int i =0 ; i<str.length() ; i++){
            
           char ch = str.charAt(i);

           if(ch != ' '){

             sb.append(ch);

           }else{
              sb.reverse();
              ans += sb;
              ans += " ";
              sb = new StringBuilder(""); //  now empty stringBuilder 

           }
        }

        // last word sb mai hi reh gya qki last mai koi space nhi aya jisse condition false ho skati isliye humko baki ka kaam krna pda.

        sb.reverse();
        ans += sb;
        System.out.println(ans);

    }

    /*
        Q5. The string should be compressed such that consecutive duplicates of character are replaced with the character and followed by the number of consicutive duplicates.

        input = aaab4bbccdde
        output = a3b4c2d3e

     */

    static void  stringCompression(String s){

        String ans = "" + s.charAt(0);
        int count = 1;

        for(int i =1 ; i<s.length();i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            if( curr == prev){
                count++;
            }else{
                if(count >1)  ans += count;
               
                count = 1;
                ans += curr;
            }
        }
        
        if(count >1)  ans += count;
        System.out.println(ans);
    }

    public static void main(String[] args) {
        String str  ="aaaabbbbcba";
        allSubstring(str);

        System.out.println("\n ");
        Scanner sc = new Scanner(System.in);

        // Input of stringBuilder 

        StringBuilder s1 = new StringBuilder(sc.nextLine());

        toggleString(s1);

        System.out.println(s1);

        palindromicSubstring(str);

        reverseWordInSentence(s1.toString());

        stringCompression(str);

    }
}
