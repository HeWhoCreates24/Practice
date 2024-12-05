import java.util.*;
class factorial{
    public static void main(String args[]) {
        int n;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n : ");
            n = sc.nextInt();
        }
        if(n<0){
            System.out.println("NEGATIVE number!!");
            return;
        }
        int ans=1;
        for(int i=1;i<=n;i++){
            ans*=i;
        }
        System.out.println("factorial of "+n+" is "+ans);
    }
}