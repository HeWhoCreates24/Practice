public class PrefixProblem{
    public static class Node{
        Node[] children;
        boolean isEOW;
        int prefCount;

        public Node(){
            children = new Node[26];
            isEOW = false;
            prefCount = 0;
        }
    }
    public static class Trie{
        public Node root;

        public Trie(){
            root = new Node();
        }
        public void insert(String str){
            Node curr = root;
            for (char ch : str.toCharArray()){
                int idx = ch - 'a';
                if (curr.children[idx] == null){
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
                curr.prefCount++;
            }
            curr.isEOW = true;
        }
    }
    public static String prefix(String str, Trie tr){
        StringBuilder sb = new StringBuilder();
        Node curr = tr.root;

        for (char ch : str.toCharArray()){
            int idx = ch - 'a';
            if (curr.prefCount == 1) break;
            sb.append(ch);
            curr = curr.children[idx];
        }
        return sb.toString();
    }
    public static String[] uniquePrefixes(String[] arr){
        Trie tr = new Trie();
        for (String str : arr){
            tr.insert(str);
        }

        String[] ans = new String[arr.length];
        for (int i = 0; i < arr.length; i++){
            ans[i] = prefix(arr[i], tr);
        }

        return ans;
    }
    public static void main(String[] args) {
        String[] arr = {"zebra", "dog", "duck", "dove"};
        String[] ans = uniquePrefixes(arr);

        for (String str : ans){
            System.out.println(str);
        }
    }
}