
public class CircularQueueUsingArray{

    public static class CircularQueue{

        int[] queue;
        private int size;
        private int front;
        private int rear;

        public CircularQueue(int n){

            queue = new int[n];
            front = -1;
            rear = -1;
            size = n;

        }

        public boolean isEmpty(){
            return rear == -1;
        }

        public boolean isFull(){
            return (rear + 1) % size == front;
        }

        public void add(int data){

            if (this.isEmpty()){

                rear++;
                front++;

                queue[rear] = data;

            }
            else if (this.isFull()){

                System.err.println("Queue is Full, Cannot add " + data);

            }
            else{

                rear = (rear + 1) % size;

                queue[rear] = data;
            }

        }

        public int remove(){

            if (this.isEmpty()){

                System.err.println("Queue is Empty");
                return -1;

            }
            else if (front == rear){

                int data = queue[front];

                front = rear = -1;

                return data;

            }
            else{

                int data = queue[front];

                front = (front + 1) % size;

                return data;

            }

        }

        public int peek(){

            if (this.isEmpty()){
                return -1;
            }

            return queue[front];

        }

        public void print(){

            if (this.isEmpty()){
                System.err.println("Queue is Empty");
                return;
            }

            for (int i = this.front; i != this.rear; i = (i + 1) % size){
                System.out.print(queue[i] + " ");
            }

            System.out.print(queue[rear]);
            System.out.println();
            
        }

    }

    public static void main(String[] args) {
        
        CircularQueue q = new CircularQueue(2);

        q.add(1);
        q.print();
        q.add(2);
        q.print();
        q.add(3);
        q.print();

        q.remove();
        q.print();
        q.add(4);
        q.print();
        q.remove();
        q.print();
        q.add(5);
        q.print();

        q.remove();
        q.print();
        q.remove();
        q.print();

    }

}