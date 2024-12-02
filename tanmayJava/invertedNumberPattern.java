import java.util.*;
public class invertedNumberPattern{
    public static void main(String[] args) {
        int n;

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n : ");
            n = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<=(n-i-1)){
                    System.out.print((j+1)+" ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}