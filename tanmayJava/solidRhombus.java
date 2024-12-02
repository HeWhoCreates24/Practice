import java.util.*;
public class solidRhombus{
    //int n
    //take input
    //canvas of 2n x n
    //j>n-i&&j<2n-i
    public static void main(String[] args) {
        int n;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n : ");
            n = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<(2*n);j++){
                if((j>=n-i-1)&&(j<2*n-i-1)){
                    System.out.print(" *");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}