import java.util.*;
public class countLowercaseVowls{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            // input string
            System.out.println("Enter a string");
            String str = sc.nextLine();
            // count lowercase vowels
            int count = 0;
            for (int i = 0; i < str.length(); i++){
                switch (str.charAt(i)){
                    case 'a' :
                    case 'e' :
                    case 'i' :
                    case 'o' :
                    case 'u' :
                        count++;
                    default :
                }
            }
            // display count
            switch (count) {
                case 0 -> System.out.println("No lowercase vowels found");
                case 1 -> System.out.println("1 lowercase vowel found");
                default -> System.out.println(count + " lowercase vowels found");
            }
        }
    }
}