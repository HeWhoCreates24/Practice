import java.util.ArrayList;

public class StackUsingArrayList{

    public static class Stack{

        public static ArrayList <Integer> stack = new ArrayList<>();
        public static int topIndex = -1;

        public boolean isEmpty(){
            return (topIndex == -1);
        }

        public void push(int data){
            stack.add( topIndex + 1, data);
            topIndex++;
        }

        public int pop(){

            if (this.isEmpty()){
                return -1;
            }

            int top = stack.get(topIndex);
            stack.remove(topIndex);
            topIndex--;
            return top;
        }

        public int peek(){

            if (this.isEmpty()){
                return -1;
            }

            return stack.get(topIndex);
        }

    }

    public static void main(String[] args) {

        Stack s1 = new Stack();

        s1.push(1);
        s1.push(2);
        s1.push(3);

        while (!s1.isEmpty()){
            System.out.println(s1.peek());
            s1.pop();
        }
        
    }
}