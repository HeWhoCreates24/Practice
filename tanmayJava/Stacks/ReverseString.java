import java.util.*;

public class ReverseString{

    public static String reverseStr(String str){

        Stack <Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++){
            s.push(str.charAt(i));
        }

        StringBuilder rev = new StringBuilder("");

        while (!s.isEmpty()){
            rev.append(s.pop());
        }

        return rev.toString();

    }

    public static void main(String[] args) {
        String str = "abc";
        String rev = reverseStr(str);
        System.out.println(rev);
    }
}