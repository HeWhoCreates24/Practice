import java.util.Scanner;
public class leapYearOrNot{
    public static void main(String[] args) {
        int yr;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter year : ");
            yr = sc.nextInt();
        }
        if(yr%4!=0){
            System.out.println("Not a leap year");
        }
        else if(yr%100!=0){
            System.out.println("Is a leap year");
        }
        else if(yr%400!=0){
            System.out.println("Not a leap year");
        }
        else{
            System.out.println("Is a leap year");
        }
    }
}