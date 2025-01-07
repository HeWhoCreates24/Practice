import java.util.*;

public class NextGreaterElement{

    public static void nextGreater(int[] arr, int[] ans){

        Stack <Integer> s = new Stack<>();

        int index = arr.length-1;

        while (index >= 0){
            int curr = arr[index];

            while((!s.isEmpty()) && (curr >= arr[s.peek()])){
                s.pop();
            }

            if (s.isEmpty()){
                ans[index] = -1;
            }
            else{
                ans[index] = arr[s.peek()];
            }

            s.push(index);
            index--;
        }

    }

    public static void main(String[] args) {
        
        int[] arr = {6, 8, 0, 1, 3};
        int[] ans = new int[arr.length];

        nextGreater(arr, ans);

        for (int n : ans){
            System.out.print(n + " ");
        }

    }

}