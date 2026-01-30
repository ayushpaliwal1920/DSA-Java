package Array;

import java.util.Scanner;

public class twoDArray2 {

    static void printArray(int[][] arr){
      for(int i = 0; i < arr.length; i++){
        for(int j = 0; j < arr[i].length; j++){
          System.out.print(arr[i][j] + " ");
        }
        System.out.println();
      }
    }

    // Addition of two matrix
    static void add(int[][] a, int r1, int c1, int[][] b, int r2, int c2){
        if(r1 != r2 || c1 != c2){
            System.out.println("Wrong input - addition not possible");
            return;
        }
        int sum[][] = new int[r1][c1];

        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c1; j++){
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        printArray(sum);
    }

    // multiplication of matrix
    static void multiplication(int[][] a, int r1 , int c1 , int[][] b , int r2, int c2){
       
      if ( c1 != r2 ) {
        System.err.println("Multiplication is not possible.");
        return;

       }
        int  mul[][] = new int[r1][c2]; // initially sari values zero hongi

        for(int i = 0 ; i< r1 ; i++){
          for(int j=0 ; j< c2 ; j++){
            for(int k= 0; k<c1 ; k++){
                mul[i][j] = mul[i][j]+a[i][k]*b[k][j];
            }
          }
        }

        printArray(mul);
    
    }
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
          System.out.println("Enter number of rows and columns of matrix 1");
          int r1 = sc.nextInt();
          int c1 = sc.nextInt();
          int[][] a = new int[r1][c1];
          
          System.out.println("Enter matrix 1 values");
          for(int i = 0; i < r1; i++){
              for(int j = 0; j < c1; j++){
                  a[i][j] = sc.nextInt();
              }
          }

          System.out.println("Enter number of rows and columns of matrix 2");
          int r2 = sc.nextInt();
          int c2 = sc.nextInt();
          int[][] b = new int[r2][c2];
          
          System.out.println("Enter matrix 2 values");
          for(int i = 0; i < r2; i++){
              for(int j = 0; j < c2; j++){
                  b[i][j] = sc.nextInt();
              }
          }
          
          System.out.println("Matrix 1:");
          printArray(a);
          System.out.println("Matrix 2:");
          printArray(b);

          System.out.println("Sum matrix");
          add(a, r1, c1, b, r2, c2);

          System.out.println("Multiplication of Matrix 1 and 2");
          multiplication(a, r1, c1, b, r2, c2);
        }
    }
}
