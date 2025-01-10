import java.util.*;

public class StackUsingDeque{

    public static class Stack{

        Deque <Integer> st;
        public int size;

        public Stack(){

            st = new LinkedList<>();
            size = 0;
            
        }

        public boolean isEmpty(){
            return st.isEmpty();
        }

        public void push(int data){

            st.addFirst(data);
            size++;

        }

        public int pop(){

            size--;
            return st.removeFirst();

        }

        public int peek(){
            return st.getFirst();
        }

        public void print(){
            System.out.println(st);
        }

    }

    public static void main(String[] args) {
        
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        s.print();

        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }

}