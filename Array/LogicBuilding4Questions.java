package Array;

import java.util.Scanner;

public class LogicBuilding4Questions {

static void printArray( int[] arr ){
    int n = arr.length;
    for(int i = 0 ; i<n ; i++){
        System.out.print(arr[i] +" ");
    }
    System.out.println();
}
 
static void swaptwo(int [] arr , int left , int right){
    int temp ;
    temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
}




   //  Q1. Sort an arrray consisting of only 0s and 1s

  static void sortArray(int[] arr ) {
    int n = arr.length;
    int zeroes = 0 ;

    for( int i = 0 ; i<n ; i++){
        if( arr[i] == 0){
            zeroes++;
        }
    }
    System.out.println("number of zeroes in given array :" +  zeroes);

    for(int i = 0 ; i<n ; i++){
        if( i <  zeroes){
            arr[i] = 0;
        }
        else{
            arr[i] = 1;
        }
    }
  }

  // Q2 . PATTERN: TWO POINTER

  //    sort an array consisting of only 0s nad 1s

  static void sortZeroesAndOnceArray2(int[] arr ) {
    int n = arr.length;
    int left = 0  ;
    int right = n-1;
    while ( left<right){
        if(arr[left]==1 && arr[right]==0){
            swaptwo( arr,left,right);
                        left++;
                        right--;
                    }
                    if( arr[left]== 0 ){
                        left++;
                    }
                    if( arr[right]==1){
                        right--;
                    }
                }
}

// Q .3 given an array of integers"a",move all the even integers at the beginning of the array followed by all the odd integers.the relative order of odd or even integers does not matter . return any array that stisfies the condition.

static void sortEvenOdd(int[] arr) {
    int n = arr.length ;
    int left = 0 ,right = n-1 ;
     
    while( left<right){
        if( arr[left]%2 != 0 && arr[right]%2 == 0 ){
            swaptwo(arr,left,right);
            left++;
            right--;
        }
        if( arr[left]%2==0){
            left++;
        }
        if( arr[right]%2 != 0){
            right--;
        }    
    }
}

// Q. 4 given an integer 'a' sorted in non decreasing order, return an array of the squares of each number sorted in non decreasing order.

static int[] sortsquares(int[] arr){
    int n = arr.length;
    int left = 0 , right = n-1;
    int ans[] = new int[n];
    int k = 0 ;

    while(left<=right){
        if(Math.abs(arr[left]) > Math.abs(arr[right])){
            ans[k++] = arr[left]*arr[left];
            left++;
        }else{
            ans[k++] = arr[right] * arr[right];
        }
    }
    return ans;
}

              

                @SuppressWarnings({ "resource" })
    public static void main(String[] args) {
    Scanner Sc = new Scanner(System.in);
  
     System.out.println("enter array size :");
     int n = Sc.nextInt();
     int[] arr = new int[n];

     System.out.println("enter elements of array :");
     for(int i =0 ; i<n ; i++){
        arr[i] = Sc.nextInt();
     }

    System.out.println("the original array is :");
    printArray(arr);
    // sortArray(arr);
    // System.out.println("soted array if it contains only zeroes and ones :");
    // printArray(arr);
    // System.out.println("another swaping method :");
    // sortZeroesAndOnceArray2(arr);
    // printArray(arr);
    System.out.println("sort even odd");
    sortEvenOdd(arr);
    printArray(arr);
    int[] squarearray = sortsquares(arr);
    System.out.println("squared array");
    printArray(squarearray);
    // kx to error h baad mai dhund lena
}
}
