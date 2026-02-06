package Oops;

import java.util.Arrays;

public class Oops_Question_04 {

    // Q : Make your own ArrayList :

    public static class arrayList{

         int[] arr = new int[5];
         int idx = 0;
         int size = 0;

         public void add(int ele){

            if(size == arr.length){
                int[] brr = Arrays.copyOf(arr, arr.length*2);
                // arr = new int[brr.length];
                // arr = Arrays.copyOf(brr, brr.length);  or

                arr = brr;
            }

            arr[idx] = ele;
            idx++;
            size++;
         }

         public void set(int idx , int val){
            arr[idx] = val;
         }

    }

    public static void main(String[] args) {
        arrayList arr = new arrayList();
        arr.add(2);
        arr.add(1);
        System.out.println(arr.size);

        arr.set(0,10);
    }
}
