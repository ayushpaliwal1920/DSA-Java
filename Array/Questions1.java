package Array;

import java.util.Scanner;


// sare mehtods static banane ka karan ye h ki static fxn ko kvl static fxn hi calll kr skta chunki main fxn static h isliye humne sare methos static bananye ki hum unko access kr ske
// same goes for variables


public class Questions1 {
    
//Q1. count number of occurence in array of a element x
static int countElement(int[] arr , int x){

    int count = 0;
    for(int i = 0 ; i<arr.length ; i++){
        if (arr[i] == x){
            count++;
        }
    }
     return count ;
}

// Q2. find last occurence of element in given array

static int lastOccurence(int[] arr , int x){
    int lastIndex = -1;
    for(int i=0; i< arr.length ; i++){
        if(arr[i] == x){
            lastIndex = i;
        }
    }
    return lastIndex;

}

// Q3.  find first occurence of element in given array 


static void numOfgreater(int[]arr , int x){
    int greater = 0 ;
     for(int i = 0 ; i< arr.length ; i++){
        if( arr[i] > x){
            greater++;
            System.out.println(arr[i] + " at index "+ i);
        }
     }
    System.out.println("number of greater elements is" + greater);

}

// Q4. check given array is sorted or not

 static boolean isSorted(int[] arr){ // increasing order
    boolean check = true;

    for(int i = 1 ; i<arr.length ; i++){
         if( arr[i] < arr[i-1] ){
            // not sorted;
            check = false ;
            break ;
         }
       
    }
    return check;
 }

 // create an array which firs index has smallest value of passes array and second value is largest value of passed array

 static int[] smallestAndLargestValue(int[] arr ){

    // large way to do it

    int smallest = 0;
    int largest = 0;
    int[] arr2 = new int[2];
    for(int i = 0 ; i<arr.length ; i++){
        if( arr[i] <= smallest){
            smallest = arr[i];
        }
    }
    arr2[0] = smallest;
    for(int i = 0 ; i<arr.length ; i++){
        if( arr[i] >= largest){
            largest = arr[i];
        }
    }
    arr2[1] = largest;

    System.out.println("new array is :");
    for(int i= 0 ; i<arr2.length ; i++){
        System.out.print(arr2[i] + " ");
    } 
 

    return arr2 ;
    
 }
@SuppressWarnings({ "resource" })
public static void main(String[] args) {

     System.out.println("enter elements of array :");
     Scanner Sc = new Scanner(System.in);
    int n = Sc.nextInt();
     
    int[] arr = new int[n];

        System.out.println("enter elements of array :");
        for(int i = 0; i<arr.length ;i++){
            arr[i] = Sc.nextInt();
        }
    
        for(int i=0 ; i< arr.length ; i++){
            System.out.print(arr[i] +" ");
        }
       System.out.println( "\n");
        System.out.println("enter target element :");
        int x = Sc.nextInt();
     
   
    int numberOfOCcurence = countElement(arr,x);
    System.out.println("number of occurence = " + numberOfOCcurence);

    System.out.println("enter number whose last indexx wee neeed");
    int y = Sc.nextInt();

    int Lastindex = lastOccurence(arr, y);
    System.out.println("last index of y="+ y + "  is  " +Lastindex);

    System.out.println( " enter element to compare :");
    int z = Sc.nextInt();
    System.out.println("number of elements and total number is");
    numOfgreater(arr, z);
    

    System.out.println("Checking the given array is sorted or not");
    boolean checking = isSorted(arr);
    System.out.println("is sorted :" +checking);

    System.out.println("array of smallest ans largest element of passed array");
    smallestAndLargestValue(arr);
}

}
