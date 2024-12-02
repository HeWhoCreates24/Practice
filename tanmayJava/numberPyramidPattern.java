import java.util.*;
public class numberPyramidPattern{
    public static void main(String args[]){
        int n;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n : ");
            n = sc.nextInt();
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<(2*n)+1;j++){
        //         if((j>=(n-i))&&(j<=(n+i))){
        //             System.out.print((i+1)+" ");
        //         }
        //         else{
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((n-j)<=(i+1)){
                    System.out.print((i+1)+"   ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}