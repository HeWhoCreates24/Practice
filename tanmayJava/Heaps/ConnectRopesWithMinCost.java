import java.util.*;

public class ConnectRopesWithMinCost{
    public static void main(String[] args) {
        int[] ropes = {2, 3, 3, 4, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < ropes.length; i++){
            pq.add(ropes[i]);
        }

        int cost = 0;

        while (!pq.isEmpty()){
            int r1 = pq.remove();
            int r2 = pq.remove();

            int r3 = r1 + r2;
            cost += r3;

            if (!pq.isEmpty()){
                pq.add(r3);
            }
        }

        System.out.println(cost);
    }   
}