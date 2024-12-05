import java.util.*;
public class zeroOnePattern{
    public static void main(String[] args) {
        int n;

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n : ");
            n = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}