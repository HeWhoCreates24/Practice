public class TrieImplementation {
    public static class Node {
        Node[] children;
        boolean isEOW;

        public Node() {
            this.children = new Node[26]; // Java initializes elements to null
            this.isEOW = false;
        }
    }

    public static class Trie {
        Node root;

        public Trie() {
            root = new Node(); // Root does not store a character
        }

        public void insert(String str) {
            insertHelper(root, str, 0);
        }

        private void insertHelper(Node node, String str, int i) {
            if (i == str.length()) {
                node.isEOW = true;
                return;
            }
            char ch = str.charAt(i);
            int idx = ch - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new Node();
            }
            insertHelper(node.children[idx], str, i + 1);
        }

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
    }

    public static void main(String[] args) {
        Trie t = new Trie();

        t.insert("tanmay");
        t.insert("tantan");
        t.insert("tararara");
        t.insert("tax");
        t.insert("tantrums");

        t.printAll();
    }
}
