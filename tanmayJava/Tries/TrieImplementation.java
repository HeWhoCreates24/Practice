public class TrieImplementation {
    public static class Node {
        Node[] children;
        boolean isEOW;

        public Node() {
            this.children = new Node[26];
            this.isEOW = false;
        }
    }

    public static class Trie {
        private final Node root;

        public Trie() {
            root = new Node();
        }

        // Iterative insert method (avoids recursion overhead)
        public void insert(String word) {
            Node current = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (current.children[idx] == null) {
                    current.children[idx] = new Node();
                }
                current = current.children[idx];
            }
            current.isEOW = true;
        }

        // Search method to check if a word exists in Trie
        public boolean search(String word) {
            Node current = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (current.children[idx] == null) {
                    return false;
                }
                current = current.children[idx];
            }
            return current.isEOW;
        }

        // DFS-based printAll method (avoids deep recursion)
        public void printAll() {
            printAllHelper(root, new StringBuilder());
        }

        private void printAllHelper(Node node, StringBuilder sb) {
            if (node.isEOW) {
                System.out.println(sb.toString());
            }

            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    sb.append((char) ('a' + i));
                    printAllHelper(node.children[i], sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        public boolean wordBreak(String str){
            if (str.length() == 0) return true;
            for (int i = 0; i < str.length(); i++){
                if ((search(str.substring(0, i+1))) && (wordBreak(str.substring(i+1)))){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Trie t = new Trie();

        t.insert("tanmay");
        t.insert("tantan");
        t.insert("tararara");
        t.insert("tax");
        t.insert("tantrums");

        // Print all words in Trie
        t.printAll();

        // Test search method
        System.out.println("\nSearch results:");
        System.out.println("Search 'tanmay': " + t.search("tanmay")); // true
        System.out.println("Search 'tantrum': " + t.search("tantrum")); // false
        System.out.println("Search 'tax': " + t.search("tax")); // true

        // Word break
        String str = "tantantax";
        System.out.println("\n"+t.wordBreak(str));
    }
}
