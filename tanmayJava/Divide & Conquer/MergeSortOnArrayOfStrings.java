import java.util.*;
public class MergeSortOnArrayOfStrings{
    public static void mergeSort (String arr [], int st, int en){
        if (st >= en){
            return;
        }
        int mid = st + (en - st) / 2;
        mergeSort(arr, st, mid);
        mergeSort(arr, mid + 1, en);
        merge(arr, st, en, mid);
    }
    public static void merge(String arr [], int st, int en, int mid){
        int i = st;
        int j = mid + 1;
        int k = 0;
        String temp [] = new String [en - st + 1];
        while (i <= mid && j <= en){
            int comp = arr [i].compareTo(arr [j]);
            if (comp < 0){
                temp [k++] = arr [i++];
            }
            else{
                temp [k++] = arr [j++];
            }
        }
        while (i <= mid){
            temp [k++] = arr [i++];
        }
        while (j <= en){
            temp [k++] = arr [j++];
        }
        for (i = st, k = 0; i <= en; i++, k++){
            arr [i] = temp [k];
        }
    }
    public static void main (String[] args) {
        try (Scanner sc = new Scanner (System.in)){
            System.out.println ("Enter array size :");
            int n = sc.nextInt();
            String arr [] = new String [n];
            for (int i = 0; i < n; i++){
                arr [i] = sc.next();
            }
            mergeSort(arr, 0, n - 1);
            for (int i = 0; i < n; i++){
                System.out.println(arr [i]);
            }
        }
    }
}