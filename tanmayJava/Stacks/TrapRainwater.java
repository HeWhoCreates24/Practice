import java.util.*;


public class TrapRainwater{

    static int trapRainwater1(int[] arr){

    // First approach

        // initialize trapped water to 0
        int trappedWater = 0;

        // find max for both right and left
        int[] lMax = new int[arr.length];
        int[] rMax = new int[arr.length];

        int max = arr[0];

        for (int i = 0; i < arr.length; i++){
            lMax[i] = max;
            max = Math.max(max, arr[i]);
        }

        max = arr[arr.length-1];

        for (int i = arr.length-1; i >= 0; i--){
            rMax[i] = max;
            max = Math.max(max, arr[i]);
        }

        for (int i = 1; i < arr.length-1; i++){

            int curr = arr[i];
            int lm = lMax[i];
            int rm = rMax[i];

            // if both max are higher than bar
            if (lm > curr && rm > curr){

                // calculate water trapped on each bar = min(rMax, lMax) - barHeight
                int water = Math.min(lm, rm) - curr;

                // add trapped water into total trapped water
                trappedWater += water;
            }

        }

        // return trapped water
        return trappedWater;

    }

    static int trapRainwater2(int[] arr) {
        int trappedWater = 0;

        int left = 0, right = arr.length - 1;
        int lMax = 0, rMax = 0;

        while (left < right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= lMax) {
                    lMax = arr[left]; // Update lMax
                } else {
                    trappedWater += lMax - arr[left]; // Calculate trapped water
                }
                left++;
            } else {
                if (arr[right] >= rMax) {
                    rMax = arr[right]; // Update rMax
                } else {
                    trappedWater += rMax - arr[right]; // Calculate trapped water
                }
                right--;
            }
        }
        return trappedWater;
    }


    static int trapRainwater3(int[] arr){

        // Stack approach

        // initialize trapped water to 0
        int trappedWater = 0;

        // new empty bar stack
        Stack <Integer> s = new Stack<>();

        // traverse through array adding water
        for (int i = 0; i < arr.length; i++){
            if (s.isEmpty()){
                s.push(i);
            }
            else{
                if(arr[i] <= arr[s.peek()]){
                    s.push(i);
                }
                else{

                    while (arr[i] > arr[s.peek()]){

                        int poppedIndex = s.pop();

                        if (s.isEmpty()){
                            break;
                        }
                        else{
                            int width = i - s.peek() - 1;
                            int height = Math.min(arr[i], arr[s.peek()]) - arr[poppedIndex];

                            trappedWater += width * height;
                        }
                    }
                    s.push(i);
                }
            }
        }
        return trappedWater;
    }


    public static void main(String[] args) {
        
        int[] arr = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5};

        System.out.println(trapRainwater1(arr));
        System.out.println(trapRainwater2(arr));
        System.out.println(trapRainwater3(arr));

    }

}