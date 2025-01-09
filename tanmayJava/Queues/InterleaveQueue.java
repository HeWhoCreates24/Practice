import java.util.*;

public class InterleaveQueue{

    public static void interleave(Queue <Integer> q){

        if (q.isEmpty()){
            System.err.println("Queue is Empty");
            return;
        }

        int size = q.size();

        Queue <Integer> temp = new LinkedList<>();

        for (int i = 0; i < size/2; i++){

            temp.add(q.remove());

        }

        while (!temp.isEmpty()){
            q.add(temp.remove());
            q.add(q.remove());
        }

        if (size % 2 == 1){
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

        System.out.println(q);

        interleave(q);

        System.out.println(q);

    }

}