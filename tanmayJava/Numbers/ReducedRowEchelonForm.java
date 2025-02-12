import java.util.*;

public class ReducedRowEchelonForm {
    public static ArrayList<ArrayList<Double>> RREF(ArrayList<ArrayList<Double>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        int lead = 0;
        for (int r = 0; r < rows; r++) {
            if (lead >= cols) return matrix;
            int i = r;
            while (matrix.get(i).get(lead) == 0) {
                i++;
                if (i == rows) {
                    i = r;
                    lead++;
                    if (lead == cols) return matrix;
                }
            }
            // Swap rows if necessary
            Collections.swap(matrix, i, r);

            // Normalize pivot row
            double pivot = matrix.get(r).get(lead);
            for (int j = 0; j < cols; j++) {
                matrix.get(r).set(j, matrix.get(r).get(j) / pivot);
            }

            // Make column below pivot zero
            for (int k = r + 1; k < rows; k++) {
                double factor = matrix.get(k).get(lead);
                for (int j = 0; j < cols; j++) {
                    matrix.get(k).set(j, matrix.get(k).get(j) - factor * matrix.get(r).get(j));
                }
            }
            lead++;
        }

        // Convert to RREF: Make entries above pivots zero
        for (int r = rows - 1; r >= 0; r--) {
            int pivotCol = -1;
            for (int j = 0; j < cols; j++) {
                if (matrix.get(r).get(j) == 1) { // Identify pivot column
                    pivotCol = j;
                    break;
                }
            }
            if (pivotCol == -1) continue; // No pivot in this row

            // Make entries above the pivot zero
            for (int k = r - 1; k >= 0; k--) {
                double factor = matrix.get(k).get(pivotCol);
                for (int j = 0; j < cols; j++) {
                    matrix.get(k).set(j, matrix.get(k).get(j) - factor * matrix.get(r).get(j));
                }
            }
        }

        return matrix;
    }

    public static void printMatrix(ArrayList<ArrayList<Double>> matrix) {
        for (ArrayList<Double> row : matrix) {
            System.out.print("[ ");
            for (double ele : row) {
                System.out.printf("%.2f ", ele); // Print with 2 decimal places
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();

        System.out.print("Enter number of Rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of Columns: ");
        int cols = sc.nextInt();

        System.out.println("Enter matrix elements row-wise:");
        for (int i = 0; i < rows; i++) {
            ArrayList<Double> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(sc.nextDouble());
            }
            matrix.add(row);
        }

        System.out.println("\nGiven Matrix:");
        printMatrix(matrix);

        matrix = RREF(matrix);

        System.out.println("\nReduced Row Echelon Form:");
        printMatrix(matrix);
    }
}
