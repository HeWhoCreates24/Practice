
import java.util.ArrayList;

public class ActivitySelection{

    public static void main(String[] args) {
        
        int[] st = {1, 3, 0, 5, 8, 5};
        int[] en = {2, 4, 6, 7, 9, 9};

        int acts = 0;
        ArrayList <Integer> ans = new ArrayList<>();
        int enTime = 0;

        for (int i = 0; i < st.length; i++){

            if (st[i] >= enTime){
                acts++;
                ans.add(i);
                enTime = en[i];
            }

        }

        for (int i : ans){
            System.out.println("A" + i + " ");
        }
        System.out.println("Activities done : " + acts + " out of " + st.length);

    }

}