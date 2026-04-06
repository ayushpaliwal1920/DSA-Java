public class Backtracking_09_sudokuSolver {

    // fill sudoku :

    public static void solveSudoku(char[][] board, int row, int col, char[][] grid) {
        // base case ;

        if (row == 9 ) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = board[i][j];
                }
            }
            return;
        }

        // small ans :

        if (board[row][col] != '.') {
            if (col < 8) {
                solveSudoku(board, row, col + 1, grid);
            } else {
                solveSudoku(board, row + 1, 0, grid);
            }
        } else {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isValid(board, row, col, ch)) {
                    board[row][col] = ch;
                    if (col < 8)
                        solveSudoku(board, row, col + 1, grid);
                    else
                        solveSudoku(board, row + 1, 0, grid);
                    board[row][col] = '.'; // backtracking
                }
            }
        }
    }

    public static boolean isValid(char[][] board, int row, int col, char ch) {

        // check row :

        for(int j = 0 ; j < 9 ; j++){
            if( board[row][j] == ch) return false;
        }

        // check col :

        for(int i = 0 ; i < 9 ; i++){
            if( board[i][col] == ch) return false;
        }

        // check 3*3 :

        int sRow = row/3*3;
        int sCol = col/3*3;

        for(int i = sRow ; i< sRow+3 ; i++ ){
            for(int  j = sCol ; j < sCol+3 ; j++){
                if(board[i][j] == ch){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 9;
          char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        char[][] grid = new char[9][9];

        solveSudoku(board, 0, 0, grid);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = grid[i][j];
            }
        }

    }
}
 