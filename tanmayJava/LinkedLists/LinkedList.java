import java.util.*;

public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void addAt(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public int removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        int val = head.data;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        int val = tail.data;
        if (size == 1) {
            head = tail = null;
        } else {
            Node prev = head;
            for (int i = 0; i < size - 2; i++) {
                prev = prev.next;
            }
            prev.next = null;
            tail = prev;
        }
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node curr = head;
        int index = 0;
        while (curr != null){
            if (curr.data == key){
                return index;
            }
            else{
                curr = curr.next;
                index++;
            }
        }
        return -1;
    }

    public int recSearch(int key, Node head){
        
        // base case
        if (head == null){
            return -1;
        }

        // if key found at head
        if (head.data == key){
            return 0;
        }
        // else search in rest list
        else{
            int index = recSearch(key, head.next);
            return index == -1 ? -1 : index+1;
        } 
    }

    public void reverse(){

        // if list is empty
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        
        // reverse first 2 nodes manually
        Node curr = head;
        Node next = curr.next;
        curr.next = null;
        Node prev = curr;
        curr = next;

        // loop till end
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // update head and tail
        tail = head;
        head = prev;
    }

    public int removeFromEnd(int n){

        //edge cases
        if (n == size){
            return removeFirst();
        }
        else if (n == 0){
            return removeLast();
        }

        // index from start = size-n+1
        int index = size-n-1;

        // access previous node
        Node prev = head;
        for (int i = 0; i < index-1; i++){
            prev = prev.next;
        }

        // get next node data to return
        int val = prev.next.data;

        // remove the next node
        prev.next = prev.next.next;
        size--;

        return val;
    }

    public Node findMid(){

        // slow-fast approach
        Node fast = head;
        Node slow = head;
        
        // loop untill end
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //slow is at middle node
        return slow;
    }

    public Node reverse(Node head){

        //three nodes
        Node prev = null;
        Node curr = head;
        Node next;

        //four steps
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //return head
        return prev;
    }

    public boolean isPallindrome(){

        //edge cases
        if (size < 2){
            return true;
        }

        // access mid
        Node mid = findMid();

        // reverse from mid to end
        mid = reverse(mid);

        // two pointer approach
        Node left = head;
        Node right = mid;

        while (left != null && right != null){
            if (left.data != right.data){

                // is not pallindrome
                return false;
            }
            left = left.next;
            right = right.next;
        }

        // is palindrome
        return true;
    }

    public boolean isCyclic(){

        // slow-fast approach
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // if slow and fast meet, cycle exists
            if (slow == fast){
                return true;
            }
        }

        // else list is non cyclic
        return false;
    }

    public Node findIntersect(LinkedList l2){

        Node h1 = this.head;
        Node h2 = l2.head;

        while(h1 != null){
            while(h2 != null){
                if(h1 == h2){
                    return h2;
                }
                h2 = h2.next;
            }
            h1 = h1.next;
            h2 = l2.head;
        }

        return null;
    }

    public void removeNAfterM(int n, int m){
        Node start = head, end = start;
        boolean done = false;

        while(true){

            for(int i = 0; i < m-1; i++){
                if(start == null || start.next == null){
                    done = true;
                    break;
                }
                start = start.next;
            }

            end = start;

            for(int i = 0; i < n; i++){
                if(end == null || end.next == null){
                    done = true;
                    break;
                }
                end = end.next;
            }

            if(done){
                break;
            }


            start.next = end.next;
            start = start.next;
        }
    }

    public void swapNodes(int n1, int n2) {

        if (head == null) {
            System.err.println("list is empty");
            return;
        }

        // If n1 and n2 are the same, no swap is needed
        if (n1 == n2) {
            return;
        }

        Node node1prev = null, node2prev = null;
        Node node1 = head, node2 = head;

        // Find previous node of n1 and n2
        for (int i = 1; i < n1; i++) {
            node1prev = node1;
            node1 = node1.next;
        }

        for (int i = 1; i < n2; i++) {
            node2prev = node2;
            node2 = node2.next;
        }

        // If either node1 or node2 is null, return as the nodes do not exist
        if (node1 == null || node2 == null) {
            System.err.println("One or both nodes not found.");
            return;
        }

        // Swap the nodes if they are not adjacent
        if (node1 != node2) {
            // Update previous nodes' next pointers
            if (node1prev != null) {
                node1prev.next = node2;
            } else { // If node1 is the head
                head = node2;
            }

            if (node2prev != null) {
                node2prev.next = node1;
            } else { // If node2 is the head
                head = node1;
            }

            // Swap the next pointers of the nodes
            Node temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;
        }
    }

    public void oddEven() {
        if (head == null || head.next == null) {
            return; // No need to rearrange if the list is empty or has only one node
        }

        Node oddHead = null, evenHead = null, oddTail = null, evenTail = null;
        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) { // Even node
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = evenHead;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            } else { // Odd node
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = oddHead;
                } else {
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            }
            current = current.next;
        }

        // End the odd list
        if (oddTail != null) {
            oddTail.next = null;
            tail = oddTail;
        }

        // If there are even nodes, link the even list to the odd list
        if (evenHead != null) {
            head = evenHead;
            if (oddHead != null) {
                evenTail.next = oddHead;
            }
        } else {
            head = oddHead; // If there are no even nodes, the head will be the oddHead
        }
    }


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(8);
        ll.addLast(12);
        ll.addLast(10);
        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(1);
        ll.addLast(6);

        ll.print();
        ll.oddEven();
        ll.print();
    }
}
