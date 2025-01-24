import java.util.*;

public class NearbyCars{
    public static class Car implements Comparable<Car>{
        int distSq;
        int idx;

        public Car(int idx, int distSq){
            this.idx = idx;
            this.distSq = distSq;
        }

        @Override
        public int compareTo(Car c2){
            return this.distSq - c2.distSq;
        }
    }
    public static void main(String[] args) {
        int[][] cars = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Car> pq = new PriorityQueue<>();

        for (int i = 0; i < cars.length; i++){
            int[] car = cars[i];
            int distSq = (car[0]*car[0]) + (car[1]*car[1]);
            pq.add(new Car(i, distSq));
        }

        for (int i = 0; i < k; i++){
            System.out.println("C" + pq.remove().idx);
        }
    }
}