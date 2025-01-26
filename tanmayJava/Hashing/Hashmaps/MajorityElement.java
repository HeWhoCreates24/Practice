import java.util.*;

public class MajorityElement{
    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 5, 2, 3, 6, 9};
        HashMap<Integer, Integer> fr = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            int curr = arr[i];
            if (fr.containsKey(curr)){
                fr.put(curr, fr.get(curr)+1);
            }
            else{
                fr.put(curr, 1);
            }
            if (fr.get(curr) >= arr.length/3){
                System.out.println(curr);
                return;
            }
        }
        System.out.println("No majority element found");
    }
}