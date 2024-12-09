import java.util.*;
public class NumberOfNsInArray{
    public static void occured(int arr [], int target, int index){
        if (index != arr.length){
            if (arr [index] == target){
                System.out.println(index + " ");
            }
            occured(arr, target, ++index);
        }

    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter size of array :");
            int n = sc.nextInt();
            int arr [] = new int [n];
            System.out.println("Enter elements");
            for (int i = 0; i < n; i++){
                arr [i] = sc.nextInt();
            }
            System.out.println("Enter target :");
            int target = sc.nextInt();
            occured(arr, target, 0);
        }
    }
}