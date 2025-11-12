package Recursion;

import java.util.Scanner;

public class Recursion1 {

    // Recursion : A function calling itself. with different parameters and a base
    // case .

    // in recursion we solve a bigger problem by solving smaller sub problems.

    //
    // Base case or halting condition = because it prevents from infinite recursion
    // sub problem
    // self work

    // Steps for recursion : 1. identify the smaller problem.let recursion solve it.
    // 2. self work
    // 3. Identify the base case : smallest problem for which ans is very obious.

    static void printIncreasingNum(int n) {

        if (n == 1) { // halting cndn
            System.out.println(n);
            return;
        }
        printIncreasingNum(n - 1); // sub problem
        System.out.println(n); // self work

    }

    // stack memory mai local variable , method call vgera hote hai and heap memory
    // mai objects bante hai.
    // jab ek method call hota hai to us method k corresponding ek nayi stack frame
    // banti hai.

    // write a program to print all natural numbers from n to 1 using recursion.

    static void printDecreasing(int n) {

        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDecreasing(n - 1);
    }

    public static void main(String[] args) {

        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter N :");
        int n = Sc.nextInt();
        // printIncreasingNum(n);
        printDecreasing(n);
    }

}
