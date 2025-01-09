import java.util.*;

public class StackUsingTwoQueues{

    static class Stack{

        Queue <Integer> q1;
        Queue <Integer> q2;
        int size;

        public Stack(){
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
            size = 0;
        }

        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public void add(int data){

            while (!q1.isEmpty()){
                q2.add(q1.remove());
            }

            q1.add(data);
            size++;

            while (!q2.isEmpty()){
                q1.add(q2.remove());
            }

        }

        public int pop(){

            if (isEmpty()){
                System.err.println("Stack is Empty");
                return Integer.MIN_VALUE;
            }

            size--;
            return q1.remove();

        }

        public int peek(){

            if (isEmpty()){
                System.err.println("Stack is Empty");
                return Integer.MIN_VALUE;
            }

            return q1.peek();

        }

        public void print(){

            if (isEmpty()){
                System.err.println("Stack is Empty");
                return;
            }

            Iterator <Integer> i = q1.iterator();

            while (i.hasNext()){
                System.out.print(i.next() + " ");
            }

            System.out.println();
        }

    }

    public static void main(String[] args) {
        
        Stack s = new Stack();

        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);

        s.print();

    }

}