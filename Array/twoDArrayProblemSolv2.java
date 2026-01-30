package Array;

import java.util.Scanner;

public class twoDArrayProblemSolv2 {
    // Pattern : Spiral Matrix
    // Return all the elements of the matrix in spiral order

    // patern for printing spiral elements
    // top row
    // right column
    // bottom row
    // left column
    static void printarr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printSpiralOrder(int[][] matrix, int r, int c) {
        int leftColm = 0, rightcolm = c - 1, toprow = 0, btmrow = r - 1;
        int totalElements = 0;

        while (totalElements < r * c) {
            // top row => left colm to right colm
            for (int j = leftColm; j <= rightcolm && totalElements < r * c; j++) {
                System.out.print(matrix[toprow][j] + " ");
                totalElements++;
            }
            toprow++;

            // right col => top row to btmrow

            for (int i = toprow; i <= btmrow && totalElements < r * c; i++) {
                System.out.print(matrix[i][rightcolm] + " ");
                totalElements++;
            }
            rightcolm--;

            // botm row => left col to righht col,

            for (int j = rightcolm; j >= leftColm && totalElements < r * c; j--) {
                System.out.print(matrix[btmrow][j] + " ");
                totalElements++;
            }
            btmrow--;

            // left colm => btm row to top row
            for (int i = btmrow; i >= toprow && totalElements < r * c; i--) {
                System.out.print(matrix[i][leftColm] + " ");
                totalElements++;
            }
            leftColm++;

        }

    }

    // Given a positive integer n , generate an n x n matrix filled with elements
    // from 1 to n^2 in spiral order.

    static int[][] generalSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];

        int topRow = 0, bottomRow = n - 1, leftClm = 0, rightcolm = n - 1;
        int curr = 1;

        while (curr <= n * n) {
            // topRow -> leftCol to RightCol
            for (int j = leftClm; j <= rightcolm && curr <= n * n; j++) {
                matrix[topRow][j] = curr;
                curr++;
            }
            topRow++;

            // right col => top row to btmrow

            for (int i = topRow; i <= bottomRow && curr <= n * n; i++) {
                matrix[i][rightcolm] = curr++;
            }
            rightcolm--;

            // botm row => left col to righht col,

            for (int j = rightcolm; j >= leftClm && curr <= n * n; j--) {
                matrix[bottomRow][j] = curr++;

            }
            bottomRow--;

            // left colm => btm row to top row
            for (int i = bottomRow; i >= topRow && curr <= n * n; i--) {
                matrix[i][leftClm] = curr++;
            }
            leftClm++;

        }

        return matrix;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // System.out.println("Enter rows and columns");
            // int r1 = sc.nextInt();
            // int c1 = sc.nextInt();
            System.out.println("Enter n");
            int n = sc.nextInt();

            // int[][] arr = new int[r1][c1];

            int[][] matrix = generalSpiralMatrix(n);
            printarr(matrix);

            // System.out.println("Enter the values of matrix ");
            // for (int i = 0; i < r1; i++) {
            // for (int j = 0; j < c1; j++) {
            // arr[i][j] = sc.nextInt();
            // }
            // System.out.println("");
            // }

            // printSpiralOrder(arr, r1, c1);
        }
    }
}
