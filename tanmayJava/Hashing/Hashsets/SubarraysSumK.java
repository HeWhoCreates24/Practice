import java.util.*;

public class SubarraysSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        HashMap<Integer, Integer> sumFreq = new HashMap<>();
        int k = 3;
        int tempSum = 0;
        int subs = 0;

        sumFreq.put(0, 1); // Handles cases where subarray starts at index 0

        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];

            // ✅ If tempSum - k exists in map, add its frequency to count
            if (sumFreq.containsKey(tempSum - k)) {
                subs += sumFreq.get(tempSum - k);
            }

            // ✅ Store tempSum frequency in the map
            sumFreq.put(tempSum, sumFreq.getOrDefault(tempSum, 0) + 1);
        }

        System.out.println("Number of subarrays with sum " + k + ": " + subs);
    }
}
