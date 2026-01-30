package Sorting;

public class ProblemsOnSort1_04 {

    // Q1 : Given an integer array arr,move all 0's to the end of it while
    // maintaining the relative order off the non -zero elements.

    // Note that you must do this inplace without making copy of the array.

    static void moveZeroes(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] == 0 && arr[j + 1] != 0) {
                    // swap arrr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    // Q2 : Give an array of names of the fruits ; you are supposed to sort it in
    // lexicographical order(Dictionary) using the selection sort.
    // Input : ["papaya","lime","watermelon","apple","mango","kiwi"].
    // Output : ["apple","kiwi","lime","mango","Papaya","watermelon"].
    // we will use compareTo() method to compare two strings.It returns number as a
    // return type if s1<s2 => -ve ,s1>s2=> +ve , s1=s2 => returns 0.

    static void sortFruits(String[] fruits) {
        int n = fruits.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (fruits[j].compareTo(fruits[min_idx]) < 0) {
                    min_idx = j;
                }
            }
            // swap fruits[min_idx], fruits[i]
            String temp = fruits[i];
            fruits[i] = fruits[min_idx];
            fruits[min_idx] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 0, 2, 35, 5, 0 };
        String[] fruits = { "apple", "banana", "papaya", "orange", "kiwi", "avacado", "pear" };
        // moveZeroes(arr);
        sortFruits(fruits);

        for (String val : fruits) {
            System.out.print(val + " ");
        }

    }
}
