public class UnivaluedOrNot {
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
            // Base case: If the index is out of bounds or the value is null, return null
            if (i[0] >= arr.length || arr[i[0]] == null) {
                i[0]++;
                return null;
            }

            // Create the new node
            Node<T> newNode = new Node<>(arr[i[0]]);
            size++;
            i[0]++;

            // Recursively assign left and right children
            newNode.left = preorderHelper(arr, i);
            newNode.right = preorderHelper(arr, i);

            return newNode;
        }

        // Function to print the tree
        public void printTree(Node<T> node, String prefix, boolean isLeft) {
            if (node != null) {
                // Print the current node
                System.out.println(prefix + (isLeft ? "|--> " : "+--> ") + node.data);
                
                // Recursively print left and right children
                printTree(node.left, prefix + (isLeft ? "|    " : "     "), true);
                printTree(node.right, prefix + (isLeft ? "|    " : "     "), false);
            }
        }

        // Check if the tree is univalued
        public boolean isUnivalued() {
            if (root == null) return true;
            return isUnivaluedHelper(root, root.data);
        }

        private boolean isUnivaluedHelper(Node<T> node, T value) {
            if (node == null) return true;
            if (!node.data.equals(value)) return false;
            return isUnivaluedHelper(node.left, value) && isUnivaluedHelper(node.right, value);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        // Sample tree: {1, 2, 4, null, null, 5, null, null, 3, 6, null, null, null}
        tree.setWithPreorder(new Integer[]{1, 2, 4, null, null, 5, null, null, 3, 6, null, null, null});
        
        // Printing the tree structure
        tree.printTree(tree.getRoot(), "", true);

        // Check if the tree is univalued
        if (tree.isUnivalued()) {
            System.out.println("The tree is univalued.");
        } else {
            System.out.println("The tree is not univalued.");
        }
    }
}
