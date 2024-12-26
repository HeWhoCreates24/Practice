import java.util.*;

public class LonelyNumbers {
    public static void main(String[] args) {
        try ( Scanner sc = new Scanner(System.in)) {

            // Input array
            ArrayList<Integer> arr = new ArrayList<>();
            System.out.println("Enter array elements (end with non-integer):");
            while (sc.hasNextInt()) {
                arr.add(sc.nextInt());
            }
            sc.next(); // Consume the non-integer token
            
            // Sort array
            Collections.sort(arr);
            
            // Make an answer list
            ArrayList<Integer> ans = new ArrayList<>();
            
            for (int i = 0; i < arr.size(); i++) {
                // Check if the current number is lonely
                boolean lonely = true;
                
                // Check previous and next neighbors if they exist
                if (i > 0 && (arr.get(i - 1) == arr.get(i) || arr.get(i - 1) == arr.get(i) - 1)) {
                    lonely = false;
                }
                if (i < arr.size() - 1 && (arr.get(i + 1) == arr.get(i) || arr.get(i + 1) == arr.get(i) + 1)) {
                    lonely = false;
                }
                
                // If lonely, add to the list
                if (lonely) {
                    ans.add(arr.get(i));
                }
            }
            
            // Display answer list
            if (ans.isEmpty()) {
                System.out.println("No lonely numbers found.");
            } else {
                System.out.println("Lonely numbers: " + ans);
            }
        }
    }
}
