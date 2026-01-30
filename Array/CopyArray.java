package Array;


import java.util.Arrays;
import java.util.Scanner;

public class CopyArray {
    

 static void pritnArray(int[] arr){
        for(int i = 0 ; i< arr.length ; i++){

            System.out.print(arr[i] + " ");
        }

       System.out.println();
     }

    @SuppressWarnings({ "resource", "unused" })
    public static void main(String[] args) {
         
        Scanner Sc = new Scanner(System.in);

        int[] arr1 = new int[5];

        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3 ;
        arr1[3] = 4;
        arr1[4] = 5;

        System.out.println("original array :");
        pritnArray(arr1);

         // using clone() method....


        int[] arr2 = new int[5];
        arr2 = arr1.clone();


        //  using copyOf() method....

        int[] arr3 = new int[3];
        arr3 = Arrays.copyOf(arr1,3);


        // using copyOfRange method.....
        
        int[] arr4 = new int[4];
        arr4 = Arrays.copyOfRange(arr1, 1,5);

     

        System.out.println("copied array");
        pritnArray(arr2);


        // changing values of arr 2 

        arr2[0] = 0;
        arr2[1] = 0;

        System.out.println("original changing after changing arr2");
        pritnArray(arr1);

        System.out.println("copied array after changing");
        pritnArray(arr2);

        // copied arr3 

        System.out.println("by using copyOf : arr3 =");
        pritnArray(arr3);

        // copied  arr4 
        
        System.out.println("by using copyOfRange : arr4 = ");
        pritnArray(arr4);


    }



}
