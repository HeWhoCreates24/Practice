import java.util.*;
public class sumOfDigits{
    public static int sumOfDigits(int a){
        int sum=0;
        for(;a!=0;a/=10){
            sum+=(a%10);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter num : ");
        int n = sc.nextInt();
        System.out.println(sumOfDigits(n));
    }
}