import java.util.*;

public class ConnectRopesMinimumCost{

    public static int minCost(int[] arr){

        Arrays.sort(arr);

        Queue <Integer> q = new LinkedList<>();

        for (int i = 0; i < arr.length; i++){

            q.add(arr[i]);

        }

        int cost = 0;

        while (!q.isEmpty()){
            int r1 = q.remove();

            if (q.isEmpty()) break;

            int r2 = q.remove();

            cost += r1+r2;
            q.add(r1+r2);
        }

        return cost;

    }

    public static void main(String[] args) {
        
        int[] arr = {4, 3, 2, 6};

        System.out.println(minCost(arr));

    }

}