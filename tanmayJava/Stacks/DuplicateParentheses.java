import java.util.*;

public class DuplicateParentheses{

    public static boolean duplicateParentheses(String str){

        Stack <Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++){

            char curr = str.charAt(i);

            if (s.isEmpty()){
                s.push(curr);
            }
            else{
                switch (curr) {
                    case ')' ->                         {
                            int count = 0;
                            while (s.peek() != '('){
                                s.pop();
                                count++;
                            }       if (count == 0){
                                return true;
                            }       s.pop();
                        }
                    case ']' ->                         {
                            int count = 0;
                            while (s.peek() != '['){
                                s.pop();
                                count++;
                            }       if (count == 0){
                                return true;
                            }       s.pop();
                        }
                    case '}' ->                         {
                            int count = 0;
                            while (s.peek() != '{'){
                                s.pop();
                                count++;
                            }       if (count == 0){
                                return true;
                            }       s.pop();
                        }
                    default -> s.push(curr);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b)-(a-b))";

        System.out.println(duplicateParentheses(str));
    }

}