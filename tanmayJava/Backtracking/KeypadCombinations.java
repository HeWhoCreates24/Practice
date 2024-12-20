import java.util.*;
public class KeypadCombinations{
    public static void keypad(String str, int i, String newStr){
        //base case
        if(i == str.length()){
            System.out.println(newStr);
            return;
        }
        //recursion
        switch (str.charAt(i)) {
            case '2' -> {
                keypad(str, i+1, newStr+'a');
                keypad(str, i+1, newStr+'b');
                keypad(str, i+1, newStr+'c');
            }
            case '3' -> {
                keypad(str, i+1, newStr+'d');
                keypad(str, i+1, newStr+'e');
                keypad(str, i+1, newStr+'f');
            }
            case '4' -> {
                keypad(str, i+1, newStr+'g');
                keypad(str, i+1, newStr+'h');
                keypad(str, i+1, newStr+'i');
            }
            case '5' -> {
                keypad(str, i+1, newStr+'j');
                keypad(str, i+1, newStr+'k');
                keypad(str, i+1, newStr+'l');
            }
            case '6' -> {
                keypad(str, i+1, newStr+'m');
                keypad(str, i+1, newStr+'n');
                keypad(str, i+1, newStr+'o');
            }
            case '7' -> {
                keypad(str, i+1, newStr+'p');
                keypad(str, i+1, newStr+'q');
                keypad(str, i+1, newStr+'r');
                keypad(str, i+1, newStr+'s');
            }
            case '8' -> {
                keypad(str, i+1, newStr+'t');
                keypad(str, i+1, newStr+'u');
                keypad(str, i+1, newStr+'v');
            }
            case '9' -> {
                keypad(str, i+1, newStr+'w');
                keypad(str, i+1, newStr+'x');
                keypad(str, i+1, newStr+'y');
                keypad(str, i+1, newStr+'z');
            }
            default -> {
            }
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter number");
            String str = sc.next();
            keypad(str, 0, "");
        }
    }
}