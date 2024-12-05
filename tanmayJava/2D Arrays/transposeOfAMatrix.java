import java.util.*;
public class transposeOfAMatrix{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            // input matrix as transpose
            int m, n, mat [][];
            System.out.println("enter number of rows");
            m = sc.nextInt();
            System.out.println("enter number of columns");
            n = sc.nextInt();
            // switch rows and columns
            mat = new int [n][m];
            System.out.println("enter " + (m*n) + " elements");
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    System.out.println(i + "," + j + " : ");
                    // switch i and j
                    mat [j][i] = sc.nextInt();
                }
            }
            // display transpose
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    System.out.print(mat [i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}