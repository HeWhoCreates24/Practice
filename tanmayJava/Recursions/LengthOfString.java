import java.util.*;
public class LengthOfString{
    public static int strLen (String str){
        if (str.length() == 0){
            return 0;
        }
        return strLen(str.substring(1)) + 1;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            // input str
            System.out.println("enter string :");
            String str = sc.nextLine();
            System.out.println(strLen(str));
        }
    }
}