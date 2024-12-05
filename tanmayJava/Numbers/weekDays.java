import java.util.Scanner;
public class weekDays{
    public static void main(String[] args) {
        byte day;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter no. of day[1-7] : ");
            day = sc.nextByte();
        }
        switch(day){
            case 1 -> System.out.println("Sunday");
            case 2 -> System.out.println("Monday");
            case 3 -> System.out.println("Tuesday");
            case 4 -> System.out.println("Wednesday");
            case 5 -> System.out.println("Thursday");
            case 6 -> System.out.println("Friday");
            case 7 -> System.out.println("Saturday");
            default -> System.out.println("number is not in range[1-7]");
            
        }
    }
}