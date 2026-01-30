package Recursion;

import java.util.Scanner;

public class Recursion3 {

    // Given an integer , find out the sumof its digits using recursion.= tc = sc =
    // O(n)

    static int sumOfDigits(int n) {

        // base case => single digit number

        if (n >= 0 && n <= 9) {
            return n;
        }
        int sum = sumOfDigits(n / 10) + n % 10;
        return sum;
    }

    // Return the count of digits in a given number n

    static int countOfDigites(int n) {

        if (n == 0) {
            return 0;
        }
        int count = 1 + countOfDigites(n / 10);
        return count;
    }

    // Given two numbers p & q , find the value p^q using a recursive function :

    static int findraise(int p, int q) {

        if (q == 0) {
            return 1;
        }
        int r = p * findraise(p, q - 1);
        return r;
    }

    // Given two numbers p & q , find the value p^q using a recursive function :
    // Alternate method

    static int findraiseAltrnt(int p, int q) { // TC = O(q)
        if (q == 0)
            return 1;

        int smallpow = findraiseAltrnt(p, q / 2);

        if (q % 2 == 0) { // even
            return smallpow * smallpow;
        } else { // odd
            return p * smallpow * smallpow;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter number n : ");
        int n = sc.nextInt();
        System.out.println("enter number m : ");
        int m = sc.nextInt();

        // System.out.println("Sum of digits of number n = " + n + " is " +
        // sumOfDigits(n));

        // System.out.println("Count of digits of number n = " + n + " is " +
        // countOfDigites(n));

        System.out.println("power of digits of number n ,m times is = " + findraise(n, m));

    }
}
