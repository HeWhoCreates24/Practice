import java.util.Scanner;
public class fever{
    public static void main(String[] args) {
        float temp;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter tempreture : ");
            temp = sc.nextFloat();
        }
        if(temp>=100){
            System.out.println("You have Fever");
        }
        else{
            System.out.println("You don't have Fever");
        }
    }
}