import java.util.*;
public class floydsTriangle{
    public static void main(String[] args) {
        int n;

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n : ");
            n = sc.nextInt();
        }

        int num = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<=(i)){
                    System.out.print((num++)+" ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}