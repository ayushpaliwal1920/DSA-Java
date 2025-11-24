package Sorting;

public class QuickSort_06 {



    static void displayArr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // Quick Sort using Divide and Conquer
    static void quicksort(int[] arr, int st, int end) {
        if (st >= end) return;

        int pi = partition(arr, st, end);
        quicksort(arr, st, pi - 1);
        quicksort(arr, pi + 1, end);
    }

    static int partition(int[] arr, int st, int end) {
        int pivot = arr[st];
        int count = 0;

        // Count how many elements ≤ pivot
        for (int i = st + 1; i <= end; i++) {
            if (arr[i] <= pivot) {
                count++;
            }
        }

        int pvtIdx = st + count;
        swap(arr, st, pvtIdx);  // move pivot to correct position

        int i = st, j = end;

        // Place smaller elements left, larger right
        while (i < pvtIdx && j > pvtIdx) {
            while (arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;

            if (i < pvtIdx && j > pvtIdx) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        return pvtIdx;
    }

    public static void main(String[] args) {

        int[] arr = {1, 25, 36, 0, 14, 25, 55};

        System.out.println("Array before sorting:");
        displayArr(arr);

        quicksort(arr, 0, arr.length - 1);

        System.out.println("Array after sorting:");
        displayArr(arr);
    }
}
