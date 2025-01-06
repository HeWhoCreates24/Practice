public class DoublyLinkedList{
    public static class DLL{

        public static Node head;
        public static Node tail;
        public static int size = 0;

        private class Node{
            int data;
            Node next;
            Node prev;

            public Node(int data){
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }

        public void addLast(int data){
            Node newNode = new Node(data);

            if(head == null){
                head = newNode;
                tail = newNode;
                newNode.next = null;
                newNode.prev = null;
            }
            else{
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = null;
                tail = newNode;
            }

            size++;
        }

        public void addFirst(int data){
            Node newNode = new Node(data);

            if(head == null){
                head = newNode;
                tail = newNode;
                newNode.next = null;
                newNode.prev = null;
            }
            else{
                head.prev = newNode;
                newNode.next = head;
                newNode.prev = null;
                head = newNode;
            }

            size++;
        }

        public void printDLL(){
            Node temp = head;

            System.out.print("null <=> ");
            while(temp != null){
                System.out.print("[" + temp.data + "] <=> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public void printReverseDLL(){
            Node temp = tail;

            System.out.print("null <=> ");
            while(temp != null){
                System.out.print("[" + temp.data + "] <=> ");
                temp = temp.prev;
            }
            System.out.println("null");
        }

        public void deleteFirst() {
            if (head == null) { // List is empty
                System.out.println("List is empty.");
                return;
            }

            if (head == tail) { // Only one node in the list
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }

        public void deleteLast() {
            if (head == null) { // List is empty
                System.out.println("List is empty.");
                return;
            }

            if (head == tail) { // Only one node in the list
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }

        public boolean contains(int data) {
            Node temp = head;
            while (temp != null) {
                if (temp.data == data) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        public void clear() {
            head = null;
            tail = null;
            size = 0;
        }

        public void deleteByValue(int data) {
            if (head == null) { // List is empty
                System.out.println("List is empty.");
                return;
            }

            Node temp = head;

            while (temp != null) {
                if (temp.data == data) {
                    if (temp == head) {
                        deleteFirst();
                    } else if (temp == tail) {
                        deleteLast();
                    } else {
                        temp.prev.next = temp.next;
                        temp.next.prev = temp.prev;
                        size--;
                    }
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Value " + data + " not found.");
        }
    }
    public static void main(String[] args) {
        DLL dll = new DLL();

        dll.addFirst(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.addFirst(5);
        dll.printDLL();
        System.out.println("Size of DLL: " + dll.size);

        dll.printReverseDLL();

        System.out.println("Contains 20? " + dll.contains(20));
        System.out.println("Contains 40? " + dll.contains(40));

        dll.deleteFirst();
        dll.printDLL();
        System.out.println("Size of DLL: " + dll.size);

        dll.deleteLast();
        dll.printDLL();
        System.out.println("Size of DLL: " + dll.size);

        dll.addLast(40);
        dll.addLast(50);
        dll.printDLL();
        System.out.println("Deleting value 20...");
        dll.deleteByValue(20);
        dll.printDLL();
        System.out.println("Deleting value 5 (not present)...");
        dll.deleteByValue(5);
        dll.printDLL();
        System.out.println("Deleting value 30...");
        dll.deleteByValue(30);
        dll.printDLL();
        System.out.println("Size of DLL: " + dll.size);

        dll.clear();
        dll.printDLL();
        System.out.println("Size of DLL after clear: " + dll.size);

        System.out.println("Deleting from an empty list:");
        dll.deleteFirst();
        dll.deleteLast();
        dll.deleteByValue(10);

        dll.addFirst(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.printDLL();
        System.out.println("Size of DLL: " + dll.size);

        dll.printReverseDLL();
    }

} 