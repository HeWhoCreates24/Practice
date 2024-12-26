import java.util.*;
public class MonotonousOrNot{
    public static void main(String[] args) {
        // input array

        Scanner sc = new Scanner(System.in);
        ArrayList <Integer> arr = new ArrayList<>();
        System.out.println( "Enter array elements ( end with '.' )" );
        while (sc.hasNextInt()) {
            arr.add(sc.nextInt());
        }
        sc.next();
        // edge case : array size < 2

        if (arr.size() < 2){
            System.out.println("Array does not contain enough elements to determine tone");
            return;
        }
        // set tone = unset

        String tone = "unset";
        // if first element > second, then tone = decreasing

        if (arr.get(0) > arr.get(1)){
            tone = "decreasing";
        }
        // else if first element < second, then tone = increasing

        else if (arr.get(0) < arr.get(1)){
            tone = "increasing";
        }
        // loop on array

        for (int i = 0; i < arr.size()-1; i++){
            // if tone is not unset

            if (!tone.equals("unset")){
                // if tone changes

                if ((tone.equals("decreasing") && arr.get(i) < arr.get(i+1)) || (tone.equals("increasing") && arr.get(i) > arr.get(i+1))){
                    // tone = non-mono

                    tone = "non-mono";
                    break;
                }
            }
        }
        // if tone is not non-mono

        if (!tone.equals("non-mono")){
            // display monotonous and tone

            System.out.println("Array is Monotonously " + (tone.equals("unset") ? "constant" : tone));
        }
        else{
            // display not monotonous

            System.out.println("Array is Non-Monotonous");
        }
    }
}