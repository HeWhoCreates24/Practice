import java.util.*;

public class BuildPreorderTree{
    public static class Node{
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static class BinaryTree{
        static int i = -1;

        public Node BuildBinaryTree(int[] preorder) {
            i++;
            if(preorder[i] == -1) {
                return null;
            }
            Node newNode = new Node(preorder[i]);
            newNode.left = BuildBinaryTree(preorder);
            newNode.right = BuildBinaryTree(preorder);
            return newNode;
        }

        public void preorderTraversal(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        public void inorderTraversal(Node root) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }

        public void postorderTraversal(Node root) {
            if (root == null) {
                return;
            }
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }

        public void levelorderTraversal(Node root) {

            if (root == null) {
                return;
            }

            Queue <Node> q = new LinkedList<>();

            q.add(root);
            q.add(null);
                
            while (!q.isEmpty()) {
                Node temp = q.remove();
                if (temp != null){
                    System.out.print(temp.data + " ");
                    if (temp.left!= null)
                        q.add(temp.left);
                    if (temp.right!= null)
                        q.add(temp.right);
                }
                else{
                    System.out.println();
                    if (!q.isEmpty()){
                        q.add(null);
                    }
                    else{
                        break;
                    }
                }
            }
        }

        public int height(Node root) {
            if (root == null)
                return 0;
            return 1 + Math.max(height(root.left), height(root.right));
        }

        public int nodeCount(Node root){
            if (root == null){
                return 0;
            }

            return (nodeCount(root.left) + nodeCount(root.right) + 1);
        }

        public int sum(Node root){
            if (root == null){
                return 0;
            }

            return sum(root.left) + sum(root.right) + root.data;
        }
    }
    public static void main(String[] args) {

        int[] preorder = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildBinaryTree(preorder);

        System.out.println("Preorder traversal of constructed binary tree is:");
        tree.preorderTraversal(root);

        System.out.println("\nInorder traversal of constructed binary tree is:");
        tree.inorderTraversal(root);

        System.out.println("\nPostorder traversal of constructed binary tree is:");
        tree.postorderTraversal(root);

        System.out.println("\nLevelorder traversal of constructed binary tree is:");
        tree.levelorderTraversal(root);

        System.out.println("Height of the binary tree is: " + tree.height(root) + " nodes");

        System.out.println("Node count of the binary tree is: " + tree.nodeCount(root));

        System.out.println("Node sum of the binary tree is: " + tree.sum(root));
        
    }
}