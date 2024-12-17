public class BacktrackArray{
    public static void btArray(int [] arr, int i, int prev){
        if (i == arr.length){
            for (int j = 0; j < arr.length; j++){
                System.out.print(arr [j] + " ");
            }
            System.out.println();
            return;
        }
        arr [i] = i + 1;
        btArray(arr, i + 1, i);
        arr [i] -= 2;
    }
    public static void main(String[] args) {
        int [] arr = new int [10];
        btArray(arr, 0, -1);
        for (int j = 0; j < arr.length; j++){
            System.out.print(arr [j] + " ");
        }
        System.out.println();
    }
}