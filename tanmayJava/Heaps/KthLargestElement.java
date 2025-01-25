import java.util.*;

public class KthLargestElement{
    static PriorityQueue<Integer> str;
    static Integer kthLarge = null;
    public static void newStream(){
        str = new PriorityQueue<>();
    }
    public static Integer kthLargest(int e, int k){
        str.add(e);
        if (str.size() >= k && (kthLarge == null || e > kthLarge)){
            kthLarge = str.remove();
        }
        return kthLarge;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 11, 70, 50, 40, 100, 5};

        newStream();
        for (int i = 0; i < arr.length; i++){
            System.out.println(kthLargest(arr[i], 3));
        }
    }
}