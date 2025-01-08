import java.util.*;

public class PalindromeLinkedList{

    public static boolean palLinkedList(LinkedList <Integer> ll){

        Stack <Integer> s = new Stack<>();

        Iterator <Integer> i = ll.iterator();

        while (i.hasNext()){
            s.push(i.next());
        }

        i = ll.iterator();

        while (i.hasNext()){
            if (!s.pop().equals(i.next())){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        
        LinkedList <Integer> ll = new LinkedList<>();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);

        System.out.println(palLinkedList(ll));

    }

}