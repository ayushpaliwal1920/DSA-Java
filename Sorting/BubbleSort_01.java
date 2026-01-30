package Sorting;

import java.util.Scanner;

public class BubbleSort_01 {

    // Bubble sort : TOC = O(n^2)

    static void bubbleSort(int[] arr) {
        int n = arr.length;

        // n-1 iterations// passes.
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                /*
                 * last i elements are already at correct sorted positiions, so no need to check
                 * them.
                 */
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Bubble sort : Optimized :TOC =O(n^2) worst case , best case : O(n)

    static void bubbleSortOpt(int[] arr) {
        int n = arr.length;

        // n-1 iterations// passes.
        for (int i = 0; i < n - 1; i++) {
            Boolean flag = false; // has any swapping happened
            for (int j = 0; j < n - i - 1; j++) {

                /*
                 * last i elements are already at correct sorted positiions, so no need to check
                 * them.
                 */
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }

            if (flag == false) {
                return;
            }
        }
    }

    // Stable and Unstable sort algorithm :
    // stable array : order of apperarence of duplicate elements after sorting will
    // be same.
    // but unstable sort does not gaurantee that they will be in same order as
    // before.

    // Bubble sort is a stable sort algorithm.

    // In place algorithms : jo same hi array pr operations perform krti hai .
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        int[] arr = { 62, 52, 23, 552, 22 };
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
