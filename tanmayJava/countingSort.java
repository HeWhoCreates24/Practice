import java.util.*;
public class countingSort{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            //input range
            int minValue, maxValue;
            System.out.print("Enter min value : ");
            minValue = sc.nextInt();
            System.out.print("Enter max value : ");
            maxValue = sc.nextInt();
            //input array
            int n, arr[];
            System.out.print("Enter array size : ");
            n = sc.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++){
                System.out.print("[" + (i + 1) + "] : ");
                arr [i] = sc.nextInt();
            }
            //counting sort
            int valueFreq [] = new int [maxValue - minValue + 1];
            //counting frequencies
            for(int i = 0; i < n; i++){
                valueFreq [arr [i] + minValue]++;
            }
            //sorting array
            int index = 0;
            for (int i = 0; i < valueFreq.length; i++) {
                while (valueFreq[i] > 0) {
                arr[index++] = minValue + i;
                valueFreq[i]--;
                }
            }

            //output array
            for (int i = 0; i < n; i++){
                System.out.println("[" + (i + 1) + "] : " + arr [i]);
            }
        }
    }
}