import java.util.*;
public class FindPermutations{
    public static void findPerm(String str, String perm){
        if (str.length() == 0){
            System.out.println(perm);
            return;
        }
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String nstr = str.substring(0, i) + str.substring(i+1);
            findPerm(nstr, perm+ch);
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String str = sc.nextLine();
            findPerm(str, "");
        }
    }
}