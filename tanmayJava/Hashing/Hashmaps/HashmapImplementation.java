import java.util.*;

public class HashmapImplementation{
    @SuppressWarnings("unchecked")
    public static class HashMap<K,V>{
        public class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        LinkedList<Node>[] buckets;
        int n;
        int N;

        public HashMap(){
            buckets = new LinkedList[4];
            n = 0;
            N = 4;

            for (int i = 0; i < N; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashIndex(K key){
            int hi = key.hashCode();
            return Math.abs(hi) % N;
        }

        private int nodeIndex(int hi, K key){
            var ll = buckets[hi];
            int ni = 0;
            for (Node node : ll){
                if (node.key == key) return ni;
                else ni++;
            }
            return -1;
        }

        private void rehash(){
            var oldBuckets = buckets;
            buckets = new LinkedList[N*2];
            N = N*2;

            for (int i = 0; i < N; i++){
                buckets[i] = new LinkedList<>();
            }

            for (LinkedList<Node> ll : oldBuckets){
                for (Node node : ll){
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int hi = hashIndex(key);
            int ni = nodeIndex(hi, key);

            if (ni != -1){
                buckets[hi].get(ni).value = value;
            }
            else{
                buckets[hi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n/N;

            if (lambda >= 2.0){
                rehash();
            }
        }

        public V get(K key){
            int hi = hashIndex(key);
            int ni = nodeIndex(hi, key);

            if (ni != -1){
                return buckets[hi].get(ni).value;
            }
            else{
                return null;
            }
        }

        public V remove(K key){
            int hi = hashIndex(key);
            int ni = nodeIndex(hi, key);

            if (ni != -1){
                Node node = buckets[hi].remove(ni);
                n--;
                return node.value;
            }
            else{
                return null;
            }
        }

        public boolean containsKey(K key){
            int hi = hashIndex(key);
            int ni = nodeIndex(hi, key);

            return ni != -1;
        }

    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("ieurg", 18);
        hm.put("ergerg", 21);
        hm.put("fdiweugfw", 55);
        hm.put("efdweh8f", -1021);

        System.out.println(hm.get("ergerg"));
    }
}