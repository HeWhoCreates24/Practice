import java.util.*;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Input heights
            ArrayList<Integer> height = new ArrayList<>();
            System.out.println("Enter array elements (end with '-1'):");
            int num = sc.nextInt();
            while (num != -1) {
                height.add(num);
                num = sc.nextInt();
            }

            // Handle edge cases
            if (height.size() < 2) {
                System.out.println("Not enough poles to form a container.");
                return;
            }

            // 2 pointer approach
            int st = 0;
            int en = height.size() - 1;
            // vars to store max water poles and ammount
            int p1 = st;
            int p2 = en;
            int maxWater = 0;

            while(st < en){
                // calculate current water between the pointers
                int currWater = (Math.min(height.get(st), height.get(en)))*(en-st);
                // update max water data
                if (currWater > maxWater){
                    maxWater = currWater;
                    p1 = st;
                    p2 = en;
                }
                // move the smaller pole pointer
                if (height.get(st) < height.get(en)){
                    st++;
                }
                else{
                    en--;
                }
            }
            // Display results
            System.out.println("Pole 1: " + p1 + ", Pole 2: " + p2 + ", Max Water: " + maxWater + " units");
            // time complexity O(n)
        }
    }
}
