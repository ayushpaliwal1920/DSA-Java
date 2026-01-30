package Array;

import java.util.Scanner;

// Sum of rectangle using different methods:
// 1. Brute force
// 2. Prefix sum row-wise
// 3. Prefix sum row + column (2D prefix)

public class twoDArrayProblemSolv3 {

    // Method 1: Brute force sum of rectangle
    static int bruteForceSum(int[][] arr, int l1, int r1, int l2, int r2) {
        int sum = 0;
        for (int i = l1; i <= l2; i++) {
            for (int j = r1; j <= r2; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    // Method 2: Pre-calculating row-wise prefix sum
    static void findRowPrefixSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
    }

    static int findSum2(int[][] matrix, int l1, int l2, int r1, int r2) {
        int sum = 0;
        findRowPrefixSum(matrix);

        for (int i = l1; i <= l2; i++) {
            if (r1 >= 1) {
                sum += matrix[i][r2] - matrix[i][r1 - 1];
            } else {
                sum += matrix[i][r2];
            }
        }
        return sum;
    }

    // Method 3: Prefix sum over both rows and columns
    static void findPrefixSum2D(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        // first row-wise prefix
        findRowPrefixSum(matrix);

        // then column-wise prefix
        for (int j = 0; j < c; j++) {
            for (int i = 1; i < r; i++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
    }

    static int findSum3(int[][] matrix, int l1, int l2, int r1, int r2) {
        findPrefixSum2D(matrix);

        // total rectangle sum
        int sum = matrix[l2][r2];

        int up = (l1 >= 1) ? matrix[l1 - 1][r2] : 0;
        int left = (r1 >= 1) ? matrix[l2][r1 - 1] : 0;
        int leftUp = (l1 >= 1 && r1 >= 1) ? matrix[l1 - 1][r1 - 1] : 0;

        return sum - up - left + leftUp;
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rows and columns of the matrix:");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter coordinates l1 r1 l2 r2 (0-based indices):");
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();

        // Make copies of matrix for each method (to avoid prefix overwriting issues)
        int[][] matrixCopy1 = new int[r][c];
        int[][] matrixCopy2 = new int[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(matrix[i], 0, matrixCopy1[i], 0, c);
            System.arraycopy(matrix[i], 0, matrixCopy2[i], 0, c);
        }

        System.out.println("\nSum using Brute Force = " + bruteForceSum(matrix, l1, r1, l2, r2));
        System.out.println("Sum using Row Prefix = " + findSum2(matrixCopy1, l1, l2, r1, r2));
        System.out.println("Sum using 2D Prefix  = " + findSum3(matrixCopy2, l1, l2, r1, r2));
    }
}
