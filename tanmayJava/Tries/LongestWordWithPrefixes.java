import java.util.*;

public class LongestWordWithPrefixes {
    public static class Node {
        Node[] children;
        boolean isEOW;

        public Node() {
            children = new Node[26];
            isEOW = false;
        }
    }

    public static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String str) {
            Node curr = root;

            for (char ch : str.toCharArray()) {
                int idx = ch - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }

                curr = curr.children[idx];
            }

            curr.isEOW = true; // Fix: Mark the end of the word properly
        }
    }

    public static String longestAllPref(String[] words) {
        Trie t = new Trie();

        // Sorting ensures lexicographical order in case of ties
        Arrays.sort(words);

        for (String word : words) {
            t.insert(word);
        }

        // Reset fin to avoid issues with multiple function calls
        findLongestWord(t.root, "");

        return longestWord;
    }

    private static String longestWord = ""; // Global variable for tracking longest valid word

    private static void findLongestWord(Node node, String temp) {
        if (node == null) return;

        if (temp.length() > longestWord.length()) {
            longestWord = temp;
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null && node.children[i].isEOW) {
                findLongestWord(node.children[i], temp + (char) ('a' + i));
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "applye"};

        System.out.println(longestAllPref(words)); // Expected Output: "apple"
    }
}
