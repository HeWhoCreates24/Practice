import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MergeSortedLists {

    public static LinkedList<Integer> mergeHelper(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> temp = new LinkedList<>();

        // Create iterators for both lists
        Iterator<Integer> l1I = l1.iterator();
        Iterator<Integer> l2I = l2.iterator();

        Integer e1 = l1I.hasNext() ? l1I.next() : null;
        Integer e2 = l2I.hasNext() ? l2I.next() : null;

        // Merge both lists
        while (e1 != null && e2 != null) {
            if (e1 <= e2) {
                temp.addLast(e1);
                e1 = l1I.hasNext() ? l1I.next() : null;
            } else {
                temp.addLast(e2);
                e2 = l2I.hasNext() ? l2I.next() : null;
            }
        }

        // Add remaining elements from l1
        while (e1 != null) {
            temp.addLast(e1);
            e1 = l1I.hasNext() ? l1I.next() : null;
        }

        // Add remaining elements from l2
        while (e2 != null) {
            temp.addLast(e2);
            e2 = l2I.hasNext() ? l2I.next() : null;
        }

        return temp;
    }

    public static LinkedList<Integer> mergeSortedLists(ArrayList<LinkedList<Integer>> lists) {
        if (lists.isEmpty()) {
            return new LinkedList<>();
        }

        // Start with the first list
        LinkedList<Integer> mergedList = lists.get(0);

        // Merge all subsequent lists into mergedList
        for (int i = 1; i < lists.size(); i++) {
            mergedList = mergeHelper(mergedList, lists.get(i));
        }

        return mergedList;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // Number of sorted lists
            System.out.println("Enter k:");
            int k = sc.nextInt();

            // Create k linked lists
            ArrayList<LinkedList<Integer>> lists = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                System.out.println("Enter size of list " + (i + 1) + ":");
                int n = sc.nextInt();

                LinkedList<Integer> ll = new LinkedList<>();
                System.out.println("Enter elements for list " + (i + 1) + ":");
                for (int j = 0; j < n; j++) {
                    ll.addLast(sc.nextInt());
                }
                lists.add(ll);
            }

            // Merge all sorted lists
            LinkedList<Integer> sortedList = mergeSortedLists(lists);

            // Print the merged sorted list
            System.out.println("Merged Sorted List:");
            System.out.println(sortedList);
        }
    }
}
