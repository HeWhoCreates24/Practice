
import java.util.ArrayList;


public class BuildBST{
    public static class Node{
        public int data;
        public Node left, right;

        public Node(int value){
            data = value;
            left = right = null;
        }
    }
    public static class BST{
        Node root;

        public BST(int[] arr){
            root = null;
            for (int i = 0; i < arr.length; i++){
                root = buildBST(root, arr[i]);
            }
        }

        private Node buildBST(Node node, int data){
            if (node == null){
                node = new Node(data);
                return node;
            }

            if (node.data < data){
                node.right = buildBST(node.right, data);
            }
            else{
                node.left = buildBST(node.left, data);
            }

            return node;
        }

        public void printTree(Node node, String prefix, boolean isLeft) {
            if (node != null) {
                System.out.println(prefix + (isLeft ? "|--> " : "+--> ") + node.data);
                
                printTree(node.left, prefix + (isLeft ? "|    " : "     "), true);
                printTree(node.right, prefix + (isLeft ? "|    " : "     "), false);
            }
        }

        public void inorder(Node node){
            if (node.left != null) inorder(node.left);
            System.out.print(node.data + " ");
            if (node.right != null) inorder(node.right);
        }

        public boolean search(Node node, int data){
            if(node == null) return false;

            if (node.data == data) return true;

            if (node.data < data){
                return search(node.right, data);
            }else{
                return search(node.left, data);
            }
        }

        public Node delete(Node node, int data){
            if (node == null) return null;

            if (node.data == data){
                if (node.left == null && node.right == null){
                    return null;
                }

                if (node.left == null){
                    return node.right;
                }

                if (node.right == null){
                    return node.left;
                }

                else{
                    Node IS = findInorderSuccessor(node.right);
                    node.data = IS.data;
                    node.right = delete(IS, IS.data);
                    return node;
                }
            }

            if (node.data < data){
                node.right = delete(node.right, data);
                return node;
            }
            else{
                node.left = delete(node.left, data);
                return node;
            }
        }

        public Node findInorderSuccessor(Node node){
            while (node.left != null){
                node = node.left;
            }
            return node;
        }

        public void printInRange(Node node, int k1, int k2){
            if (node == null) return;

            if (node.data >= k1 && node.data <= k2){
                printInRange(node.left, k1, k2);
                System.out.print(node.data + " ");
                printInRange(node.right, k1, k2);
                return;
            }

            if (node.data < k1){
                printInRange(node.right, k1, k2);
                return;
            }

            if (node.data > k2){
                printInRange(node.left, k1, k2);
            }
        }

        ArrayList<Integer> path = new ArrayList<>();

        public void allPaths(Node node){
            if (node == null) return;

            path.addLast(node.data);

            if (node.left == null && node.right == null){
                printPath(path);
                path.removeLast();
                return;
            }

            if (node.left != null){
                allPaths(node.left);
            }

            if (node.right != null){
                allPaths(node.right);
            }

            path.removeLast();
        }

        public void printPath(ArrayList<Integer> p){
            for (int n : p){
                System.out.print(n + " ");
            }
            System.out.println();
        }

        public boolean validBST(Node node, int min, int max){
            if (node == null) return true;

            if (node.data <= min || node.data >= max){
                return false;
            }

            return validBST(node.left, min, node.data) && validBST(node.right, node.data, max);
        }

        public void mirror(Node node){
            if (node == null) return;

            Node temp = node.left;
            node.left = node.right;
            node.right = temp;

            mirror(node.right);
            mirror(node.left);
        }

        public Node balancedBST(int[] arr, int st, int en){
            if (st > en) return null;

            int mid = st + (en-st)/2;

            Node newNode = new Node(arr[mid]);

            newNode.left = balancedBST(arr, st, mid-1);
            newNode.right = balancedBST(arr, mid+1, en);

            return newNode;
        }
    }
    public static void main(String[] args) {
        BST tree = new BST(new int[]{3, 6, 1, 2, 0, 11, 24, 7});

        tree.printTree(tree.root, "", true);
        // tree.inorder(tree.root);

        // System.out.println(tree.search(tree.root, 4));
        // System.out.println(tree.search(tree.root, 24));

        // tree.inorder(tree.root);
        // tree.delete(tree.root, 1);
        // tree.delete(tree.root, 6);
        // System.out.println();
        // tree.inorder(tree.root);
        // System.out.println();

        // tree.printTree(tree.root, "", true);

        // tree.printInRange(tree.root, 5, 25);

        // tree.allPaths(tree.root);

        // System.out.println(tree.validBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        // tree.mirror(tree.root);

        tree.root = tree.balancedBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, 0, 19);

        tree.printTree(tree.root, "", true);

    }
}