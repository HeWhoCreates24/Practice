import java.util.*;
public class MergeSort{
    public static void mergeSort(int arr [], int st, int en){
        if (st >= en){
            return;
        }
        int mid = st + (en - st) / 2;
        mergeSort(arr, st, mid);
        mergeSort(arr, mid + 1, en);
        merge(arr, st, mid, en);
    }
    public static void merge(int arr[], int st, int mid, int en){
        int temp [] = new int [en - st + 1];
        int i = st;
        int j = mid + 1;
        int k = 0;
        while (i < mid + 1 && j < en + 1){
            if(arr [i] < arr [j]){
                temp [k] = arr [i++];
            }
            else{
                temp [k] = arr [j++];
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
            mergeSort(arr, 0, n-1);
            for (int i = 0; i < n; i++){
                System.out.print(arr [i] + " ");
            }
        }
    }
}