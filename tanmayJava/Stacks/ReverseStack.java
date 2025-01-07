import java.util.*;

public class ReverseStack{

    public static void reverseStack(Stack <Integer> s){
        if (s.isEmpty()){
            return;
        }

        int top = s.pop();
        reverseStack(s);
        PushAtBottom.pushAtBottom(s, top);
    }

    public static void main(String[] args) {
        Stack <Integer> s = new Stack<>();
        
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s);
        reverseStack(s);
        System.out.println(s);
    }

}