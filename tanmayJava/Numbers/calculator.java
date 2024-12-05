import java.util.Scanner;
public class calculator{
    public static void main(String[] args) {
        float a,b;
        char op;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter a : ");
            a = sc.nextFloat();
            System.out.println("enter b : ");
            b = sc.nextFloat();
            System.out.println("enter operator : ");
            op = sc.next().charAt(0);
        }
        switch(op){
            case '+' -> System.out.println(a+b);
            case '-' -> System.out.println(a-b);
            case '*' -> System.out.println(a*b);
            case '/' -> System.out.println(a/b);
            case '%' -> System.out.println(a%b);
            default -> System.out.println("incorrect operator!!");
            
            
        }
    }
}