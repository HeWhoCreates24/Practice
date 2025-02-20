import java.util.*;

public class LargestRegion{
    public static class Pair{
        int i;
        int j;

        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void largestRegion(int[][] mat){
        int[] largest = {0, 0};
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                if (!visited[i][j]){
                    computeRegion(i, j, mat, largest, visited);
                }
            }
        }
        System.out.println("Largest region is made of " + largest[1] + " " + largest[0] + "'s");
    }
    public static void computeRegion(int i, int j, int[][] mat, int[] largest, boolean[][] visited){
        int region = 1;
        int cell = mat[i][j];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()){
            Pair curr = q.remove();
            i = curr.i;
            j = curr.j;
            if (i + 1 < mat.length && mat[i+1][j] == mat[i][j] && !visited[i+1][j]){
                q.add(new Pair(i+1, j));
                visited[i+1][j] = true;
                region++;
            }
            if (j + 1 < mat[i].length && mat[i][j+1] == mat[i][j] && !visited[i][j+1]){
                q.add(new Pair(i, j+1));
                visited[i][j+1] = true;
                region++;
            }
            if (i - 1 > -1 && mat[i-1][j] == mat[i][j] && !visited[i-1][j]){
                q.add(new Pair(i-1, j));
                visited[i-1][j] = true;
                region++;
            }
            if (j - 1 > -1 && mat[i][j-1] == mat[i][j] && !visited[i][j-1]){
                q.add(new Pair(i, j-1));
                visited[i][j-1] = true;
                region++;
            }
        }
        if (region > largest[1]){
            largest[1] = region;
            largest[0] = cell;
        }
    }
    public static void main(String[] args) {
        int[][] mat = {{1, 0, 1, 0, 0, 1},
                       {0, 1, 1, 0, 0, 1},
                       {1, 0, 0, 1, 1, 0}};

        largestRegion(mat);
    }
}