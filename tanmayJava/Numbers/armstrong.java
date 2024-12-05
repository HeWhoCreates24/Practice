import java.util.*;
public class armstrong{
    public static void main(String[] args) {
        int n;
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("enter n : ");
            n = sc.nextInt();
        }
        int num = n;
        int ans = 0;
        int digsCount = 0;
        while(n>0){
            digsCount++;
            n /= 10;
        }
        n = num;
        while(n>0){
            int dig = n%10;
            int pow = digsCount;
            int term = 1;
            while(pow>0){
                term *= dig;
                pow--;
            }
            ans += term;
            n /= 10;
        }
        if(ans == num){
            System.out.println("Is Armstrong number");
        }else{
            System.out.println("Is Not Armstrong number");
        }
    }
}