public class Backtracking_07_nKnights {

    // maximum number of knight that can be placed in a given chessboard.

    static int maxKnight = -1;

    public static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        int i, j;

        // 2 up and 1 right

        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n && board[i][j] == 'K')
            return false;

        // 2 up and 1 left

        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && board[i][j] == 'K')
            return false;

        // 2 Down and 1 left

        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && board[i][j] == 'K')
            return false;

        // 2 Down and 1 right

        i = row + 2;
        j = col + 1;
        if (i < n && j < n && board[i][j] == 'K')
            return false;

        // 2 right and 1 up

        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < n && board[i][j] == 'K')
            return false;

        // 2 right and 1 Down

        i = row + 1;
        j = col + 2;
        if (i < n && j < n && board[i][j] == 'K')
            return false;

        // 2 left and 1 up

        i = row - 1;
        j = col - 2;
        if (i >= 0 && j >= 0 && board[i][j] == 'K')
            return false;

        // 2 left and 1 Down

        i = row + 1;
        j = col - 2;
        if (i < n && j >= 0 && board[i][j] == 'K')
            return false;

        return true;
    }

    public static void nKnight(char[][] board, int row, int col, int num) {
        int n = board.length;

        
        if (row == n) {// base case : 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println();

            maxKnight = Math.max(num, maxKnight);
            return;
        }
        else if (isSafe(board, row, col)) {// small ans :

            board[row][col] = 'K';
            if (col != n - 1) {
                nKnight(board, row, col + 1, num + 1);
            } else {
                nKnight(board, row + 1, 0, num + 1);
            }
            board[row][col] = '.'; //backtracking
        } 
        // not safe
        if(col != n-1) nKnight(board, row, col+1, num);
        else  nKnight(board, row+1, 0, num);
            
        
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        nKnight(board, 0, 0, 0);
        System.out.println(maxKnight);
    }

}
