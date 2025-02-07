public class StartsWithProblem{
    public static class Node{
        Node[] children;

        public Node(){
            children = new Node[26];
        }
    }
    public static class Trie{
        Node root;

        public Trie(){
            root = new Node();
        }

        public void insert(String str){
            Node curr = root;
            for (char ch : str.toCharArray()){
                int idx = ch - 'a';
                if (curr.children[idx] == null) curr.children[idx] = new Node();
                curr = curr.children[idx];
            }
        }
    }
    public static boolean hasPref(String pref, String[] words){
        Trie t = new Trie();
        for (String word : words){
            t.insert(word);
        }

        Node curr = t.root;
        for (char ch : pref.toCharArray()){
            int idx = ch - 'a';
            if (curr.children[idx] == null) return false;
            else curr = curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words = {"apple", "app", "mango", "man", "woman"};
        String pref = "mang";
        
        if (hasPref(pref, words)){
            System.out.println("prefix " + pref + " found");
        }else{
            System.out.println("prefix " + pref + " NOT found");
        }
    }
}