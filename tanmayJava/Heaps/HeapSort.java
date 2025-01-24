import java.util.*;

public class HeapSort{
    private static void heapify(ArrayList<Integer> heap, int i, int n){
        int leftIdx = (2*i)+1;
        int rightIdx = (2*i)+2;
        int minIdx = i;

        if (leftIdx < n && heap.get(leftIdx) > heap.get(minIdx)){
            minIdx = leftIdx;
        }
        
        if (rightIdx < n && heap.get(rightIdx) > heap.get(minIdx)){
            minIdx = rightIdx;
        }

        if (minIdx != i){
            int temp = heap.get(minIdx);
            heap.set(minIdx, heap.get(i));
            heap.set(i, temp);

            heapify(heap, minIdx, n);
        }
    }
    
    public static void heapSort(ArrayList<Integer> arr){
        for (int i = (arr.size()/2) - 1; i >= 0; i--){
            heapify(arr, i, arr.size());
        }

        int n = arr.size();

        while (n > 0){
            int temp = (int)arr.get(0);
            arr.set(0, arr.get(n-1));
            arr.set(n-1, temp);

            heapify(arr, 0, --n);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(5);
        arr.add(3);
        arr.add(1);
        arr.add(8);
        arr.add(0);
        arr.add(6);

        System.out.println(arr);
        heapSort(arr);
        System.out.println(arr);
    }
}