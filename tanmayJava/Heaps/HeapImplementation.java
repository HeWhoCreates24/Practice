import java.util.*;

public class HeapImplementation{

    public static class Heap{
        ArrayList<Integer> heap = new ArrayList<>();

        public void add(int data){
            heap.add(data);

            if (heap.size() < 2) return;

            int childIdx = heap.size() - 1;
            int parIdx = (childIdx % 2 == 0 ? childIdx - 2 : childIdx - 1) / 2;

            while ((parIdx >= 0) && (heap.get(parIdx) > heap.get(childIdx))){
                int temp = heap.get(childIdx);
                heap.set(childIdx, heap.get(parIdx));
                heap.set(parIdx, temp);

                childIdx = parIdx;
                parIdx = (childIdx % 2 == 0 ? childIdx - 2 : childIdx - 1) / 2;
            }
        }

        public int peek(){
            if (heap.isEmpty()){
                throw new NoSuchElementException("heap is empty");
            }
            
            return heap.get(0);
        }

        public int remove(){
            if (heap.isEmpty()){
                throw new NoSuchElementException("heap is empty");
            }

            int data = heap.get(0);

            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            heapify(0);

            return data;
        }

        private void heapify(int i){
            int leftIdx = (2*i)+1;
            int rightIdx = (2*i)+2;
            int minIdx = i;

            if (leftIdx < heap.size() && heap.get(leftIdx) < heap.get(minIdx)){
                minIdx = leftIdx;
            }
            
            if (rightIdx < heap.size() && heap.get(rightIdx) < heap.get(minIdx)){
                minIdx = rightIdx;
            }

            if (minIdx != i){
                int temp = heap.get(minIdx);
                heap.set(minIdx, heap.get(i));
                heap.set(i, temp);

                heapify(minIdx);
            }
        }

        public boolean isEmpty(){
            return heap.isEmpty();
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();

        h.add(5);
        h.add(4);
        h.add(3);
        h.add(2);
        h.add(1);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}