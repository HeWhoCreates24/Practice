public class MinMaxST {
    public static class Pair {
        int min;
        int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static final class ST {
        Pair[] st;
        int arrLength;

        public ST(int[] arr) {
            arrLength = arr.length;
            st = new Pair[arr.length * 4];
            buildST(arr, 0, arr.length - 1, 0);
        }

        private Pair buildST(int[] arr, int si, int sj, int i) {
            if (si == sj) {
                return st[i] = new Pair(arr[si], arr[si]);
            }

            int mid = si + (sj - si) / 2;
            Pair left = buildST(arr, si, mid, i * 2 + 1);
            Pair right = buildST(arr, mid + 1, sj, i * 2 + 2);

            return st[i] = new Pair(Math.min(left.min, right.min), Math.max(left.max, right.max));
        }

        public int getMax(int qi, int qj) {
            if (qi < 0 || qj >= arrLength || qi > qj) {
                System.out.println("Invalid Query Range for getMax()");
                return Integer.MIN_VALUE;
            }
            return getMaxUtil(0, 0, arrLength - 1, qi, qj);
        }

        private int getMaxUtil(int sti, int si, int sj, int qi, int qj) {
            if (qj < si || sj < qi) {
                return Integer.MIN_VALUE;
            }
            if (qi <= si && sj <= qj) {
                return st[sti].max;
            }
            int mid = si + (sj - si) / 2;
            return Math.max(getMaxUtil(sti * 2 + 1, si, mid, qi, qj),
                            getMaxUtil(sti * 2 + 2, mid + 1, sj, qi, qj));
        }

        public int getMin(int qi, int qj) {
            if (qi < 0 || qj >= arrLength || qi > qj) {
                System.out.println("Invalid Query Range for getMin()");
                return Integer.MAX_VALUE;
            }
            return getMinUtil(0, 0, arrLength - 1, qi, qj);
        }

        private int getMinUtil(int sti, int si, int sj, int qi, int qj) {
            if (qj < si || sj < qi) {
                return Integer.MAX_VALUE;
            }
            if (qi <= si && sj <= qj) {
                return st[sti].min;
            }
            int mid = si + (sj - si) / 2;
            return Math.min(getMinUtil(sti * 2 + 1, si, mid, qi, qj),
                            getMinUtil(sti * 2 + 2, mid + 1, sj, qi, qj));
        }

        public void update(int i, int val){
            updateUtil(0, 0, arrLength-1, i, val);
        }

        private Pair updateUtil(int sti, int si, int sj, int i, int val) {
            // Base Case: If `i` is out of range, return current node
            if (i < si || i > sj) {
                return st[sti];
            }

            // Leaf node update
            if (si == sj) {
                return st[sti] = new Pair(val, val);
            }

            int mid = si + (sj - si) / 2;

            // Update only affected subtree
            if (i <= mid) {
                updateUtil(sti * 2 + 1, si, mid, i, val);
            } else {
                updateUtil(sti * 2 + 2, mid + 1, sj, i, val);
            }

            // Recalculate min/max for current node after update
            return st[sti] = new Pair(
                Math.min(st[sti * 2 + 1].min, st[sti * 2 + 2].min),
                Math.max(st[sti * 2 + 1].max, st[sti * 2 + 2].max)
            );
        }


        public void printST() {
            for (Pair node : st) {
                if (node != null) {
                    System.out.print("(" + node.min + "," + node.max + ") ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        ST st = new ST(arr);
        st.printST();

        System.out.println("Max in range [2, 4]: " + st.getMax(2, 4));
        System.out.println("Min in range [2, 4]: " + st.getMin(2, 4));

        // Edge cases
        System.out.println("Max in range [-1, 4]: " + st.getMax(-1, 4)); // Invalid
        System.out.println("Min in range [5, 10]: " + st.getMin(5, 10)); // Invalid

        // Updates
        st.update(2, 42);
        st.update(4, -17);
        System.out.println("Max in range [2, 4]: " + st.getMax(2, 4));
        System.out.println("Min in range [2, 4]: " + st.getMin(2, 4));
    }
}
