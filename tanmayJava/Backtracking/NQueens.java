import java.util.*;
public class NQueens{
    public static boolean isSafe(char [][] board, int row, int col){
        for (int i = row; i >= 0; i--){
            if (board [i][col] == 'Q'){
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if (board [i][j] == 'Q'){
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++){
            if (board [i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens(int n, char [][] board, int row){
        if (row == n){
            printBoard(board, n);
            return;
        }
        for (int j = 0; j < n; j++){
            if (isSafe(board, row, j)){
                board [row][j] = 'Q';
                nQueens(n, board, row+1);
                board [row][j] = '_';
            }
        }
    }
    public static void printBoard(char [][] board, int n){
        System.out.println("\n-------CHESS BOARD-------\n");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print("|"+board [i][j]);
            }
            System.out.println("|");
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n :");
            int n = sc.nextInt();
            char [][] board = new char [n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    board [i][j] = '_';
                }
            }
            nQueens(n, board, 0);
        }
    }
}