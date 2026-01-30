package Sorting;

public class ProblemsOnSort2_08 {

    static void displayArr(int[] num){
        for( int val : num){
            System.out.print(val + " ");
        }
    }
static void swap(int[] arr , int x, int y){
  int temp = arr[x];
  arr[x] = arr[y];
  arr[y] = temp ; 
}

  

    /*Q1. Give an array where all its elements are sorted in increasing order except two swapped elements ,sort it in linear time . Assume there are no duplicates in the array.
    ex : input : A[] = [3,8,6,7,5,9,10] , output : A[] = [3,5,6,7,8,9,10]
    */

    static void sortArr1(int[] num){
        int n = num.length;

        if(n <=1 ){
            return;
        }

        int x = -1 , y = -1 ;
        // process all adjecent elements 
        for(int i=1 ; i< n ; i++){
            if(num[i-1] > num[i]){
                if(x == -1){ // first conflict
                    x = i-1;
                    y = i;
                }else{  // 2nd conflict
                    y = i;
                }
            }
        }
        // swap 
        int temp = num[x];
        num[x] = num[y];
        num[y] = temp ;
    }

    /*  Q2 : Given an array of positive and negative integers , segregate them in linear time and constant space .The output should print all negative numbers , followed by all positive  numbers.
    Input : [19,-20,7,-4,13,11,-5,3] , Output : [-20,-4,-13,-5,7,11,19,3]
    */

    static void sortArr2(int[] arr){
        int l = 0;
        int r = arr.length -1 ;

        while( l < r){
            while(l<r && arr[l] < 0) l++;
            while(l<r && arr[r] >= 0) r--;

            if( l< r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp ;
                l++;
                r--;
            } 

        }

    }

    /*  Q3 : Give an array of size N containing only 0s , 1s , 2s sort the array in ascending order.
        Input : N =6 arr = {0,2,1,2,0,0} Output {0,0,0,1,2,2}
    */

        // We will use count sort because it works better when range of  numbers are given.

        // method 1 = sortArr3_1 : it takes two passes
        // method 2 = sortArr3_2 : it takes only one pass to do sorting

        static void sortArr3_1(int [] arr ){
            int count_0 = 0 , count_1 = 0 , count_2 =0 ;
            for(int j : arr ){
                if( j ==0 ){
                    count_0++;
                }else if( j ==1){
                    count_1++;
                }else{
                    count_2++;
                }
            }
            int k=0;
            while(count_0 > 0){
                arr[k++] = 0;
                count_0--;
            }
            while(count_1 > 0){
                arr[k++] = 1;
                count_1--;
            }
            while(count_2 > 0){
                arr[k++] = 2;
                count_2--;
            }
        }

        static void sortArr3_2(int[] arr){
            int low = 0 , mid=0 ;
            int high = arr.length - 1;

            // explore thr unknown region 
            while( mid < high){
                if(arr[mid] == 0){
                    swap(arr,mid,low);
                    mid++;
                    low--;
                }
                else if(arr[mid] == 1){
                    mid++;
                }else{
                    swap(arr, mid, high);
                    high--;
                }
            }
        }

    public static void main(String[] args){
        int[] num = {10,5,6,7,8,9,3};
        System.out.println("SSorted array1 :");
        sortArr1(num);
        displayArr(num);

        int[] num2 = {-1,2,6,4,-1,-22};
        System.out.println("\nSSorted array2 :");
        sortArr2(num2);
        displayArr(num2);
    }
}