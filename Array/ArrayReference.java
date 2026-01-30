package Array;

import java.util.Scanner;

@SuppressWarnings("unused")
public class ArrayReference {
    
    static void pritnArray(int[] arr){
        for(int i = 0 ; i< arr.length ; i++){

            System.out.print(arr[i] + " ");
        }

       System.out.println();
     }

    @SuppressWarnings("resource")
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

        int[] arr2 = new int[5];
        arr2 = arr1;

        System.out.println("copied array");
        pritnArray(arr2);


        // changing values of arr 2 

        arr2[0] = 0;
        arr2[1] = 0;

        System.out.println("original changing after changing arr2");
        pritnArray(arr1);

        System.out.println("copied array after changing");
        pritnArray(arr2);

        // change isliye nhi hua qki arr2 alag a=variable jarur h but  unki values same hi adress ko refer krre hai.



    }
}
