public class Backtracking_02_4DirectionMazePath {

    /*
    Q : Rat In MazeII : 4 Directions  
    */

    public static void print_path_maze(int sr, int sc , int er , int ec,String s ,boolean[][] isVisited){
       if( sr < 0 || sc < 0 ) return;
       if( sr > er || sc > ec) return;
       if(isVisited[sr][sc] == true) return;
       if( sr == er && sc == ec) {
         System.out.println(s);
         return;
       }


      isVisited[sr][sc] = true;
      //  go right :

      print_path_maze(sr, sc+1, er, ec, s+"R", isVisited);

      //  go down :

      print_path_maze( sr+1, sc, er, ec, s+"D", isVisited);

      // go left: 

      print_path_maze(sr, sc-1, er, ec, s+"L", isVisited);

      // go up :

      print_path_maze(sr-1, sc, er, ec, s+"U", isVisited);

      // BACKTRACKING :

      isVisited[sr][sc] = false;

    }
     public static void main(String[] args) {
        int rows = 3;
        int columns = 3;
        
        boolean[][] isVisited = new boolean[rows][columns]; // by default false  
        print_path_maze(0, 0, rows-1, columns-1,"",isVisited);       
     }
}
