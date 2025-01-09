public class QueueUsingLinkedList{

    public static class Node{

        int data;
        Node next;

        public Node(int data){

            this.data = data;
            next = null;

        }

    }

    public static class Queue{

        private Node head;
        private Node tail;
        public int size;

        public Queue(){

            size = 0;
            head = null;
            tail = null;

        }

        public boolean isEmpty(){
            return head == null;
        }

        public void add(int data){

            Node newNode = new Node(data);
            size++;

            if (isEmpty()){
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;

        }

        public int peek(){
            
            if (isEmpty()){
                System.err.println("Queue is Empty");
                return Integer.MIN_VALUE;
            }

            return head.data;

        }

        public int remove(){

            if (isEmpty()){
                System.err.println("Queue is Empty");
                return Integer.MIN_VALUE;
            }

            int data = head.data;
            head = head.next;
            size--;

            if (head == null) tail = null;

            return data;

        }

        public void print(){

            if (isEmpty()){
                System.err.println("Queue is Empty");
                return;
            }

            Node temp = head;

            while (temp != null){

                System.out.print(temp.data + " ");
                temp = temp.next;

            }

            System.out.println();

        }

        public int size(){
            return size;
        }

        public void clear(){

            head = null;
            tail = null;
            size = 0;

        }

    }

    public static void main(String[] args) {
        
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println("Queue contents:");
        q.print(); // Output: 1 2 3 4 5

        System.out.println("Front element (peek): " + q.peek()); // Output: 1
        System.out.println("Removed element: " + q.remove());   // Output: 1

        System.out.println("Queue contents after removal:");
        q.print(); // Output: 2 3 4 5

        System.out.println("Queue size: " + q.size()); // Output: 4

        q.clear();
        System.out.println("Queue cleared.");
        System.out.println("Queue size: " + q.size()); // Output: 0
        q.print(); // Output: Queue is Empty

    }

}