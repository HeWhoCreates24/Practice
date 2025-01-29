import java.util.*;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> unionSet = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();
        HashSet<Integer> tempSet = new HashSet<>();

        // Compute Union
        for (int ele : arr1) {
            unionSet.add(ele);
            tempSet.add(ele);  // Store elements of arr1 in tempSet
        }
        for (int ele : arr2) {
            unionSet.add(ele);
            if (tempSet.contains(ele)) {  // If the element is in arr1, it's an intersection
                intersectionSet.add(ele);
            }
        }

        System.out.println("Union : " + unionSet);
        System.out.println("Intersection : " + intersectionSet);
    }
}
