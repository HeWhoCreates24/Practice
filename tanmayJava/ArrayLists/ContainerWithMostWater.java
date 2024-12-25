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

            // Logic to calculate max water
            int st = 0;
            int en = height.size() - 1;
            int maxWater = Math.min(height.get(st), height.get(en)) * (en - st);
            int p1 = st, p2 = en;
            int i = 1;

            while (st < en && i < en - st) {
                if (height.get(st) <= height.get(en)) {
                    if (height.get(st + i) > height.get(st)) {
                        st += i;
                        int currWater = Math.min(height.get(st), height.get(en)) * (en - st);
                        if (currWater > maxWater) {
                            maxWater = currWater;
                            p1 = st;
                            p2 = en;
                        }
                        i = 1; // Reset step
                    } else {
                        i++;
                    }
                } else {
                    if (height.get(en - i) > height.get(en)) {
                        en -= i;
                        int currWater = Math.min(height.get(st), height.get(en)) * (en - st);
                        if (currWater > maxWater) {
                            maxWater = currWater;
                            p1 = st;
                            p2 = en;
                        }
                        i = 1; // Reset step
                    } else {
                        i++;
                    }
                }
            }

            // Display results
            System.out.println("Pole 1: " + p1 + ", Pole 2: " + p2 + ", Max Water: " + maxWater + " units");
        }
    }
}
