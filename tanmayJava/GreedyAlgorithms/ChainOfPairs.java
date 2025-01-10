
import java.util.Arrays;
import java.util.Comparator;

public class ChainOfPairs{

    public static void main(String[] args) {
        
        // given pairs
        int[][] pairs = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        Comparator <int[]> c = Comparator.comparingInt(o -> o[1]);
        Arrays.sort(pairs, c);

        int chain = 0;
        int end = Integer.MIN_VALUE;

        for (int[] pair : pairs) {

            if (pair[0] > end) {

                chain++;
                end = pair[1];

            }

        }

        System.out.println("Maximum chain length : " + chain);

    }

}