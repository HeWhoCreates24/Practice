import java.util.*;

public class QueueUsingTwoStacks{

    public static class Queue{

        Stack <Integer> s1;
        Stack <Integer> s2;

        int size;

        public Queue(){

            s1 = new Stack<>();
            s2 = new Stack<>();
            size = 0;

        }

        public boolean isEmpty(){

            return s1.isEmpty() && s2.empty();

        }

        public void add(int data){

            s1.add(data);
            size++;

        }

        public int remove(){

            if (s1.isEmpty()){
                System.err.println("Queue is Empty");
                return Integer.MIN_VALUE;
            }

            while (!s1.isEmpty()){
                s2.add(s1.pop());
            }

            int data = s2.pop();

            while (!s2.isEmpty()){
                s1.add(s2.pop());
            }

            return data;

        }

        public int peek(){

            if (s1.isEmpty()){
                System.err.println("Queue is Empty");
                return Integer.MIN_VALUE;
            }

            while (!s1.isEmpty()){
                s2.add(s1.pop());
            }

            int data = s2.peek();

            while (!s2.isEmpty()){
                s1.add(s2.pop());
            }

            return data;

        }

        public void print(){

            if (s1.isEmpty()){
                System.err.println("Queue is Empty");
                return;
            }

            while (!s1.isEmpty()){
                s2.add(s1.pop());
            }

            while (!s2.isEmpty()){

                System.out.println(s2.peek() + " ");
                s1.add(s2.pop());
            }

        }

    }

    public static void main(String[] args) {
        
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        q.print();
        
    }

}