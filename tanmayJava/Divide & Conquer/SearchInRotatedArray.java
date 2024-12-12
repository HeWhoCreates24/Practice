import java.util.*;
public class SearchInRotatedArray{
    public static int binS(int arr [], int target){
        int st = 0;
        int en = arr.length-1;
        while (st <= en){
            // find mid
            int mid = st + (en - st) / 2;
            // if found return mid
            if (arr [mid] == target){
                return mid;
            }
            else if (arr [mid] > arr [st]){
                // left array is sorted
                if (arr [mid] > target && arr [st] <= target){
                    // target is in sorted part
                    en = mid - 1;
                }
                else {
                    st = mid + 1;
                }
            }
            else {
                // right array is sorted
                if (arr [mid] < target && arr [en] >= target){
                    // target is in sorted part
                    st = mid + 1;
                }
                else {
                    en = mid -1;
                }
            }
        }
        // return -1 if not found
        return -1;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            // input array
            System.out.println("Enter size of array :");
            int n = sc.nextInt();
            int arr [] = new int [n];
            System.out.println("Enter " + n + " elements :");
            for (int i = 0; i < n; i++){
                arr [i] = sc.nextInt();
            }
            // input target
            System.out.println("Enter target :");
            int target = sc.nextInt();
            // perform modified binary search
            int i = binS(arr, target);
            if(i != -1){
                System.out.println("Target found at index " + i);
            }
            else{
                System.out.println("Target NOT FOUND");
            }
        }
    }
}