package Recursion;

import java.util.Scanner;

public class Recursion4 {

    // Given a number num and a value k . Print k multiple of num.

    static void multiple(int num, int k) {

        // base case
        if (k == 1) {
            System.out.println(num);
            return;
        }
        // recursive work
        multiple(num, k - 1);
        // self work
        System.out.println(num * k);

    }

    // Given a number n . Find the sum of natural numbers till n but with alternate
    // signs.
    // that means if n=5 then you have to return 1-2+3-4+5 = 3 as your ans.

    static int seriesSum(int n) {
        if (n == 0)
            return 0;

        if (n % 2 == 0) {
            return seriesSum(n - 1) - n;
        } else {
            return seriesSum(n - 1) + n;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("enter number and k :");
        // int num = sc.nextInt();
        // int k = sc.nextInt();
        // multiple(num, k);

        System.out.println("Enter n :");
        int n = sc.nextInt();
        seriesSum(n);

    }
}
