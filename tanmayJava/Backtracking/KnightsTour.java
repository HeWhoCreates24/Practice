import java.util.*;
public class KnightsTour{
    public static void knight(int [][] board, int i, int j, int move){
        //knight on cell
        board[i][j] = move+1;
        //base case
        if (move == (board.length*board.length)-1){
            printBoard(board);
            return;
        }
        //up up right
        if (i > 1 && j < board.length-1 && board[i-2][j+1] == 0){
            knight(board, i-2, j+1, move+1);
        }
        //right right up
        if (i > 0 && j < board.length-2 && board[i-1][j+2] == 0){
            knight(board, i-1, j+2, move+1);
        }
        //right right down
        if (i < board.length-1 && j < board.length-2 && board[i+1][j+2] == 0){
            knight(board, i+1, j+2, move+1);
        }
        //down down right
        if (i < board.length-2 && j < board.length-1 && board[i+2][j+1] == 0){
            knight(board, i+2, j+1, move+1);
        }
        //down down left
        if (i < board.length-2 && j > 0 && board[i+2][j-1] == 0){
            knight(board, i+2, j-1, move+1);
        }
        //left left down
        if (i < board.length-1 && j > 1 && board[i+1][j-2] == 0){
            knight(board, i+1, j-2, move+1);
        }
        //left left up
        if (i > 0 && j > 1 && board [i-1][j-2] == 0){
            knight(board, i-1, j-2, move+1);
        }
        //up up left
        if (i > 1 && j > 0 && board[i-2][j-1] == 0){
            knight(board, i-2, j-1, move+1);
        }
        board[i][j] = 0;
    }
    public static void printBoard(int [][] board){
        System.out.println("----------Board----------");
        for (int [] row : board){
            for (int cell : row){
                System.out.print((cell-1)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter n :");
            int n = sc.nextInt();
            int [][] board = new int [n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    board [i][j] = 0;
                }
            }
            knight(board, 0, 0, 0);
        }
    }
}