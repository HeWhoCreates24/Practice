import java.util.*;
public class insertionSort{
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int arr [], n;
            System.out.println("Enter size of array");
            n = sc.nextInt();
            arr = new int [n];
            System.out.println("Enter array elements");
            for(int i = 0; i < n; i++){
                System.out.print("[" + (i + 1) + "]");
                arr [i] = sc.nextInt();
            }
            for(int i = 1; i < n; i++){
                int j = i - 1;
                boolean ins = false;
                int temp = arr [i];
                while(!ins && j >= 0){
                    if (arr [j] > temp){
                        if (j > 0){
                            arr [j + 1] = arr [j--];
                        }
                        else {
                            arr [j + 1] = arr [j];
                            arr [j] = temp;
                            ins = true;
                        }
                    }
                    else {
                        arr [j + 1] = temp;
                        ins = true;
                    }
                }
            }
            for(int i = 0; i < n; i++){
                System.out.println("[" + (i + 1) + "] -> " + arr [i]);
            }
        }
    }
}