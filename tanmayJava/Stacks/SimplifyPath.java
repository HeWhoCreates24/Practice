import java.util.*;

public class SimplifyPath{

    public static String simplifyPath(String path){

        Stack <Character> s = new Stack<>();
        s.push('/');

        for (int i = 1; i < path.length(); i++){

            char curr = path.charAt(i);

            if (curr == '.' && s.peek() == '.'){
                s.pop();
                s.pop();

                if (s.isEmpty()){
                    return "cannot access root parent";
                }

                while (s.peek() != '/'){
                    s.pop();
                }
                s.pop();
            }
            else{
                s.push(curr);
            }
        }

        if (s.isEmpty()){
            return "/";
        }

        if (s.peek() == '/'){
            s.pop();
        }

        StringBuilder sb = new StringBuilder("");

        while (!s.isEmpty()){
            sb.append(s.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String path1 = "/user/dir/";
        String path2 = "/user/dir/..";
        String path3 = "/user/dir/../../../";

        System.out.println(simplifyPath(path1));
        System.out.println(simplifyPath(path2));
        System.out.println(simplifyPath(path3));
    }

}