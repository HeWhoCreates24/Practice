import java.util.*;
public class tableCalculator{
    public static void main(String[] args) {
        int n;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n : ");
            n = sc.nextInt();
        }
        for(int i=1;i<11;i++){
            System.out.println(n+" x "+i+" = "+(n*i));
        }
    }
}