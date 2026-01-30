package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion7 {

    static void printarr(int[] arr , int idx){
        if (idx == arr.length) {
            return;
        }
        System.out.print(" " + arr[idx]);
        printarr(arr, idx+1);
    }


    //  Given an array of n integers and a target value x , Print whether x exists in the array or not.

    static boolean linearSearch(int[] arr , int idx  , int target){
      
        // base case
        if(idx >= arr.length){
            return false;
        }
        // self work 
        if(arr[idx] == target){
             return true;
        }
        //  recursive work
        return linearSearch(arr, idx+1, target);

    }

    // find first index return index of array of element of target present in the array otherwise retutn -1

     static int findIndex(int[] arr , int idx  , int target){
      
        // base case
        if(idx >= arr.length){
            return -1;
        }
        // self work 
        if(arr[idx] == target){
             return idx;
        }
        //  recursive work
        return findIndex(arr, idx+1, target);

    }

    // 

    // Given an array of size N and an integer X . The task is to find all the indices of the integer X in the array.

    static void  findAllIndices(int[] arr , int idx , int target){
        //  base caseint n 

        if (idx >= arr.length) {
            return;
        }
        // self work
        if(arr[idx] == target){
            System.out.println(idx);
        }
        // recursive work
        findAllIndices(arr, idx+1, target);
    }


    // Given an array of size N and an integer X . The task is to find all the indices of the integer X in the array.
    // store all indices in the arraylist and return an arraylist.


    static ArrayList<Integer>  findAllIndicesArrlst(int[] arr , int idx , int target){
        //  base case

        if (idx >= arr.length) {
            return new ArrayList<Integer>();  // returns empty arraylist 
        }

        // self work
        ArrayList<Integer> ans = new ArrayList<>();

        if(arr[idx] == target){
            ans.add(idx);
        }

        // recursive work
        ArrayList<Integer>smallAns = findAllIndicesArrlst(arr, idx+1, target);
        ans.addAll(smallAns);
        return smallAns;
    }


    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("enter n :");
        int n = sc.nextInt();

        System.out.println("enter elements of arrray");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the value u want ot search : ");
        int target = sc.nextInt();
        
        printarr(arr, 0);

        

        // if (linearSearch(arr, 0, target)) {
        //     System.out.println("\nFound");
        // }else{
        //     System.out.println("\nNot Found");
        // }

        // findAllIndices(arr, 0, target);

        ArrayList<Integer> ans = findAllIndicesArrlst(arr,0,target);
        // print arraylist
        for(Integer i:ans){
            System.out.println(i);
        }
    }
}
