package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class Advance_Sorting_Algo_07 {



    static void displayArr(int[] arr){
        for (int i : arr) {
        System.out.print(arr[i] +" ");
    }
    }

    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;

        for( int i=0 ; i<arr.length ;i++){
            if( arr[i] > max){
                max = arr[i];
            }
        }
        return max;
       
    }

    //  Count Sort Algorithm : It's a non comparision base algorithm , it is used when range of number is defined.
    // Not a inplace algorithm : we uses extra memory.
    // Time complexity : O(n+k) ,k is max number
    // Space Complexity : o(n+k)

    static void basicCountSort(int[] arr){
        // find the largest element of the array :
        
        int max = findMax(arr);

        // make frequency array :

        int[] countf  = new int[max+1];
        for(int i = 0 ; i< arr.length ; i++){ // arr : 2,4,2,4
            countf[arr[i]]++ ; 
        }

        int  k =0 ;

        for(int i=0 ; i<countf.length ; i++){
            for(int j=0 ; j<countf[i]; j++){
                arr[k++] = i;
            }
        }

    }

    static void countSort(int [] arr){
        int n = arr.length;
        int[] output = new int[n];


        int max = findMax(arr); // find largest number in the arr.
        int[] count =  new int[max+1];

        for(int i=0; i<arr.length ;i++){ // make frequency array 
            count[arr[i]]++;
        }

        // make prefix sum of array of count array :
        for(int i =1 ; i<count.length ; i++){
            count[i] += count[i-1];
        }

        // find the index of each element in the original array and put it in output array.

        for(int i= n-1; i>=0 ; i--){ // taraversing from backword direction for maintaining the stability .
            
            int idx = count[arr[i]]-1;
            output[idx] = arr[i];
            count[arr[i]]--;
        }
        // copy all element of output to arr :
        for(int i=0 ; i<n ; i++){
            arr[i] = output[i];
        }


    }
   
   
//    Radix Sort : this is also non comparison sort 
//                 digit by digit sorting
//                 
//  How to calculate at some place what number is => number = (digit/place)%10



    static void countSortRadix(int [] arr,int place){



        int n = arr.length;
        int[] output = new int[n];

        int[] count =  new int[10];

        for(int i=0; i<arr.length ;i++){ // make frequency array 
            count[(arr[i]/place)%10]++;
        }

        // make prefix sum of array of count array :
        for(int i =1 ; i<count.length ; i++){
            count[i] += count[i-1];
        }

        // find the index of each element in the original array and put it in output array.

        for(int i= n-1; i>=0 ; i--){ // taraversing from backword direction for maintaining the stability .

            int idx = count[(arr[i]/place)%10]-1;
            output[idx] = arr[i];
            count[(arr[i]/place)%10]--;
        }

        // copy all element of output to arr :

        for(int i=0 ; i<n ; i++){
            arr[i] = output[i];
        }


    }
    static void radixSort(int[] arr){
        int max = findMax(arr);
        // apply counting sort to sort element based on place value

        for(int place=1 ; max/place>0 ; place *= 10){
            countSortRadix(arr, place);
        }
    }


    // Bucket Sort : Bucket sort is a sorting technique that involves dividing elements into various groups, or buckets. These buckets are formed by uniformly distributing the elements. Once the elements are divided into buckets, they can be sorted using any other sorting algorithm. Finally, the sorted elements are gathered together in an ordered fashion.

    /*  Steps : 1 .  Put all elements in b no of buckets.
                2.  Sort each bucket individually .
                3.   Take out elements and join them.
    */

    //  Buckets are array of arrays. 
     
    // Question : Sort an array having numbers in range [0.0 ,1.0] with uniform distribution . find efficient way to sort this .

  static void bucketSort(float[] arr){

       int n = arr.length;

     // Buckets : we are making n buckets , n  = arr.length 

       ArrayList<Float>[] buckets = new ArrayList[n]; 

    // Create empty buckets 

    for(int i = 0 ; i< n ; i++){
        buckets[i]  = new ArrayList<Float>();
     }

    //  Add elements into our buckets .

    for(int i = 0 ; i<n ; i++){
        int bucketIndex = (int) arr[i] * n;
        buckets[bucketIndex].add(arr[i]);
    } 

    // sort each bucket individually :

    for(int i = 0 ; i< buckets.length ; i++){
         Collections.sort(buckets[i]);
    }

    // Merge all buckets to get final sorted arrays:

    int index = 0;
    for(int i = 0 ; i< buckets.length ; i++){
        ArrayList<Float> currBucket = buckets[i];
        for(int j = 0 ; j<currBucket.size() ; j++){
            arr[index++] = currBucket.get(j);
        }
    }
    

  }



    public static void main(String[] args) {

    float[] arr = {0.5f,0.4f,0.3f,0.2f,0.1f};
    // countSort(arr);
    // System.err.println("Storted array by count sort :");
    // radixSort(arr); 
    System.err.println("Storted array by bucket sort :");
    bucketSort(arr);
    // displayArr(arr);
    for(float val : arr){
        System.out.print(val + " ");
    }

   }
}
