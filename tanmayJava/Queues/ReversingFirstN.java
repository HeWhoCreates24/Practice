import java.util.*;

public class ReversingFirstN{

    public static void reverseN(Queue <Integer> q, int n){

        if (q.size() < n){

            System.err.println("Queue is too short");
            return;

        }

        Stack <Integer> s = new Stack<>();

        for (int i = 0; i < n; i++){

            s.push(q.remove());

        }

        while (!s.isEmpty()){

            q.add(s.pop());

        }

        for (int i = 0; i < (q.size()-n); i++){

            q.add(q.remove());

        }

    }

    public static void main(String[] args) {
        
        Queue <Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        System.out.println(q);

        reverseN(q, 5);

        System.out.println(q);

    }

}