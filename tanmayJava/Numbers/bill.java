import java.util.*;
public class bill{
    public static void main(String[] args) {
        float pencil,pen,eraser;
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter price of pencil : ");
            pencil = sc.nextFloat();
            System.out.print("Enter quantity : ");
            pencil *= sc.nextInt();
            System.out.print("Enter price of pen : ");
            pen = sc.nextFloat();
            System.out.print("Enter quantity : ");
            pen *= sc.nextInt();
            System.out.print("Enter price of eraser : ");
            eraser = sc.nextFloat();
            System.out.print("Enter quantity : ");
            eraser *= sc.nextInt();   

        }
        float gst = 0.18f;
        float total = (pencil+pen+eraser)+((pencil+pen+eraser)*gst);
        System.out.println("Your total billing amount including 18% gst : "+total);

    }
}
