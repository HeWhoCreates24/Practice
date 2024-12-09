import java.util.*;
public class NumberToString{
    public static String numToStr(StringBuilder num, StringBuilder sb){
        if (num.isEmpty()){
            return sb.toString().trim();
        }
        switch (num.charAt(0)){
            case '1' -> sb.append("one ");
            case '2' -> sb.append("two ");
            case '3' -> sb.append("three ");
            case '4' -> sb.append("four ");
            case '5' -> sb.append("five ");
            case '6' -> sb.append("six ");
            case '7' -> sb.append("seven ");
            case '8' -> sb.append("eight ");
            case '9' -> sb.append("nine ");
            case '0' -> sb.append("zero ");
        }
        num.deleteCharAt(0);
        return numToStr(num, sb);
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            // input num
            System.out.println("Enter number to convert :");
            String num = sc.next();
            StringBuilder number = new StringBuilder(""+num);
            StringBuilder sb = new StringBuilder("");
            String str = numToStr(number, sb);
            System.out.println(str);
        }
    }
}