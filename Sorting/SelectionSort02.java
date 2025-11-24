package Sorting;

import java.util.Scanner;

public class SelectionSort02 {

    // Selection Sort : selects an element and puts its correct position.
    // TOC = o(n^2)

    // Selection sort is not a stable algorithm.
    // It is also a InPlace algorithm(no extra space is required.)

    static void selectionSortA(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) { // i represents the current index

            // find mininimim element in unsorted part of the array.

            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // swap current element and minimum element // a[min_idx] & a[i]
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 5, 6, 4, 3 };
        selectionSortA(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
