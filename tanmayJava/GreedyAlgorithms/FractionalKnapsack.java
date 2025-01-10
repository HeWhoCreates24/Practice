import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack{

    public static void main(String[] args) {
        
        // given data
        int[] value = {120, 60, 100};
        int[] weight = {30, 10, 20};

        int size = value.length;
        int bag = 50;

        // sort data greedily
        double[][] items = new double[size][4];

        for (int i = 0; i < size; i++){

            items[i][0] = value[i];
            items[i][1] = weight[i];
            items[i][2] = value[i] / (double) weight[i];

        }

        Comparator <double[]> c = Comparator.comparingDouble(o -> o[2]);

        Arrays.sort(items, c.reversed());

        // make greedy decesions looping over the array
        int profit = 0;

        for (int i = 0; i < size; i++){

            if ((int) items[i][1] <= bag){

                // take all of if
                bag -= (int) items[i][1];
                profit += (int) items[i][0];

            }
            else{

                // fill the bag
                profit += bag * (int) items[i][2];
                bag = 0;

            }
            if (bag == 0) break;

        }

        System.out.println("Max profit : " + profit);

    }

}