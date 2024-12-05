import java.util.Scanner;
public class positiveOrNegative{
    public static void main(String[] args) {
        int n;
        try(Scanner sc = new Scanner(System.in)){
            n = sc.nextInt();
        }
        if(n<0){
            System.out.println("Negative integer!!");
        }
        else{
            System.out.println("Positive integer!!");
        }
    }
}