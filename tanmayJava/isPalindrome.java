import java.util.*;
public class isPalindrome{
    public static boolean isPal(int a){
        int num = a;
        int rev = 0;
        int digs = 0;
        for(;num>0;num/=10){
            digs++;
        }
        num=a;
        for(;a!=0;a/=10){
            int ld = (a%10);
            rev += (int)(Math.pow(10,--digs))*ld;
        }
        return rev==num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter num : ");
        int n = sc.nextInt();
        if(isPal(n)){
            System.out.println("Is Palindrome");
        }
        else{
            System.out.println("Is NOT Palindrome");
        }

    }
}