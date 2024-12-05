import java.util.*;
public class diamond{
    //take input n
    //canvas (2n+1)^2
    //stars at ((i<=n)&&(j>n-1-i)&&(j<n+1+i))||((i>n)&&(j>i-n)&&(j<(2*n+1)-(i-n)))
    public static void main(String[] args) {
        int n;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n : ");
            n = sc.nextInt();
        }
        int mid=n;
        int last=(2*n)+1;
        for(int i = 0;i<last;i++){
            for(int j = 0;j<last;j++){
                if(((i<=mid)&&(j>(mid-i))&&(j<(mid+i)))||((i>mid)&&(j>(i-mid))&&(j<(last-(i-mid+1))))){
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