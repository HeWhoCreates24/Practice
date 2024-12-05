import java.util.*;
public class selectionSort{
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            //input array
            int arr [], n;
            System.out.println("Enter size of array");
            n = sc.nextInt();
            arr = new int [n];
            for(int i = 0; i < n; i++){
                System.out.print("[" + (i + 1) + "] : ");
                arr [i] = sc.nextInt();
            }
            //selection sort
            int srtd = 0;
            while(srtd < n){
                //find min
                int mn = srtd;
                for(int i = srtd; i < n; i++){
                    mn = arr [mn] > arr [i] ? i : mn;
                }
                //swap and increment
                int temp = arr [srtd];
                arr [srtd++] = arr [mn];
                arr [mn] = temp;
            }
            //output array
            for(int i = 0; i < n; i++){
                System.out.println("[" + (i + 1) + "] : " + arr [i]);
            }
        }
    }
}