import java.util.*;
public class QuickSort{
    public static void quickSort(int arr [], int st, int en){
        if (st >= en) return;
        int pivot = arr [en];
        int partIndex = st - 1;
        for (int i = st; i <= en; i++){
            if (arr [i] <= pivot){
                partIndex++;
                int temp = arr [partIndex];
                arr [partIndex] = arr [i];
                arr [i] = temp; 
            }
        }
        quickSort(arr, st, partIndex - 1);
        quickSort(arr, partIndex + 1, en);
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
            quickSort(arr, 0, n-1);
            for (int i = 0; i < n; i++){
                System.out.print(arr [i] + " ");
            }
        }
    }
}