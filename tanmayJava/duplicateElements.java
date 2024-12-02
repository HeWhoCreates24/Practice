import java.util.*;
public class duplicateElements{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.err.println("enter array size");
            int n = sc.nextInt();
            System.out.println("enter array");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i]=sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i!=j&&nums[i]==nums[j]){
                        System.out.println("DUPLICATES PRESENT!!");
                        return;
                    }
                }
            }
            System.out.println("NO DUPLICATES!!");
        }
    }
}