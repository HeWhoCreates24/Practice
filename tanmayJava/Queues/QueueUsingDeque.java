import java.util.*;

public class QueueUsingDeque{

    public static class Queue{

        Deque <Integer> q;
        public int size;

        public Queue(){

            q = new LinkedList<>();
            size = 0;
            
        }

        public boolean isEmpty(){
            return q.isEmpty();
        }

        public void add(int data){

            q.addLast(data);
            size++;

        }

        public int remove(){

            size--;
            return q.removeFirst();

        }

        public int peek(){
            return q.getFirst();
        }

        public void print(){
            System.out.println(q);
        }

    }

    public static void main(String[] args) {
        
        Queue s = new Queue();

        s.add(1);
        s.add(2);
        s.add(3);

        s.print();

        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.remove();
        }

    }

}