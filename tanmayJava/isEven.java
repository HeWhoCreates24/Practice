import java.util.*;
public class isEven{
    public static boolean isEven(int a){
        return a%2==0;
    }
    public static void main(String[] args) {
        int a;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter a : ");
            a = sc.nextInt();
        }
        if(isEven(a)){
            System.out.println("Is Even");
        }
        else{
            System.out.println("Is Odd");
        }
    }
}
