import java.util.*;
public class anagramsOrNot{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            // input strings
            String str1, str2;
            System.out.println("Enter string 1");
            str1 = sc.nextLine();
            System.out.println("Enter string 2");
            str2 = sc.nextLine();
            // check lengths
            if (str1.length() !=  str2.length()){
                System.out.println("Not anagrams");
            }
            else {
                // convert strings to lowercase and arrays
                char ch1 [] = (str1.toLowerCase()).toCharArray();
                char ch2 [] = (str2.toLowerCase()).toCharArray();
                // sort arrays
                Arrays.sort(ch1);
                Arrays.sort(ch2);
                // compare arrays
                if (Arrays.equals(ch1, ch2)){
                    System.out.println("Are anagrams");
                }
                else {
                    System.out.println("Not anagrams");
                }
            }
        }
    }
}