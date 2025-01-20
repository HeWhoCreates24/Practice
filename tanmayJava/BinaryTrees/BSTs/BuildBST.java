
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

        public ArrayList<Integer> inorderArray(Node node, ArrayList<Integer> arr){
            if (node == null) return arr;

            inorderArray(node.left, arr);
            arr.add(node.data);
            inorderArray(node.right, arr);

            return arr;
        }

        public Node toBalancedBST(Node node){
            ArrayList<Integer> al = new ArrayList<>();
            al = inorderArray(node, al);
            int[] arr = new int[al.size()];
            for (int i = 0; i < al.size(); i++){
                arr[i] = al.get(i);
            }

            return balancedBST(arr, 0, arr.length-1);
        }

        public int sizeOf(Node node, int size){
            if (node == null) return 0;

            return sizeOf(node.left, size) + sizeOf(node.right, size) + 1;
        }

        public int sizeOfLargestBSTinBT(Node node){
            if (node == null) return 0;

            if (validBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)){
                return sizeOf(node, 0);
            }

            return (Math.max(sizeOfLargestBSTinBT(node.left), sizeOfLargestBSTinBT(node.right)));
        }

        public Node mergeBSTs(Node r1, Node r2){
            if (r1 == null || r2 == null) return (r1 == null ? r2 : r1);

            ArrayList<Integer> a1 = new ArrayList<>();
            a1 = inorderArray(r1, a1);
            ArrayList<Integer> a2 = new ArrayList<>();
            a2 = inorderArray(r2, a2);

            ArrayList<Integer> mergeArr = new ArrayList<>();

            int i = 0, j = 0;

            while (i < a1.size() && j < a2.size()){

                int ele1 = a1.get(i);
                int ele2 = a2.get(j);

                if (ele1 < ele2){
                    mergeArr.add(ele1);
                    i++;
                }else{
                    mergeArr.add(ele2);
                    j++;
                }
            }


            while (i < a1.size()){
                mergeArr.add(a1.get(i));
                i++;
            }

            while (j < a2.size()){
                mergeArr.add(a2.get(j));
                j++;
            }

            int[] merged = new int[mergeArr.size()];

            for (i = 0; i < mergeArr.size(); i++){
                merged[i] = mergeArr.get(i);
            }

            return balancedBST(merged, 0, merged.length-1);
        }

        public int rangeSum(Node node, int l, int r) {
             return rangeSumHelper(node, l, r, 0);
        }

        private int rangeSumHelper(Node node, int l, int r, int sum) {
            if (node == null) {
                return sum;
            }

            if (node.data >= l && node.data <= r) {
                sum += node.data;
                sum = rangeSumHelper(node.right, l, r, sum);
                sum = rangeSumHelper(node.left, l, r, sum);
            } else if (node.data < l) {
                sum = rangeSumHelper(node.right, l, r, sum);
            } else {
                sum = rangeSumHelper(node.left, l, r, sum);
            }

            return sum;
        }

        public int closestTo(int k){
            if (root == null) return -1;

            return k - closestHelper(root, k, Integer.MAX_VALUE);
        }

        private int closestHelper(Node node, int k, int minDiff){
            if (node == null) return minDiff;

            if (Math.abs(node.data - k) < minDiff){
                minDiff = k - node.data;
            }

            return Math.min(closestHelper(node.left, k, minDiff), closestHelper(node.right, k, minDiff));
        }

        public int kthSmalestElement(Node node, int k){
            ArrayList<Integer> arr = new ArrayList<>();
            arr = inorderArray(node, arr);
            return arr.get(k-1);
        }

        public Node greaterSumTree(Node node){
            ArrayList<Integer> arr = new ArrayList<>();
            arr = inorderArray(node, arr);

            int[] maxArr = new int[arr.size()];
            int sum = 0;

            for (int i = arr.size() - 1; i >= 0; i--){
                maxArr[i] = sum;
                sum += arr.get(i);
            }

            return balancedBST(maxArr, 0, maxArr.length - 1);
        }


    }
    public static void main(String[] args) {
        BST tree = new BST(new int[]{5, 3, 7, 2, 4, 6, 8});

        tree.printTree(tree.root, "", true);

        tree.root = tree.greaterSumTree(tree.root);

        tree.printTree(tree.root, "", true);

        // System.err.println(tree.kthSmalestElement(tree.root, 3));

        // System.out.println(tree.closestTo(7));

        // System.out.println(tree.rangeSum(tree.root, 3, 15));

        // tree.printTree(tree.root, "", true);
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

        // tree.root = tree.balancedBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, 0, 19);

        // tree.root.right.right = tree.toBalancedBST(tree.root.right.right);

        // tree.printTree(tree.root, "", true);

        // System.out.println(tree.sizeOfLargestBSTinBT(tree.root));

        // Node r1 = new Node(2);
        // Node r2 = new Node(9);

        // r1.right = new Node(4);
        // r1.left = new Node(1);

        // r2.right = new Node(12);
        // r2.left = new Node(3);

        // // tree.printTree(r1, "", true);
        // // tree.printTree(r2, "", true);

        // tree.printTree(tree.mergeBSTs(r1, r2), "", true);

    }
}