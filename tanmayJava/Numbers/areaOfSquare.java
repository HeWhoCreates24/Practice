import java.util.*;
public class areaOfSquare{
    public static void main(String args[]){
        int s;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a side of the SQUARE : ");
            s = sc.nextInt();
        }
        System.out.println("Area of the given SQUARE is "+s*s);
    }
}