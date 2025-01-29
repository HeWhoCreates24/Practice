import java.util.*;

public class ValidAnagram{
    public static boolean anagramOrNot(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 'a'; i <= 'z'; i++){
            mp.put((char)i, 0);
        }

        for (int i = 0; i < str1.length(); i++){
            mp.put(str1.charAt(i), mp.get(str1.charAt(i))+1);
        }

        for (int i = 0; i < str2.length(); i++){
            if (mp.get(str2.charAt(i)) == 0){
                return false;
            }
            else{
                mp.put(str2.charAt(i), mp.get(str2.charAt(i))-1);
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String str1 = "tulip";
        String str2 = "lipid";

        System.out.println(anagramOrNot(str1, str2));
    }
}