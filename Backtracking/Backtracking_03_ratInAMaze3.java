public class Backtracking_03_ratInAMaze3 {

  /*
   * Q : Rat in Dead Maze 3 : A maze is an N*N binary matrix of block where the
   * upper left block is known as the source block
   * ans the lower rightmost block is known as the destination block.if we
   * consider the maze [0][0] is the source and maze[N-1][N-1]
   * is the destination .Our main task is to reach the destination from the source
   * . We have considered a rat as a character that can move either forward
   * or downwards,leftwards or upwards.
   * In the maze matrix a few dead blocks will be denoted by 0 and active blocks
   * will be denoted by 1 .
   * A rat can move only in the active blocks.
   * 
   */

  public static void print_maze_path(int sr, int sc, int er, int ec, String s, int[][] maze, boolean[][] isVisited) {
    if( sr < 0 || sc < 0) return;
    if (sr > er || sc > ec)
      return;
    if (sr == er && sc == ec) {
      System.out.println(s);
      return;
    }
    if (maze[sr][sc] == 0) return;
    if (isVisited[sr][sc] == true) return;

    // checkmark
    isVisited[sr][sc] = true;

    // go right

    print_maze_path(sr, sc + 1, er, ec, s+"R", maze, isVisited);

    // go down
    print_maze_path(sr+1, sc, er, ec, s+"D", maze, isVisited);

    // go left

    print_maze_path(sr, sc-1, er, ec, s+"L", maze, isVisited);

    // go up

    print_maze_path(sr-1, sc , er, ec, s+"U", maze, isVisited);


    // backtracking :

    isVisited[sr][sc] = false;

  }


  // SPACE OPTIMIZED VERSION ::

    public static void print_maze_path2(int sr, int sc, int er, int ec, String s, int[][] maze) {
    if( sr < 0 || sc < 0) return;
    if (sr > er || sc > ec)
      return;
    if (sr == er && sc == ec) {
      System.out.println(s);
      return;
    }
    if (maze[sr][sc] == 0) return; // blocked (given)

    if(maze[sr][sc] == -1) return; // visited(by rat)

    // checkmarks :

    maze[sr][sc] = -1;
  
    // go right

    print_maze_path2(sr, sc + 1, er, ec, s+"R", maze);

    // go down
    print_maze_path2(sr+1, sc, er, ec, s+"D", maze);

    // go left

    print_maze_path2(sr, sc-1, er, ec, s+"L", maze);

    // go up

    print_maze_path2(sr-1, sc , er, ec, s+"U", maze);


    // backtracking :

    maze[sr][sc] = 1;

  }

  public static void main(String[] args) {
    int rows = 3;
    int cols = 4;

    int[][] maze = { { 1, 0, 1, 1 },
        { 1, 1, 1, 1 },
        { 1, 1, 0,1 }
       };

    boolean[][] isVisited = new boolean[rows][cols];

    print_maze_path(0, 0, rows-1, cols-1, "", maze, isVisited);

    // OPTIMIZED VERSION MAI isVisited ki jarurat hi ni hh :
  }

}
