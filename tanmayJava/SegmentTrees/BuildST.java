public class BuildST{
    public static int buildST(int[] arr, int[] st, int s, int e, int i){
        if (s == e) return st[i] = arr[s];

        int mid = s + (e-s)/2;

        int left = buildST(arr, st, s, mid, (2*i) + 1);
        int right = buildST(arr, st, mid+1, e, (2*i) + 2);
        return st[i] = left + right; 
    }
    public static int getSum(int[] st, int[] arr, int qi, int qj){
        return getSumUtil(st, 0, 0, arr.length-1, qi, qj);
    }
    public static int getSumUtil(int[] st, int i, int si, int sj, int qi, int qj){
        if (sj < qi || qj < si){
            return 0;
        }else if (qi <= si && sj <= qj){
            return st[i];
        }else{
            int mid = si + (sj-si)/2;
            int left = getSumUtil(st, i*2 + 1, si, mid, qi, qj);
            int right = getSumUtil(st, i*2 + 2, mid+1, sj, qi, qj);
            return left + right;
        }
    }
    public static void update(int[] st, int[] arr, int i, int val){
        int diff = val - arr[i];
        updateUtil(st, 0, arr.length-1, 0, i, diff);
    }
    public static void updateUtil(int[] st, int si, int sj, int sti, int i, int diff){
        if (i < si || sj < i) return;
        
        st[sti] += diff;
        if (si == sj) return;
        
        int mid = si + (sj-si)/2;
        updateUtil(st, si, mid, sti*2+1, i, diff);
        updateUtil(st, mid+1, sj, sti*2+2, i, diff);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] st = new int[4*arr.length];

        buildST(arr, st, 0, arr.length-1, 0);

        // for (int node : st) System.out.print(node + " ");

        System.out.println(getSum(st, arr, 0, 3));
        update(st, arr, 2, 2);
        System.out.println(getSum(st, arr, 0, 3));
    }
}