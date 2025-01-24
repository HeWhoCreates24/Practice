import java.util.*;

public class WeakestSoldier{
    public static class Row implements Comparable<Row>{
        int idx;
        int sols;

        public Row(int idx, int sols){
            this.idx = idx;
            this.sols = sols;
        }

        @Override
        public int compareTo(Row r2){
            if (this.sols != r2.sols) return this.sols - r2.sols;
            else return this.idx - r2.idx;
        }
    }
    public static void main(String[] args) {
        int[][] rows = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };

        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < rows.length; i++){
            int[] row = rows[i];
            int sols = 0;
            for (int x : row){
                sols += x;
            }

            pq.add(new Row(i, sols));
        }

        for (int i = 0; i < k; i++){
            System.out.println("Row " + pq.remove().idx);
        }
    }
}