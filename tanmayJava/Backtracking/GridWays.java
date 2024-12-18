import java.util.*;
public class GridWays{
        public static int gridWays(int m, int n){
            //base case
            if (m == 1 || n == 1){
                return 1;
            }
            //recursive choice
            return gridWays(m-1, n) + gridWays(m, n-1);
        }
        public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enetr dimensions of grid seperated by a ' ' ");
            int n = sc.nextInt();
            int m = sc.nextInt();
            //compute ways
            int ways = gridWays(m, n);
            //display ways
            System.out.println("the grid can be traversed in "+ways+" ways");
        }
    }
}