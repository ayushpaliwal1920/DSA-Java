package Array;

import java.util.Scanner;

public class LogicBuilding1Questions {

@SuppressWarnings("resource")
static void inputArray(){

    Scanner Sc = new Scanner(System.in);
    System.out.println("Enter number of elements  in the array");

    int n = Sc.nextInt();
    int[] arr = new int[n];

    System.out.println("enter array elements");
    
    // arr[0] = Sc.nextInt();
    // arr[1] = Sc.nextInt();5
    

    for(int i = 0 ; i< arr.length ; i++){
        arr[i] = Sc.nextInt();
    }

    System.out.println("array is : ");
    for(int i = 0 ; i< arr.length ; i++){
        System.out.print(arr[i] + " ");
    }
}

// Q1 . pint number of  pairs whose sum is x

static int findnoOfPairs(int[] arr , int x){  
    int ans=0;

    for(int i=0 ; i<arr.length ; i++){
        for(int j =1 ; j<arr.length ; j++){
            if( arr[i]+arr[j] == x){
               ans++;
            }
        }
    }
return ans;
}

//  Q2.  ccount the number of triplets whose sum is equal to x.

static int triplets( int[] arr , int x){
    int ans = 0 ;
    for(int i = 0 ; i< arr.length  ; i++){
        for(int j = i+1 ; j< arr.length ; j++){
            for( int k = j+1 ; k < arr.length ; k++){
                    if( arr[i]+arr[j]+arr[k] == x){
                        ans++;
                    }
            }
    }
}
    return ans;
}


// PATTERN : Array Manipulation

// Q.3 Find the unique number in a given array where all the elements are being repeated twice with one value being unique


static int uniqueNumber(int [] arr){
    int n = arr.length;

    for(int i = 0 ; i<n ; i++){
        for( int j = i+1 ; j<n ; j++ ){
            if(arr[i] == arr[j]){
                arr[i] = -1 ;
                arr[j] = -1 ;
        }
    }
}

int ans = -1;

for ( int i = 0 ; i< n  ; i++){
    if(arr[i] > 0 ){ // greater than 0 or not equal to -1
        ans = arr[i];
    }
}

return ans ;
}

// Q.4 find second max in an array 


static int findMax(int[] arr){
    int max = Integer.MIN_VALUE;
    for(int i = 0 ; i<arr.length ; i++){
        if( arr[i]> max){
              max = arr[i];
        }
    }
    return max;
}

static int secondMax(int[] arr){
    int max = findMax(arr);
   
    for( int i = 0 ; i< arr.length ; i++){
        if(arr[i] == max){
            arr[i] = Integer.MIN_VALUE;
        }
    }

    int SecMax = findMax(arr);
   
    return SecMax;
}

// Q.5 return the first value that is repeating in this array . If no value is being repeated returm -1.

static int firstRepeating(int[] arr){

    for(int i = 0 ; i< arr.length ; i++){
        for(int j = i+1 ; j<arr.length ; j++){
            if( arr[j] == arr[i]){
                return arr[i];
            }
        }
    }
    return -1;
    
}



  @SuppressWarnings( "resource" )
public static void main(String[] args) {
    Scanner Sc = new Scanner(System.in);

    System.out.println("enter target element:");
    int x = Sc.nextInt();
    
   
    System.out.println("Enter number of elements  in the array");

    int n = Sc.nextInt();
    int[] arr = new int[n];

    System.out.println("enter array elements");
    
    // arr[0] = Sc.nextInt();
    // arr[1] = Sc.nextInt();5
    

    for(int i = 0 ; i< arr.length ; i++){
        arr[i] = Sc.nextInt();
    }

    System.out.println("array is : ");
    for(int i = 0 ; i< arr.length ; i++){
        System.out.print(arr[i] + " ");
    }

    int ans = findnoOfPairs(arr, x);
    System.out.println("\n");
    System.out.println("numn=ber of pairs " +ans);

    int triplets = triplets(arr, x);
    System.out.println("number of teiplets :"+triplets);

    int unique = uniqueNumber(arr);
    System.out.println("unique number :" +unique);

    int SecMax = secondMax(arr);
    System.out.println("second max number :"+SecMax);

    int firstRepeating = firstRepeating(arr);
    System.out.println("first repeating number :"+firstRepeating);



}
}
