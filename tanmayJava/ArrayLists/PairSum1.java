import java.util.*;

public class PairSum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input array
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println("Enter numbers (end with .):");
        while (sc.hasNextInt()) {
            nums.add(sc.nextInt());
        }
        sc.next(); // for the '.' after inputs

        // Input target
        System.out.println("Enter target:");
        int target = sc.nextInt();

        // Sort the array for the two pointer approach
        Collections.sort(nums);

        // Two-pointer approach
        int st = 0;
        int en = nums.size() - 1;
        boolean found = false;

        while (st < en) {
            int currSum = nums.get(st) + nums.get(en);

            if (currSum == target) {
                found = true;
                break;
            } else if (currSum < target) {
                st++;
            } else {
                en--;
            }
        }

        // Display result
        if (found) {
            System.out.println(nums.get(st) + " + " + nums.get(en) + " = " + target);
        } else {
            System.out.println("No pair found that sums to " + target);
        }
    }
}
