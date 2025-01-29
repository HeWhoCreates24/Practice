import java.util.*;

public class DistinctElements{
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 5, 3, 1};

        HashSet<Integer> hs = new HashSet<>();

        for (int ele : arr){
            hs.add(ele);
        }

        System.out.println(hs.size());
    }
}