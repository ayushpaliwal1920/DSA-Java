public class Backtracking_06_CheckKnightTourConfiguration {

    // LeetCode = 2596

    public boolean checkValidGrid(int[][] board) {
        if (board[0][0] != 0)
            return false;
        return knightTour(board, 0, 0, 0);
    }

    public boolean knightTour(int[][] board, int row, int col, int knight) {
        int n = board.length;

        if (board[row][col] == n * n - 1)
            return true;

        int i, j;

        // 2 up and 1 right

        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n && board[i][j] == knight + 1)
            return knightTour(board, i, j, knight + 1);

        // 2 up and 1 left

        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && board[i][j] == knight + 1)
            return knightTour(board, i, j, knight + 1);

        // 2 Down and 1 right

        i = row + 2;
        j = col + 1;
        if (i < n && j < n && board[i][j] == knight + 1)
            return knightTour(board, i, j, knight + 1);

        // 2 Down and 1 left

        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && board[i][j] == knight + 1)
            return knightTour(board, i, j, knight + 1);

        // 2 Left and 1 Up

        i = row - 1;
        j = col - 2;
        if (i >= 0 && j >= 0 && board[i][j] == knight + 1)
            return knightTour(board, i, j, knight + 1);

        // 2 Left and 1 Down

        i = row + 1;
        j = col - 2;
        if (i < n && j >= 0 && board[i][j] == knight + 1)
            return knightTour(board, i, j, knight + 1);

        // 2 Right and 1 Up

        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < n && board[i][j] == knight + 1)
            return knightTour(board, i, j, knight + 1);

        // 2 Right and 1 Down

        i = row + 1;
        j = col + 2;
        if (i < n && j < n && board[i][j] == knight + 1)
            return knightTour(board, i, j, knight + 1);

        return false;

    }

    public static void main(String[] args) {
        
    }
}