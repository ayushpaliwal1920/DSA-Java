package Array;
import  java.util.Scanner ;
public class LogicBuilding5Questions {

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
    
// Pattern :  Prefix sums

// let say prefix sum from 0 to 3 = means sum of all the values from index 0 to 3.

// Q.1  given an integer array 'a' return the prfix sum / running sum in the same array without creating a new array

static int[] prefixSum(int[] arr){

    int n = arr.length ;
    int [] prefix =  new int[n];
    prefix[0] = arr[0];
    for(int i = 1 ; i<n ; i++){
        prefix[i] = prefix[i-1]+arr[i];
    }
 return prefix;
}

// same prefix sum wirhout creating a new array .


static int[] prefixSum2(int[] arr){

    int n = arr.length ;
    for(int i = 1 ; i<n ; i++){
       arr[i] = arr[i]+ arr[i-1];
    }
 return arr;
}

// Q.2 given an array of integers of size n. answer q queries where you need to print the sum of values in a given range of indices from 1 to r(both included)
// note : the values of 1 and r are queries follow 1 based indexing.

// yha krenge hum prefix sum method ka uses  for optimised code.

// System.out.println("entr new array :");
//     int [] qarr = new int[n+1];
//     System.out.println("enter elements of array :");
//      for(int i =1 ; i<=n ; i++){
//         qarr[i] = sc.nextInt();
//      }
//      printArray(qarr);

//      int prefsumarr[] = prefixSum(qarr);
//      printArray(prefsumarr);

//     System.out.println("enter number of queries :");
//     int q = sc.nextInt();

//     while( q-- > 0) // q minus minus
//     {
//         System.out.println("enter range:");
//         int l = sc.nextInt();
//         int r = sc.nextInt();

//         int ans = prefsumarr[r] - prefsumarr[l-1];
//         System.out.println(" sum " + ans);

// ye niche main mai ra h.. ya to bs copy paste kr diya h maine
    


// Q3.  checck if we can partition the array into two subarray with equal sum . More formally check the prefix sum of a part of the array is equal to the suffix sum of rest of the array.

static int[] suffixarr( int [] arr){
    int n = arr.length;

    for( int i = n-1 ; i>=0 ; i--){
        arr[i] = arr[i] + arr[i+1];
    }
    return arr;
}

// i = 0 to i = n  and check pref[i] = suff[i+1] return true
// suffix sum => total sum - prefix sum

static int findArraySum( int arr[]) {
    int totalSum = 0;
    for( int i=0 ; i< arr.length ; i++){
        totalSum += arr[i];
    }
    return totalSum;
}

static boolean equalsumPartition(int [] arr){
 int totalSum = findArraySum(arr);
 
 // prefsum + suffsum = total sum
 int prefsum = 0 ;
 for( int i=0 ; i< arr.length ; i++){
    prefsum += arr[i];
    int suffixsum = totalSum - prefsum;
    if( suffixsum == prefsum){
        return true ;
 }
}
return false;
}



@SuppressWarnings("resource")
public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.println("enter array size :");
     int n = sc.nextInt();
     int[] arr = new int[n];

     System.out.println("enter elements of array :");
     for(int i =0 ; i<n ; i++){
        arr[i] = sc.nextInt();
     }

    System.out.println("the original array is :");
    printArray(arr);

    int[] prefArr = prefixSum(arr);
    printArray(prefArr);

    // without creating a new array
    System.out.println("without new arr");
    int[] prefArr2 = prefixSum2(arr);
    printArray(prefArr2);

    System.out.println("entr new array :");
    int [] qarr = new int[n+1];
    System.out.println("enter elements of array :");
     for(int i =1 ; i<=n ; i++){
        qarr[i] = sc.nextInt();
     }
     printArray(qarr);

     int prefsumarr[] = prefixSum(qarr);
     printArray(prefsumarr);

    System.out.println("enter number of queries :");
    int q = sc.nextInt();

    while( q-- > 0) // q minus minus
    {
        System.out.println("enter range:");
        int l = sc.nextInt();
        int r = sc.nextInt();

        int ans = prefsumarr[r] - prefsumarr[l-1];
        System.out.println(" sum " + ans);
    }
}

}
