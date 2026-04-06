public class Backtracking_08_validSudoku {

    // leetcode 36 :

    /*
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
     * validated according to the following rules:
     * 
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
     * without repetition.
     * Note:
     * 
     * A Sudoku board (partially filled) could be valid but is not necessarily
     * solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     */

    public boolean isValidSudoku(char[][] board){
        for(int i = 0 ; i< 9 ; i++){
            for(int j = 0 ; j< 9 ; j++){

                if(board[i][j] == '.') continue;
                
                char num = board[i][j];
                board[i][j] = '.';
                if(isValid(board,i,j,num) == false) return false;
                board[i][j] = num;
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board , int row , int col , char num){
        // check row :

        for( int j = 0 ; j<9 ;j++){
            if(board[row][j] == num){
                return false;
            }
        }

        // check column :

        for(int i = 0 ; i< 9 ; i++){
            if(board[i][col] == num){
                return false;
            }
        }

        // check 3 * 3 grid :

        int sRow = (row/3)*3 ;
        int sCol = (col/3)*3 ;

        for(int i = sRow;  i< sRow+3 ; i++){
            for(int j = sCol; j< sCol+3 ; j++){
                    if(board[i][j] == num) return false;
            }
        }

        return true;

    }
    public static void main(String[] args) {

    }
}
