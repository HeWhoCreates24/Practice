import java.util.*;
public class butterflyPattern{
    public static void main(String[] args) {
        int n;

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n : ");
            n = sc.nextInt();
        }
        for(int i=0;i<(2*n);i++){
            for(int j=0;j<(2*n);j++){
                if(((i<=n)&&(j<=i))||((i<=n)&&(j-n>=n-i-1)||((i>n)&&(j<(n-(i-n))))||((i>=n)&&(j-n>=i-n)))){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}