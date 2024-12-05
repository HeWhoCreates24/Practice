import java.util.*;
public class palNumsPat{
    public static void main(String args[]){
        int n;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n : ");
            n = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int num=i+1;
            for(int j=0;j<(2*n)+1;j++){
                if((j>=(n-i))&&(j<=(n+i))){
                    System.out.print(num+" ");
                    if(j<n){
                        num--;
                    }
                    else{
                        num++;
                    }
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}