import java.util.*;
public class TowerOfHanoi{
    public static void move(int n, String src, String help, String dest){
        if (n == 1){
            System.out.println("Move disc from " + src + " to " + dest );
            return;
        }
        move(n - 1, src, dest, help);
        System.out.println("Move disc from " + src + " to " + dest );
        move(n - 1, help, src, dest);
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter n :");
            int n = sc.nextInt();
            move(n, "A", "B", "C");
        }
    }
}