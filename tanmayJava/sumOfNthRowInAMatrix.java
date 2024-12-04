import java.util.*;
public class sumOfNthRowInAMatrix{
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
            // Sum Nth Row
            int sum = 0;
            for (int j = 0; j < n; j++){
                sum += mat [N][j];
            }
            // Display Sum
            System.out.println("Sum of the " + N + "th row of the matrix : " + sum);
        }
    }
}