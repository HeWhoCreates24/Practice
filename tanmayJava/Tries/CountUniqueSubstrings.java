import java.util.*;

public class CountUniqueSubstrings{
    public static int uniqueSubs(String str){
        HashSet<String> set = new HashSet<>();

        for (int i = 1; i <= str.length(); i++){
            for (int j = 0; j <= str.length() - i; j++){
                set.add(str.substring(j, j+i));
            }
        }

        return set.size() + 1;
    }
    public static void main(String[] args) {
        String str = "ababa";
        System.out.println(uniqueSubs(str));
    }
}