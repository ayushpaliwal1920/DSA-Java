package Sorting;

public class InsertionSort_03 {

    // Insertion Sort : Take one element from the unsorted part then iterate through the sorted part and find the correct position of the element.

    // toc : best case :O(n) , worst case : O(n^2)
    // It is a stable sort. and inplace algo.>NN

   static void insertionSortA(int[] arr){
         int n = arr.length;
         for(int i=1; i<n; i++){ // first element is part of a sorted list we assumes.
            // for(int j=i ; j>0 ; j--){
            //     if(arr[j]<arr[j-1]){
            //         int temp = arr[j];
            //         arr[j] = arr[j-1];
            //         arr[j-1] = temp;
            //     }
            // }  or

            int j = i;
            while ( j>0  &&  arr[j]<arr[j-1]) {
                int temp = arr[j];
                  arr[j] = arr[j-1];
                  arr[j-1] = temp;
                  j--;
            }     
            }     
         }
    public static void main(String[] args){
            int[] arr = {5,6,4,3,2,1};
            insertionSortA(arr);
            for(int i : arr){
                System.out.print(i + " ");
            }

    }
}
