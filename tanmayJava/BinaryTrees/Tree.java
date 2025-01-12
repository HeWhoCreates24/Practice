import java.util.*;

public class Tree{
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

        public int[] heightDiameter(Node root){

            int[] info = new int[2];

            if (root == null){
                info[0] = 0;
                info[1] = 0;
                return info;
            }

            int[] left = heightDiameter(root.left);
            int[] right = heightDiameter(root.left);

            info[1] = Math.max(left[0] + right[0] + 1, Math.max(left[1], right[1]));
            info[0] = Math.max(left[0], right[0]) + 1;

            return info;

        }

        public Node findSubRoot(Node root, Node subRoot){
            if (root == null){
                return null;
            }

            if (root.data == subRoot.data){
                return root;
            }

            Node right = findSubRoot(root.left, subRoot);
            if (right != null) return right;
            return findSubRoot(root.right, subRoot);
        }

        public boolean identicalOrNot(Node n, Node subRoot){

            if (n == null || subRoot == null){
                return n == subRoot;
            }

            if (n.data != subRoot.data){
                return false;
            }

            if (!identicalOrNot(n.left, subRoot.left)){
                return false;
            }

            return identicalOrNot(n.right, subRoot.right);
        }

        public boolean subTreeOfAnotherTree(Node root, Node subRoot){
            Node n = findSubRoot(root, subRoot);

            if (n == null){
                return false;
            }

            return identicalOrNot(n, subRoot);
        }

        public class Info{
            Node node;
            int hd;

            public Info(Node node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }

        public void topView(Node root){

            if (root == null) return;

            Queue <Info> q = new LinkedList<>();
            HashMap <Integer, Integer> map = new HashMap<>();

            int minHd = 0;
            int maxHd = 0;

            q.add(new Info(root, 0));
            q.add(null);

            while (!q.isEmpty()){

                Info curr = q.remove();

                if (curr == null){
                    if (q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                        continue;
                    }
                }

                if (!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node.data);
                }

                if (curr.node.left != null){
                    minHd--;
                    q.add(new Info(curr.node.left, curr.hd - 1));
                }

                if (curr.node.right != null){
                    maxHd++;
                    q.add(new Info(curr.node.right, curr.hd + 1));
                }

            }

            for (int i = minHd; i < maxHd; i++){
                System.out.print(map.get(i) + " ");
            }

        }
    
        public void kthLevel(Node root, int curr, int target){

            if (root == null){
                return;
            }

            if (curr == target){

                System.out.print(root.data + " ");
                return;

            }
            else{

                kthLevel(root.left, curr + 1 , target);
                kthLevel(root.right, curr + 1 , target);
                return;

            }

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

        System.out.println("Node count of the binary tree is: " + tree.nodeCount(root));

        System.out.println("Node sum of the binary tree is: " + tree.sum(root));

        System.out.println("Height of the binary tree is: " + tree.heightDiameter(root)[0] + " nodes");

        System.out.println("Diameter of the binary tree is: " + tree.heightDiameter(root)[1] + " nodes");

        Node subRoot = root.left;

        System.out.println(tree.subTreeOfAnotherTree(root, subRoot));

        tree.topView(root);

        System.out.println();
        
        tree.kthLevel(root, 1, 3);
        
    }
}