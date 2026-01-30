package Array;

import java.util.Scanner;

class Method {
     Method(){}

    //   transpose array with new array

    protected int[][] transpose( int[][] a , int r1, int c1){
           int[][] ans = new int[c1][r1];
         for(int i =0 ; i< c1 ;i++){
            for(int j=0 ;j < r1 ;j++){
                ans[i][j] = a[j][i];
            }
         }
         return ans;
     }

     protected void printarr(int[][] arr){
        for(int i=0; i<arr.length;i++){
            for(int j =0 ; j<arr[i].length;j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
     }

//  transpose of array without Creating new array => yha ek catch hai hum diagnol elements k alawa sbko swap kr derer hai baar baar isko resolve krne k liye hum j ko i se ittrate krenege


protected void transposeInPlace(int[][]  a , int r, int c){
    for(int i=0 ; i<c ; i++){
        for(int j =i ; j<r ; j++){

            //  swap
          int temp = a[i][j];
          a[i][j] = a[j][i];
          a[j][i] = temp;
        }
    }
}

// Q . Given a square matrix turn it by 90 degrees in clockwise direction without using extra space


protected void reverseArray(int[] arr ){
    int i=0 , j = arr.length-1;
    while(i<j){
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
       i++;
       j--;
    }
}

protected void rotateNinty(int[][] matrix , int r , int c){
    // transpose and reverse each row of transpose matriz

    transposeInPlace(matrix, r, c);
    for(int i = 0 ; i< r ; i++){
        reverseArray(matrix[i]);
    }

}

}
public class twoDArrayProblemSolv1 {
  public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     System.out.println("Enter rows and columns");
     int r1 = sc.nextInt();
     int c1 = sc.nextInt();

     int[][] arrT = new int[r1][c1];

    System.out.println("Enter the values of matrix ");
    for(int i=0 ; i<r1 ;i++){
        for(int j=0 ; j<c1 ; j++){
            arrT[i][j] = sc.nextInt();
        }
        System.out.println("");
    }

    Method mt = new Method();
    // int[][] transposed = mt.transpose(arrT, r1, c1);
    // mt.printarr(transposed);

    //  mt.transposeInPlace(arrT , r1 , c1);
    //  mt.printarr(arrT);

     mt.rotateNinty(arrT, r1, c1);
     mt.printarr(arrT);


  }
}
