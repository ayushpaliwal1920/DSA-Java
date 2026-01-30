package Searching;

public class BInarySearch_3 {

    // Patterns on Binary Search : 1. Binary Search to find Peak Element , 2. Binary Search on 2d Matrix

    /*
    Q1 : Search the 'target' value in a 2d integer matrix of dimensions n *m and return true if found , else return false.
    
    1.Integeres in each row are sorted from left to right .
    2.the first integer of each row is greater than the last integer if the previous row.    

    By pattern : row number = i/m and column number = i%m , where m = number of columns and i is arbitary index.

    or r = (rm+c)/m  and  c = (rm+c)%m , where m = number of columns.

    */ 

    static boolean searchMatrix(int[][] a , int target){
        int n = a.length; // number of rows
        int m = a[0].length ; // number of columns

        int st = 0 , end = n*m -1;

        while(st<=end){
            int mid = st + (end -st)/2;

            int midElement = a[mid/m][mid%m]; // imp line

            if(midElement == target){
                return true;
            }
            else if(target < midElement){
                    end = mid+1;
            }else{
                st = mid +1;
            }

        }
        return false;

    }

    /*
    Q2 : Leetcode 240
    Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.
    */

     static boolean searchMatrix2(int[][] a, int target) {
       int n = a.length;
       int m = a[0].length;
    int i=0;
    int j = m-1;

    while(i<n && j>=0){
        if(a[i][j] == target){
            return true;
        }
        if(target < a[i][j]){
             j--; // move left
        }else{
            i++; // move downwards
        }
    }

    return false;
}

/*
    Pattern Peak Elements :  leetcode 852

    You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

    Return the index of the peak element.

    Your task is to solve it in O(log(n)) time complexity.
*/
    static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int st = 0 , end = n-1;
        int ans = -1;

        while(st <= end){
            int mid = st + (end-st)/2;

            if( arr[mid] < arr[mid+1]){
                st = mid+1 ;
                ans = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }

/*

Q3 . A peak element is an element that is strictly greater than its neighbors.

     Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

     You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

     You must write an algorithm that runs in O(log n) time.*/

        static int findPeakElement(int[] arr) {
        int n = arr.length;
        int st=0 , end = n-1;
        
        while( st<= end){
            int mid = st + (end - st)/2;
            if( (mid == 0 || arr[mid] > arr[mid-1]) && (mid == n-1 || arr[mid] > arr[mid+1])){ return mid ;} // presidence && is greater than ||

            if( arr[mid] < arr[mid+1]){
                st = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1 ;
    }
    public static void main(String[] args){
        int[] a ={1,2,3,4,3,2,0};
        findPeakElement(a);
    }
    
}
