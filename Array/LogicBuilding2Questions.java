// package Array;

// import  java.util.Scanner;

// public class LogicBuilding2Questions {


// SWW LEC 17 ARRAY 4 AGAIN.

// // Q.1 swap with and wihout temp  variable


//     static void swapwithtemp(int a , int b){

//         int temp ;
//         System.out.println("before swap a = "+a);
//         System.out.println("before swap b = "+b);

//         temp = a;
//         a = b;
//         b = temp;
//         System.out.println("after swap a = "+a);
//         System.out.println("after swap b = "+b);
//     }

//     static void swapwithouttemp(int a , int b){
    
//         System.out.println("swap without temp[]");    
//         System.out.println("before swap a = "+a);
//         System.out.println("before swap b = "+b);

//          a = a+b; // a == 1+3 = 4
//          b = a-b; // b == 4-3 = 1
//          a = a-b; // a == 4-1 = 3    
//         System.out.println("after swap a = "+a);
//         System.out.println("after swap b = "+b);
//     }


// // Q .2 Reverse an array consisting integer values

// static int[] reverseArray(int[] arr , int i , int j){

//     int n = arr.length;
//     int [] ans = new int[n];
   
//     for( i = n-1 ; i>=0 ; i--){
//           ans[j] = arr[i];
//           j++;           // or we can write arr[j++] = arr[i]
//     }

//     for( j = 0 ; j<n ; j++){
//         System.out.print(ans[j] + " ");
//     }
//     System.out.println();

//     return ans;

// }

// //  swap inside array 

// static void swapInarray(int[] arr , int i , int j ){
//     int temp = arr[i];
//     arr[i] = arr[j];
//     arr[j] = temp;

// }

// //  reverse without creating new space o r new array


// static void  reverseArrayWithoutnewArray(int[] arr) {
  
//     int i=0 , j = arr.length -1 ;

//     while(i<j){
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;

//         i++;
//         j--;
//     }

//   for(i = 0 ; i< arr.length ; i++){
//     System.out.print(arr[i] + " ");
//   }
//   System.out.println();
// } 

// // Q 4.. Rotate an array k times 

// // static int[] rotateArray(int[] arr , int k){
// // int n = arr.length;
// // k = k % n;
// // int[] ans = new int[n];
// // int j=0;

// // for( int i = n-k ; i<n ; i++){
// //     ans[j++]  = arr[i];
// // }

// // for( int i = 0 ; i < n-k ; i++){
// //     ans[j++] = ans[i];
// // }

// // return ans ;
// // }

// // Q 4.. Rotate an array k times without using extra space .

// @SuppressWarnings("unused")
// static void rotateinPlace(int[] arr , int k){

// int n = arr.length;

// reverseArray(arr , 0 , n-k-1);
// reverseArray(arr , n-k , n-1);
// reverseArray(  arr , 0 , n-1);














// }

//     private static void reverseArray(int[] arr, int i, int j) {
//      
//     throw new UnsupportedOperationException("Unimplemented method 'reverseArray'");
// }

//     @SuppressWarnings({ "resource" })
//     public static  void main(String[] args) {
//         Scanner Sc = new Scanner(System.in);

//     int a =9 ;
//     int b = 2 ;
//     int x = 45;
//     int y = 87;
//     swapwithtemp(a, b);
//     swapwithouttemp(x, y);
  
//     System.out.println("enter  the number of elements");
//     int n = Sc.nextInt();
//     int[] arr = new int[n];

//     for(int i = 0; i<n ; i++){
//         arr[i] = Sc.nextInt();
//     }
//     for(int i=0 ;i < n ; i++){
//         System.out.print(arr[i] + " ");
//     }

//     System.out.println(" reversed array is");
//     reverseArray(arr);

//     System.out.println("reverse without creating new space ");
//     reverseArrayWithoutnewArray(arr);


    
//     // System.out.println("enter how many times you want to rotate an array :" );
//     // int k = Sc.nextInt();
//     // System.out.println("rotated array :");
//     // int[] ans = rotateArray(arr, k);
    

// }
   
// }
