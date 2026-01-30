package Searching;

public class BinarySearch_2 {

    /*  PROPERTIES OF ROTATED SORTED ARRAYS. :
            1.Before rotation, the array is strictly increasing
            2.There is exactly one index i where:
                 arr[i] > arr[i + 1]
                 This index is the pivot (rotation point). 
            3. two sorted parts in the array .
                means x to mid or mid to y .
                either both part will be sorted , or either one part will be soted and another part unsorted but both part will never be unsorted .
            
    */


    // Questions on Binary seaarch most imp patterns.=>    Roated search pattern.

    /*
     Q1 : A rotated sorted array  is a sorted array on which rotation operation has been performed some number of times. Given a rotated sorted array , find the index of the mininum element in the array or find the index of the pivot element. Follow 0 based indexing.

     It is guarenteed that all the elements in the array are unique.
    */

     static int findmin(int[] a){
            int st = 0 ;
            int end = a.length -1;
            int ans = -1;
            while( st<= end){
                int mid = st + (end-st)/2;

                if(a[mid] <= a[end]){
                   ans = mid;
                   end = mid-1;
                }else{
                    st = mid+1;
                }
            }
            return ans;
     }
    
     /*
     Q2 : Given a rotated sorted array of integers, which contains distinct elements and an integer target, return the index of target if it is in the array . Otherwise return -1
     */

     static int search(int[] arr, int target){
        int st = 0 ;
        int end = arr.length -1;
        int ans = -1;

        while(st<= end){
            int mid = st + (end -st)/2;

            if( arr[mid] == target){

                return mid;

            }else if( arr[mid] < arr[end]){ //  mid to end sorted array by the property of the rotated sorted array.
                if( target <= arr[end] && target > arr[mid]){
                    st = mid+1;
                }else{
                    end = mid-1;
                }
            }else{ // start to mid will be sorted array because of property of the roated sorted array.
                if( target >= st && target < arr[mid]-1){
                    end = mid-1;
                }else{
                    st = mid +1;
                }
            }
        }
            return -1;
     }

     /*
     Q3: Search element in rotated sorted array with duplicate elements. Return true if the elements is found else return false.
      */

    //  work on duplicate elements as well.

     static int searchWhenDuplicate(int[] arr, int target){
          int st = 0 ;
        int end = arr.length -1;
        int ans = -1;

        while(st<= end){
            int mid = st + (end -st)/2;

            if( arr[mid] == target){

                return mid;

            }else if(arr[st] == arr[mid] && arr[end] == arr[mid]){
                st++;
                end--;
            }
            else if( arr[mid] <= arr[end]){ //  mid to end sorted array by the property of the rotated sorted array.
                if( target <= arr[end] && target > arr[mid]){
                    st = mid+1;
                }else{
                    end = mid-1;
                }
            }else{ // start to mid will be sorted array because of property of the roated sorted array.
                if( target >= st && target < arr[mid]-1){
                    end = mid-1;
                }else{
                    st = mid +1;
                }
            }
        }
            return -1;
     }
      
     public static void main(String[] args) {
        int[] a = {3,4,5,1,2};
        int[] b = {1,1,1,1,1,1,2,3,1,1};
        int target = 1;
        int target2 = 2;
        System.out.println(findmin(a)); // getting index of minimum element.
        System.out.println(search(a, target));
        System.out.println(searchWhenDuplicate(b, target2));
     }
}
