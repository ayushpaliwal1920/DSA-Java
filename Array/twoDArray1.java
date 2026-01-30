package Array;

import java.util.Scanner;

public class twoDArray1 {

  static void pritnArray(int[][] arr){
      for(int i =0 ; i<arr.length; i++){
      for(int j =0 ; j<arr.length; j++){
        System.out.print(arr[i][j] + " ");
          }
          System.out.println();
        }
  }


  public static void main(String[] args) {

   try (Scanner sc = new Scanner(System.in)) {
    System.out.println("enter number of rows");
    int row = sc.nextInt();
    System.out.println("enete number of columns");
    int clm = sc.nextInt();
    
        
        //   data_type[1stt dimension][2nd dimension]...[nth] array_name = new data_type[1st dimension][2nd dimension]...[nth dimension];
    
    //  method to initialize the 3d array
    
    int [][] arr1 = new int[2][5];
    // rows and columns ka number dena ,mendatory hota hai.
    arr1[0][1] = 2;
    arr1[0][2] = 3;
    arr1[1][0] = 4;
    arr1[1][1] = 5;
    
    //  another method.
    int [][] arr2 = { {1,2,3},
                    {2,5,4},
                    {597,65,34}
                   };
    
          pritnArray(arr1);
          pritnArray(arr2);
    
    
      int[][] arrUser = new int[row][clm];
    
      for(int i=0; i<row;i++){
        for(int j=0;j<clm;j++){
             arrUser[i][j] = sc.nextInt();
        }
      }
      pritnArray(arrUser);
   }
   }
}
