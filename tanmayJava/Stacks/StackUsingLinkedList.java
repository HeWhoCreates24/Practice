public class StackUsingLinkedList{

    public static class Stack{

        public class Node{
            Integer data;
            Node next;

            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        public Node head = null;

        public boolean isEmpty(){
            return head == null;
        }

        public void push(int data){

            Node newNode = new Node(data);

            newNode.next = head;
            head = newNode;

        }

        public Integer pop(){

            if (head == null){
                return null;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public Integer peek(){

            if (head == null){
                return null;
            }

            int top = head.data;
            return top;
        }

    }

    public static void main(String[] args) {
        
        Stack s1 = new Stack();

        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);

        while (!s1.isEmpty()){
            System.out.println(s1.peek());
            s1.pop();
        }

    }
}