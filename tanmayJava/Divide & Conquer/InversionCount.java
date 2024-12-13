import java.util.*;
public class InversionCount{
    public static int mergeSort(int arr [], int st, int en){
        int count = 0;
        if (st >= en){
            return count;
        }
        int mid = st + (en - st) / 2;
        int leftCount = mergeSort(arr, st, mid);
        int rightCount = mergeSort(arr, mid + 1, en);
        count = merge(arr, st, mid, en);
        return (leftCount + rightCount + count);
    }
    public static int merge(int arr[], int st, int mid, int en){
        int count = 0;
        int temp [] = new int [en - st + 1];
        int i = st;
        int j = mid + 1;
        int k = 0;
        while (i < mid + 1 && j < en + 1){
            if(arr [i] <= arr [j]){
                temp [k] = arr [i++];
            }
            else{
                temp [k] = arr [j++];
                count += (mid + 1 - i);
            }
            k++;
        }
        while (i < mid + 1){
            temp [k++] = arr [i++];
        }
        while (j < en + 1){
            temp [k++] = arr [j++];
        }
        for (k = 0, i = st; k < temp.length; k++, i++){
            arr [i] = temp [k];
        }
        return count;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter size of array :");
            int n = sc.nextInt();
            int arr [] = new int [n];
            System.out.println("Enter " + n + " elements :");
            for (int i = 0; i < n; i++){
                arr [i] = sc.nextInt();
            }
            int inversionCount = mergeSort(arr, 0, n-1);
            System.out.println(inversionCount);
        }
    }
}