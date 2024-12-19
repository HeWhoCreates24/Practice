import java.util.*;
public class SudokuSolver{
    public static boolean isSafe(int x, int i, int j, int [][] sudoku){
        for (int temp = 0; temp < 9; temp++){
            if (sudoku [i][temp] == x){
                return false;
            }
            if (sudoku [temp][j] == x){
                return false;
            }
        }
        int gridStartRow = (i / 3) * 3;
        int gridStartCol = (j / 3) * 3;
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (sudoku[gridStartRow + a][gridStartCol + b] == x) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int [][] sudoku, int i, int j){
        //reset j if exceeds 8
        if (j == 9){
            j = 0;
            i++;
        }
        if (i == 9){
            // found solution
            return true;
        }
        //skip if filled
        if (sudoku [i][j] != 0){
            return sudokuSolver(sudoku, i, j+1);
        }
        // try nums
        for (int x = 1; x < 10; x++){
            if (isSafe(x, i, j, sudoku)){
                sudoku [i][j] = x;
                if (sudokuSolver(sudoku, i, j+1)){
                    return true;
                }
                sudoku [i][j] = 0;
            }
        }
        return false;

    }
    public static void display(int [][] sudoku){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (j == 3 || j == 6){
                    System.out.print("| ");
                }
                if (j == 0 && (i == 3 || i == 6)){
                    System.out.println("------+-------+------");
                }
                if (sudoku [i][j] == 0){
                    System.out.print("- ");
                }
                else{
                    System.out.print(sudoku [i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            // input sudoku
            int [][] sudoku = new int[9][9];
            System.out.println("Enter a sudoku");
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++){
                    sudoku [i][j] = sc.nextInt();
                }
            }
            // display sudoku
            System.out.println("here is the sudoku you entered");
            System.out.println();
            display(sudoku);
            System.out.println();
            // solve
            boolean solvable = sudokuSolver(sudoku, 0, 0);
            // display result
            if (solvable){
                System.out.println("here is one of the solutions");
                System.out.println();
                display(sudoku);
            }
            else{
                System.out.println("the sudoku is unsolvable");
            }
        }
    }
}