import java.util.*;

public class LongestSubarray0Sum {
    public static void main(String[] args) {
        int[] arr = {-10, 2, -3, -4, 15};

        HashMap<Integer, Integer> sum = new HashMap<>();
        int tempSum = 0;
        int largestSub = 0;
        int j = 0, k = 0;

        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];

            //  If sum becomes 0, update indices
            if (tempSum == 0) {
                largestSub = i + 1;
                j = 0;
                k = i;
            }

            //  If sum is seen before, check for longest subarray
            if (sum.containsKey(tempSum)) {
                if (i - sum.get(tempSum) > largestSub) {
                    largestSub = i - sum.get(tempSum);
                    j = sum.get(tempSum) + 1;
                    k = i;
                }
            } else {
                sum.put(tempSum, i);
            }
        }

        System.out.println("Length: " + largestSub);
        if (largestSub > 0) {
            System.out.print("Subarray: ");
            while (j <= k) {
                System.out.print(arr[j++] + " ");
            }
        } else {
            System.out.println("No zero-sum subarray found.");
        }
    }
}
