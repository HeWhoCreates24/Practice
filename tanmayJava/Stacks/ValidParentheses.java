import java.util.*;

public class ValidParentheses{

    public static boolean validParentheses(String str){

        // new charecter stack
        Stack <Character> s = new Stack<>();

        // push all parentheses
        for(int i = 0; i < str.length(); i++){

            // get current char
            char curr = str.charAt(i);

            // if close is being pushed and open is peek, pop both
            if (
                !s.isEmpty() &&
                ((curr == ')' && s.peek() == '(') ||
                (curr == '}' && s.peek() == '{') ||
                (curr == ']' && s.peek() == '['))
            ){
                s.pop();
            }
            else{
                s.push(curr);
            }
        }

        // if stack is empty after execution, str is valid, return true
        return s.isEmpty();
    }

    public static void main(String[] args) {
        String str = "({[]})";

        System.out.println(validParentheses(str));
    }
}