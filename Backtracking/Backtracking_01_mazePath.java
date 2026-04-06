public class Backtracking_01_mazePath {

    /*
    Backtracking : a systematic algorithmic technique for finding solutions to constraint satisfaction or combinatorial problems by building candidates incrementally and abandoning a candidate ("backtracking") as soon as it is determined to be invalid
    */

    /*
    Q1: Rat in Maze : (2 Directions ) : NOrmal recursion 
    */

    // finding number of ways to cross the maze. : Recursion 

    public static int ways_in_maze(int sr , int sc , int er, int ec){ 
        // (1,1) --> (4,6) => total ways => (2,1) --> (4,6) + (1,2) --> (4,6)

        if( sr > er || sc > ec) return 0;

        if( sr == er && sc==ec) return 1;

        int downWays = ways_in_maze(sr+1,sc,er,ec);
        int rightWays = ways_in_maze(sr, sc+1, er, ec);
        
        int totalWays = downWays+ rightWays ;
        return totalWays;
    }

    // printing the paths of maze : Recursion

    public static void paths_in_maze(int sr , int sc , int er, int ec , String s){
        
        if( sr > er || sc > ec) return;

        if( sr == er &&  sc == ec){
            System.out.println(s);
            return;
        }
        // go down 
        paths_in_maze(sr+1, sc, er, ec, s+"D");
        // go right
        paths_in_maze(sr, sc+1, er, ec, s+"R");
    }

    public static void main(String[] args) {
        int rows = 2;
        int cols = 3;

        int count = ways_in_maze(1,1,rows,cols); // startRow,startCol,EndRow,EndCol
        System.out.println(count);

        // path in maze 

        paths_in_maze(1, 1, rows, cols, "");
    }
}