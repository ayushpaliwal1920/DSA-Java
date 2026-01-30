package Searching;

public class BinarySearch_1 {

    // Binary Search : this is a searching uses for sorted array.
    // Time complexity => O(log(n)) Binary search < O(n) linear search 
    // Space Complexity => O(1)

    static boolean binarySearch(int[] arr  , int target){
        int n = arr.length;

        int st = 0 , end = n-1;

        while (st <= end){
            // int mid = (st+end)/2; 

            // best way to find mid : we will use this because of range overflows

            int mid = st + (end - st)/2 ;

            if(target == arr[mid]){
                return true;
            }else if(target < arr[mid]){
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return false;
    }
    
    // REcursive binary Search : Time and Space = > O(logn) not a inplace algorithm

    static boolean recursiveBS(int[] arr, int st , int end , int target){
        // Base case : 

        if(st > end){
            return false;
        }
        int mid = (st + end)/2;

        if(arr[mid] == target){
            return true;
        }else if(target < arr[mid]){
            return recursiveBS(arr, st, mid-1, target); // subproblems
        }else{
            return recursiveBS(arr, mid+1, end, target); // subproblems
        }

    }
    public static void main(String[] args){
        int[] a = {1,3,5,9,15,25,30,34};
        int target = 0;
        while( target != 10){
            // System.out.printf("%d exists in arr : %b\n" , target, binarySearch(a, target));
            System.out.printf("%d exists in arr : %b\n" ,target, recursiveBS(a, 0, a.length - 1, target));
            target++;
        }
    }
}