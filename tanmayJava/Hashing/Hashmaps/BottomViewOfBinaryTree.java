import java.util.*;

public class BottomViewOfBinaryTree {
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static class Pair {
        Node node;
        int hd, level;

        public Pair(Node node, int hd, int level) {
            this.node = node;
            this.hd = hd;
            this.level = level;
        }
    }

    public static class BinaryTree {
        Node root;

        public BinaryTree(int data) {
            this.root = new Node(data);
        }

        public void inorder(Node node) {
            if (node == null) return;
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }

        public void bottomView() {
            if (root == null) return;

            TreeMap<Integer, Pair> bvMap = new TreeMap<>();
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(root, 0, 0));

            while (!queue.isEmpty()) {
                Pair temp = queue.poll();
                Node node = temp.node;
                int hd = temp.hd;
                int level = temp.level;

                // Update map only if the level is greater or equal (latest seen node)
                if (!bvMap.containsKey(hd) || bvMap.get(hd).level <= level) {
                    bvMap.put(hd, new Pair(node, hd, level));
                }

                if (node.left != null) {
                    queue.add(new Pair(node.left, hd - 1, level + 1));
                }

                if (node.right != null) {
                    queue.add(new Pair(node.right, hd + 1, level + 1));
                }
            }

            for (Pair p : bvMap.values()) {
                System.out.print(p.node.data + " ");
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(3);
        Node root = bt.root;
        root.left = new Node(1);
        root.left.left = new Node(0);
        root.left.right = new Node(2);
        root.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        bt.inorder(root);
        System.out.println();
        bt.bottomView();
    }
}
