import java.util.*;

public class FirstNonRepeatingLetter{

    static int[] chars = new int[26];
    static Queue <Integer> q = new LinkedList<>();

    public static void clear(){
        Arrays.fill(chars, 0);
        q.clear();
    }

    public static void stream(String str){

        for (int i = 0; i < str.length(); i++){
            System.out.println(firstNRL(str.charAt(i)));
        }

    }

    public static char firstNRL(char ch){

        int curr = ch - 'a';

        if (chars[curr] == 0){
            q.add(curr);
        }

        chars[curr]++;

        while (!q.isEmpty()){
            if (chars[q.peek()] == 1){
                return (char)('a' + q.peek());
            }
            q.remove();
        }

        return '~';

    }

    public static void main(String[] args) {
        
        stream("aabccxb");
        clear();
        stream("aabccxb");

    }

}