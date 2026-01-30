package Searching;

public class BinarySearch_12 {

    //  Problems on Binary Search : 

    /*
    Q1. Find the fist Occurence of a given element x , given that the given array is sorted . If no Occurence found then return -1.
    */

    static int firstOccurence(int[] arr , int x){
        int st = 0 ; 
        int end = arr.length -1;
        int fo = -1;

        while( st <= end){

            int mid = st + (end-st)/2 ;

            if(arr[mid] == x){
                fo = mid;
                end = mid-1;
            }else if( x < arr[mid]){
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return fo;

    }

    /*
    Q2 : Find the square root of the given non negative value x. Round it off to the nearest floor intefer value.
    */

    static int findSquareRoot(int x ){
        int st = 0;
        int end = x;
        int ans = -1;
        while(st <= end){
            int mid = st + (end-st)/2;
            int val = mid * mid ; // use long here to avoid overflow
            if( val == x){
                return mid;
            }else  if(val < x){
                ans = mid;
                st = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,0,1,1,1,2,2,3,3,4,4,5,5,5};
        int x = 1;
        System.out.println("First Occurence at index :" + firstOccurence(arr, x));
    }
    
}
