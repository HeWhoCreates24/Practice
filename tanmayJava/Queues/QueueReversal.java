import java.util.*;

public class QueueReversal{

    public static void reverse(Queue <Integer> q){

        Stack <Integer> temp = new Stack<>();

        while (!q.isEmpty()){
            temp.push(q.remove());
        }

        while (!temp.isEmpty()){
            q.add(temp.pop());
        }

    }

    public static void main(String[] args) {
        
        Queue <Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(q);

        reverse(q);

        System.out.println(q);

    }

}