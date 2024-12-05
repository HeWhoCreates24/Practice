import java.util.*;
public class avgOf3Numbers{
    public static void main(String args[]){
        int a,b,c;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a...");
            a = sc.nextInt();
            System.out.println("Enter b...");
            b = sc.nextInt();
            System.out.println("Enter c...");
            c = sc.nextInt();
        }
            int avg = (a+b+c)/3;
            System.out.println("Average of the numbers is "+avg);
        
    }
}
