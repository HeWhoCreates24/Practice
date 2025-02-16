import java.util.*;

public class RottenOranges {
    public static class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int[][] basket = {{2, 0, 1, 1, 1},
                          {1, 0, 0, 0, 1},
                          {1, 1, 1, 1, 1}};

        System.out.println("All Oranges rotten in " + minTimeToRot(basket) + " time frame(s)");
    }

    public static int minTimeToRot(int[][] basket) {
        int rows = basket.length;
        int cols = basket[0].length;
        Queue<Pair> q = new LinkedList<>();
        int freshOranges = 0;

        // Step 1: Add all initially rotten oranges to the queue & count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (basket[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (basket[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If no fresh oranges exist, return 0 (already rotten)
        if (freshOranges == 0) return 0;

        int time = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        // Step 2: BFS to rot adjacent fresh oranges
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;

            for (int k = 0; k < size; k++) {
                Pair curr = q.poll();
                int i = curr.i, j = curr.j;

                for (int[] d : directions) {
                    int ni = i + d[0], nj = j + d[1];

                    if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && basket[ni][nj] == 1) {
                        basket[ni][nj] = 2;
                        q.add(new Pair(ni, nj));
                        freshOranges--;
                        rotted = true;
                    }
                }
            }

            if (rotted) time++; // Increase time if any oranges rotted in this level
        }

        // If there are still fresh oranges, return -1 (not all can rot)
        return freshOranges == 0 ? time : -1;
    }
}
