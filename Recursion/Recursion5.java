package Recursion;

import java.util.Scanner;

public class Recursion5 {

    // Find GCD using reecursion : imp

    // Given two numbers x and y . find greatest common devisor(hcf) of x and y .

    static int longDevisionGCD(int x, int y) {

        while (x % y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return y;
    }

    // Euclid's theorem : gcd(x,y) = gcd(y , x % y) & gcd(x,0)

    static int gcd(int x, int y) {

        if (y == 0) {
            return x;
        }

        return gcd(y, x % y);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER x and y :");
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(longDevisionGCD(x, y));
        System.out.println(gcd(x, y));
    }
}
