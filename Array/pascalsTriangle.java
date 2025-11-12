package Array;

import java.util.Scanner;

// Given an integer n retutn the first n rows of pascal's triangle .
// In pascal's triangle each number is the sum of the two numbers directly above it

// i = every first and last element of every row is 1
// ii = p[i][j] = p[i-1][j]+p[i-1][j-1]
// iii = jacked 2D arrays 
// iv = i rows i+1 columns

public class pascalsTriangle {

   static void printmatrix(int[][] matrix){
    for(int i=0 ; i< matrix.length; i++){
        for(int j=0 ; j < matrix[i].length ; j++){   // ✅ use row length
            System.out.print(matrix[i][j] +" ");     // ✅ use print, not println
        }
        System.out.println();
    }
}

    

    static int[][] pascaL(int n){
        int[][] ans = new int[n][];

        for(int i=0 ; i<n ; i++){
            // dynamic space
            ans[i] = new int[i+1];  // number of columns in the ith row= i+1
            // 1st and last element is 1
            ans[i][0] = ans[i][i] = 1;

          for(int j=1 ; j<i ; j++){
            ans[i][j] = ans[i-1][j]+ans[i-1][j-1];
          }
        }
        return ans;

    }    
    
    public static void main(String[] args) {
     try (Scanner sc = new Scanner(System.in)) {
        System.out.println("enter n");
         int n = sc.nextInt();
         int[][] ans = pascaL(n);
         printmatrix(ans);
     }
     }
}