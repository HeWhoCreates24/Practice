import java.util.*;
public class avgOfThree{
    public static float avgOfThree(int a,int b,int c){
        int sum=a+b+c;
        float avg=sum/3;
        return avg;
    }
    public static void main(String[] args) {
        int a,b,c;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter a : ");
            a = sc.nextInt();
            System.out.println("enter b : ");
            b = sc.nextInt();
            System.out.println("enter c : ");
            c = sc.nextInt();
        }
        float avg = avgOfThree(a, b, c);
        System.out.println("Average of numbers : "+avg);
    }
}
