package Array;

import java.util.Scanner;
public class InputArray {
    @SuppressWarnings({ "resource" })
    public static  void main(String[] args) {
        
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
}
