import java.util.*;
public class MajorityElement{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            System.out.println("enter size of array :");
            int n = sc.nextInt();
            int arr [] =  new int [n];
            System.out.println("enter elements :");
            for (int i = 0; i < n; i++){
                arr [i] = sc.nextInt();
            }
            // moore's voting algorithm
            int major = 0;
            int vote = 0;
            for (int i = 0; i < n; i++){
                if(vote == 0){
                    major = arr [i];
                }
                if (arr [i] == major){
                    vote++;
                }
                else{
                    vote--;
                }
            }
            System.out.println(major);
        }
    }
}