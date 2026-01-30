package Recursion;


import java.util.Scanner;

// time Complexity =>  no of recursive calls * time taken in 1 call.

public class Recursion2 {

 // Factorial using recursion => time complexity = n * c(time) =  O(n) = space complexity

    static int factorial(int n){

        if( n== 0 ) return 1;

         int fact = n* factorial(n-1);
         return fact;
}

// print fibonacci number of fibbbo series : time complexity = O(2^n) , space complexity = O(n)


  static int fibbo(int n){

    if( n==0 || n==1 ){
        return n ;
    }

    // sub problem =/ 0,1,2,3,5,8,13....=> curr  = prev + prevPrev

    int fib = fibbo(n-1) +  fibbo(n-2);

    return fib;
    


  }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number for factorial :");
        int n = sc.nextInt();

     // System.out.println("factorial of n=" + n + " is : " +factorial(n));
        System.out.println("fibonacci series of n=" + n + " is : " + fibbo(n));
             
    // fiboo series => optional print
    
        for(int i=0 ; i<=n ; i++){ 
            System.out.print(" " + fibbo(i));
        }
        
    }
}
