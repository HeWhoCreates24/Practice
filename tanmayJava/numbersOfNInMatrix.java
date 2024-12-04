import java.util.*;
public class numbersOfNInMatrix{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            // input matrix
            int m, n, mat [][];
            System.out.println("enter number of rows");
            m = sc.nextInt();
            System.out.println("enter number of columns");
            n = sc.nextInt();
            mat = new int [m][n];
            System.out.println("enter " + (m*n) + " elements");
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    System.out.println(i + "," + j + " : ");
                    mat [i][j] = sc.nextInt();
                }
            }
            // input N
            int N;
            System.out.println("enter N");
            N = sc.nextInt();
            // count N
            int count = 0;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (mat [i][j] == N){
                        count++;
                    }
                }
            }
            // Display Count
            if (count == 0){
                System.out.println(N + " is not present in the matrix.");
            }
            else {
                System.out.println(N + " is present in the matrix in " + count + " cells.");
            }
        }
    }
}