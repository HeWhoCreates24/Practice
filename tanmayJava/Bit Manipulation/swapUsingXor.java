import java.util.*;
public class swapUsingXor{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            // input a and b
            System.out.println("Enter a");
            int a = sc.nextInt();
            System.out.println("Enter b");
            int b = sc.nextInt();
            // swap using xor
            System.out.println("Swapping...");
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
            // display a and b
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }
    }
}