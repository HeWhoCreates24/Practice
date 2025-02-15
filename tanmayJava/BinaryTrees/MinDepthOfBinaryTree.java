import java.util.*;
public class MinDepthOfBinaryTree{
    @SuppressWarnings("unused")
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int n){
            data = n;
            left = null;
            right = null;
        }
    }
    public static class BinaryTree{
        // set root
        public Node root;

        public BinaryTree(int n){
            root = new Node(n);
        }
    }
    public static int minDepth(BinaryTree bt){
        Node curr = bt.root;

        if (curr == null) return 0;

        Queue<Node> q = new LinkedList<>();

        q.add(curr);
        q.add(null);
        int depth = 0;

        while (!q.isEmpty()){
            curr = q.remove();

            if (curr == null){
                depth++;
                q.add(null);
                curr = q.remove();
            }

            if (curr.left == null && curr.right == null) break;
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }

        return depth;
    }
    public static void main(String[] args) {
        // make binary tree
        BinaryTree bt = new BinaryTree(1);

        Node root = bt.root;

        root.left = new Node(8);
        root.left.left = new Node(6);
        root.left.right = new Node(5);
        root.right = new Node(2);
        root.right.left = new Node(9);

        System.out.println("Minimum depth of tree : " + minDepth(bt));
    }
}