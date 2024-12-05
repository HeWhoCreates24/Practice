import java.util.*;
public class hollowRectangle{
    public static void main(String[] args) {
        int l,b;

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter length : ");
            l = sc.nextInt();
            System.out.println("enter breadth : ");
            b = sc.nextInt();
        }

        for(int i=0;i<b;i++){
            for(int j=0;j<l;j++){
                if((i==0)||(i==b-1)||(j==0)||(j==l-1)){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}