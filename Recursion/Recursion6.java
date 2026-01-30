package Recursion;

import java.util.Scanner;

public class Recursion6 {

    // Given an array , print all its values recursively.
    // we are using idx for traversing array .

    static void printarr(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }
        System.out.print(" " + arr[idx]);
        printarr(arr, idx + 1);
    }

    // Print the max valuse of the array [3,10,3,2,5] = TC O(n) , SC O(n)

    static int max(int[] arr, int idx) {
        // base case
        int n = arr.length;
        if (idx == n - 1) {
            return arr[idx];
        }
        // Small problem or recursive work
        int smallAns = max(arr, idx + 1);
        // self work
        return Math.max(arr[idx], smallAns);
    }

    // Find the sum of the elements of the array [2,34,56,2,4]

    static int sumOfArr(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }

        int smallans = sumOfArr(arr, idx + 1);
        return arr[idx] + smallans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter n :");
        int n = sc.nextInt();

        System.out.println("enter elements of arrray");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printarr(arr, 0);

        System.out.println("\nMaximum of the array : " + max(arr, 0));
        System.out.println("\nSum of the array : " + sumOfArr(arr, 0));

    }
}
