import java.util.*;
public class numberPattern{
    public static void main(String[] args) {
        int n;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n : ");
            n = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print((j+1)+" ");
            }
            System.out.println();
        }
    }
}