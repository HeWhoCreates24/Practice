import java.util.*;

public class spiralMatrix {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Input matrix
            int n, m;
            System.out.print("Enter number of rows: ");
            n = sc.nextInt();
            System.out.print("Enter number of columns: ");
            m = sc.nextInt();

            int[][] mat = new int[n][m];
            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            // Spiral traversal
            int top = 0, bottom = n - 1, left = 0, right = m - 1;
            while (top <= bottom && left <= right) {
                // Print top row
                for (int j = left; j <= right; j++) {
                    System.out.print(mat[top][j] + " ");
                }
                top++;

                // Print right column
                for (int i = top; i <= bottom; i++) {
                    System.out.print(mat[i][right] + " ");
                }
                right--;

                // Print bottom row
                if (top <= bottom) {
                    for (int j = right; j >= left; j--) {
                        System.out.print(mat[bottom][j] + " ");
                    }
                    bottom--;
                }

                // Print left column
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        System.out.print(mat[i][left] + " ");
                    }
                    left++;
                }
            }
        }
    }
}
