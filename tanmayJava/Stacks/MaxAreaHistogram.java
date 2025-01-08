import java.util.*;

public class MaxAreaHistogram{

    public static int[] nextSmaller(int[] heights, boolean  right){

        int[] nextSmallers = new int[heights.length];

        Stack <Integer> s = new Stack<>();

        if (right){

            for (int i = heights.length - 1; i >= 0; i--){

                if (s.isEmpty()){
                    s.push(i);
                }
                else{
                    while (!s.isEmpty() && heights[s.peek()] >= heights[i]){
                        s.pop();
                    }
                    if (s.isEmpty()){
                        nextSmallers[i] = -1;
                    }
                    else{
                        nextSmallers[i] = s.peek();
                    }
                    s.push(i);
                }
            }
        }
        else{

            for (int i = 0; i < heights.length; i++){
                
                if (s.isEmpty()){
                    s.push(i);
                }
                else{
                    while (!s.isEmpty() && heights[s.peek()] >= heights[i]){
                        s.pop();
                    }
                    if (s.isEmpty()){
                        nextSmallers[i] = heights.length;
                    }
                    else{
                        nextSmallers[i] = s.peek();
                    }
                    s.push(i);
                }
            }
        }

        return nextSmallers;

    }

    public static int maxArea(int[] heights){

        int maxArea = Integer.MIN_VALUE;
        int[] rightSmaller = nextSmaller(heights, true);
        int[] leftSmaller = nextSmaller(heights, false);

        for (int i = 0; i < heights.length; i++){
            int currHeight = heights[i];
            int currWidth = rightSmaller[i] - leftSmaller[i] - 1;

            int currArea = currHeight * currWidth;

            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;

    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println(maxArea(heights));
    }
}