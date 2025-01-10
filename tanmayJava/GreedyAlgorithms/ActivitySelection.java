
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection{

    public static void main(String[] args) {
        
        int[] st = {1, 3, 0, 5, 8, 5};
        int[] en = {2, 4, 6, 7, 9, 9};

        int[][] arr = new int[st.length][3];

        for (int i = 0; i < st.length; i++){

            arr[i][0] = i;
            arr[i][1] = st[i];
            arr[i][2] = en[i];

        }

        Arrays.sort(arr, Comparator.comparingDouble(o -> o[2]));

        int acts = 0;
        ArrayList <Integer> ans = new ArrayList<>();
        int enTime = 0;

        for (int i = 0; i < st.length; i++){

            if (arr[i][1] >= enTime){
                acts++;
                ans.add(arr[i][0]);
                enTime = arr[i][2];
            }

        }

        for (int i : ans){
            System.out.print("A" + i + " ");
        }
        System.out.println();
        System.out.println("Activities done : " + acts + " out of " + st.length);

    }

}