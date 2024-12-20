// import java.util.*;
public class RatInAMaze{
    public static void rat(int [][] maze, int i, int j, int move){
        //rat on cell
        maze[i][j] = move + 2;
        //base case
        if (i == maze.length-1 && j == maze[0].length-1){
            printMaze(maze);
            return;
        }
        //up
        if (i > 0 && maze[i-1][j] == 1){
            rat(maze, i-1, j, move+1);
            maze[i-1][j] = 1;
        }
        //down
        if (i < maze.length-1 && maze[i+1][j] == 1){
            rat(maze, i+1, j, move+1);
            maze[i+1][j] = 1;
        }
        //left
        if (j > 0 && maze[i][j-1] == 1){
            rat(maze, i, j-1, move+1);
            maze[i][j-1] = 1;
        }
        //right
        if (j < maze[0].length-1 && maze[i][j+1] == 1){
            rat(maze, i, j+1, move+1);
            maze[i][j+1] = 1;
        }
    }
    public static void printMaze(int [][] maze){
        System.out.println("----------PATH----------");
        for (int[] maze1 : maze) {
            for(int x : maze1){
                System.out.print((x == 0 || x == 1 ? "-" : x-2)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int [][] maze = {   {1, 0, 0, 0},
                            {1, 1, 1, 0},
                            {1, 1, 1, 0},
                            {1, 1, 1, 1}};
        rat(maze, 0, 0, 0);
    }
}