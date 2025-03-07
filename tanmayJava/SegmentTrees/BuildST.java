public class BuildST{
    public static int buildST(int[] arr, int[] st, int s, int e, int i){
        if (s == e) return st[i] = arr[s];

        int mid = s + (e-s)/2;

        int left = buildST(arr, st, s, mid, (2*i) + 1);
        int right = buildST(arr, st, mid+1, e, (2*i) + 2);
        return st[i] = left + right; 
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] st = new int[4*arr.length];

        buildST(arr, st, 0, arr.length-1, 0);

        for (int node : st) System.out.print(node + " ");
    }
}