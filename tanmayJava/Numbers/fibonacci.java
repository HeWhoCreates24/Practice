import java.util.*;
public class fibonacci{
    public static void main(String args[]){
        int first = 0;
        int sec = 1;
        int third = 0;
        System.out.print("enter n : ");
        int n;
        try(Scanner sc = new Scanner(System.in)){
            n = sc.nextInt();
        }
        switch (n) {
            case 1 -> System.out.println("0");
            case 2 -> System.out.println("1");
            default -> {
                for(int i=2;i<n;i++){
                    third=first+sec;
                    first=sec;
                    sec=third;
                }   System.out.println(third);
            }
        }
        
    }
}