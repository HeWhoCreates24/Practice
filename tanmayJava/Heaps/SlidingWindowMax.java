import java.util.*;

public class SlidingWindowMax{
    public static class Val implements Comparable<Val>{
        int idx;
        int val;

        public Val(int idx, int val){
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Val v2){
            return v2.val - this.val;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        PriorityQueue<Val> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++){
            pq.add(new Val(i, arr[i]));
        }

        ArrayList<Integer> res = new ArrayList<>();

        res.add(pq.peek().val);

        for (int i = k; i < arr.length; i++){
            while (pq.peek().idx <= i - k){
                pq.remove();
            }

            pq.add(new Val(i, arr[i]));

            res.add(pq.peek().val);
        }

        System.out.println(res);
    }
}