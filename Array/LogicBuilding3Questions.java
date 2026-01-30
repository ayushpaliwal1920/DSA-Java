package Array;

import java.util.Scanner;

public class LogicBuilding3Questions {
 
    // Q. find the total number of pairs in the array whose sum is equal to the given value.
    
 static int pairsum( int[] arr , int target)
 {
     int n = arr.length;
     int ans = 0;

     for( int i =0 ; i< n ; i++){
        for(int j= i+1 ; j< n ; j++){
            if(  arr[i] + arr[j] == target){
                ans++;
            }
        }
     }
     return ans ;

 }

 // Q. count the number of triplets whose sum is equal to given valiue x
 
 static int tripletsum( int[] arr , int target){
    int n = arr.length;
    int ans = 0 ;
   
    for( int i = 0 ; i<n ; i++){
        for(int j = i+1 ; j<n ; j++){
            for(int k = j+1 ; k<n ; k++){
                if(arr[i] + arr[j]+ arr[k] == target){
                    ans++;
                }
            }
        }
        
    }
    return ans;
 }

 //   arrray manuplation

 // Q. find the unique number in a given array where all the elements are being repeated twice with one value being unique(only positive number is in array)
 
static void findunique( int[] arr){
    int unq = 0  ;
    int n = arr.length; 
    for(int i = 0 ; i<n ; i++){
        for(int j = i+1 ; j<n ; j++){
            if( arr[i] == arr[j]){
                arr[i] = -1;
                arr[j] = -1; 
            }
        }
    }


    for(int i = 0 ; i<n ; i++){
        if( arr[i] != -1){
             unq = arr[i];
        }
       }
    System.out.println(unq);
}

// Q. find the second largest element in the given array

static int findMax( int[] arr){
    int max = Integer.MIN_VALUE ;
    for(int i=0 ; i< arr.length; i++){
        if (arr[i] > max){
            max = arr[i];
        }
    }System.out.println("Inside pairsum method");
System.out.println("Inside tripletsum method");
System.out.println("Inside findunique method");
System.out.println("Inside findMax method");
System.out.println("Inside SecondMax method");
    return max;
}

static int SecondMax( int[] arr){

    // find max 
    // mark all maximun as integer_minvalue
    // find maximum which is second largest
    int max = findMax(arr);

    for(int i = 0 ; i < arr.length ; i++){
        if( arr[i] == max){
         arr[i] = Integer.MIN_VALUE ;
        
        }  
      }
      int secondMax = findMax(arr);
      return secondMax ;
}

// Q. give an arraay a consisting ofintegers .return the first that is repeating in this array.if no values is being repeated return -1.

static int findRepeat (int[] arr){
    int n = arr.length;
   
     for( int i =0; i<n ; i++){
        for( int j= i+1 ; j<n ; j++){
            if( arr[i] == arr[j] ){
                return arr[i];
            }
        }
     }
     return -1;

}

 @SuppressWarnings({ "resource" })
public static void main(String[] args) {
    Scanner Sc = new Scanner(System.in);
    System.out.println("enter sizee of array :");
    int n = Sc.nextInt();
    int[] arr = new int[n];

    System.out.println("enter " +n +"elements");
    for(int i = 0; i<n; i++){
        arr[i] = Sc.nextInt();
    }
    System.out.println("enter target sum");
    int target = Sc.nextInt();
    System.out.println(pairsum(arr, target));
    System.out.println(tripletsum(arr, target));
    findunique(arr);
    System.out.println(findRepeat(arr));
}


    
 }


