
import java.util.*;

public class PracticeQues {
    public static class BinaryTree<T> {
        public static class Node<T> {
            T data;
            Node<T> right;
            Node<T> left;

            public Node(T data) {
                this.data = data;
            }
        }

        private Node<T> root;
        private int size;

        public BinaryTree() {
            root = null;
            size = 0;
        }

        public Node<T> getRoot() {
            return root;
        }

        public int getSize() {
            return size;
        }

        public void setWithPreorder(T[] arr) {
            root = preorderHelper(arr, new int[]{0});
        }

        private Node<T> preorderHelper(T[] arr, int[] i) {
            if (i[0] >= arr.length || arr[i[0]] == null) {
                i[0]++;
                return null;
            }

            Node<T> newNode = new Node<>(arr[i[0]]);
            size++;
            i[0]++;

            newNode.left = preorderHelper(arr, i);
            newNode.right = preorderHelper(arr, i);

            return newNode;
        }

        public void printTree(Node<T> node, String prefix, boolean isLeft) {
            if (node != null) {
                System.out.println(prefix + (isLeft ? "|--> " : "+--> ") + node.data);
                
                printTree(node.left, prefix + (isLeft ? "|    " : "     "), true);
                printTree(node.right, prefix + (isLeft ? "|    " : "     "), false);
            }
        }

        public boolean isUnivalued() {
            if (root == null) return true;
            return isUnivaluedHelper(root, root.data);
        }

        private boolean isUnivaluedHelper(Node<T> node, T value) {
            if (node == null) return true;
            if (!node.data.equals(value)) return false;
            return isUnivaluedHelper(node.left, value) && isUnivaluedHelper(node.right, value);
        }

        public void invert(){
            if (root != null) invertHelper(root);
        }

        private void invertHelper(Node<T> node){
            Node<T> temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) invertHelper(node.left);
            if (node.right != null) invertHelper(node.right);

        }

        public void deleteLeavesOfX(Node<T> node, T x){
            if (root.data == x && root.left == null && root.right == null){
                root = null;
                return;
            }

            if (node.left != null && node.left.data == x && node.left.left == null && node.left.right == null){
                node.left = null;
            }

            if (node.right != null && node.right.data == x && node.right.left == null && node.right.right == null){
                node.right = null;
            }

            if (node.left != null) deleteLeavesOfX(node.left, x);
            if (node.right != null) deleteLeavesOfX(node.right, x);
        }

        private HashMap<String, Integer> map;

        public ArrayList<T> findDuplicateSubtrees(){
            ArrayList <T> duplicates = new ArrayList<>();

            if (root == null) return duplicates;

            map = new HashMap<>();

            findDuplicatesHelper(root, duplicates);

            return duplicates;
        }

        private String findDuplicatesHelper(Node<T> node, ArrayList<T> arr){
            if (node == null) return "";

            String str = "(" + findDuplicatesHelper(node.left, arr) + ")(" + node.data + ")(" + findDuplicatesHelper(node.right, arr) + ")";

            if (map.containsKey(str) && map.get(str) == 1){
                arr.add(node.data);
            }else{
                map.put(str, 1);
            }

            return str;
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.setWithPreorder(new Integer[]{1, 2, 4, 3, 6, null, null, null, 2, 4, null, null, null, 5, null, null, 3, 6, null, null, 4, null, null});
        
        tree.printTree(tree.getRoot(), "", true);

        // if (tree.isUnivalued()) {
        //     System.out.println("\nThe tree is univalued.");
        // } else {
        //     System.out.println("\nThe tree is not univalued.");

        // tree.invert();

        // tree.deleteLeavesOfX(tree.getRoot(), 5);
        // tree.deleteLeavesOfX(tree.getRoot(), 3);

        System.out.println(tree.findDuplicateSubtrees());

        // tree.printTree(tree.getRoot(), "", true);

        }
    }
