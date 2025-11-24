package Sorting;

public class MergeSort_05 {
    // Merge Sort : It uses divide and conquer apprach.
    // 1. Divide the array into 2 equal halves.
    // 2. sort the 2 subarrays separately using recursions.
    // 3. Merge the 2 sorted subarray to create an overall sorted array

    // TC =O(nlogn) == Worst , avg , and best case also.
    // Sc = O(n)
    // Inplace algo.

    static void displayarr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    static void mergeSortA(int[] arr, int l, int r) {
        if (l >= r) { // base case
            return;
        }
        int mid = (l + r) / 2;

        mergeSortA(arr, l, mid); // individually sort ho gye
        mergeSortA(arr, mid + 1, r); // individually sort ho gye
        merge(arr, l, mid, r);
    }

    static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1; // size of left array
        int n2 = r - mid; // size of right array
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i, j, k;

        for (i = 0; i < n1; i++) { // filling left array
            left[i] = arr[l + i];
        }
        for (j = 0; j < n2; j++) { // filling right array
            right[j] = arr[mid + 1 + j];
        }

        // now merging

        i = 0;
        j = 0;
        k = l;

        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        // if j is out of bounds then
        while (i < n1) {
            arr[k++] = left[i++];
        }
        // if i is out of bounds then
        while (j < n2) {
            arr[k++] = left[j++];
        }

    }

    public static void main(String[] args) {
        int[] arr = { 21, 4, 15, 2, 6, 1, 0 };
        int n = arr.length;
        System.out.println("\nArray before sorting :");
        displayarr(arr);

        mergeSortA(arr, 0, n - 1);
        System.out.println("\nArray after array :");
        displayarr(arr);
    }
}
