
import java.util.Arrays;
import java.util.Comparator;

public class ChocolaProblem{

    public static void main(String[] args) {
        
        // given
        Integer[] vCuts = {2, 1, 3, 1, 4};
        Integer[] hCuts = {2, 1, 4};

        // track pieces
        int hPieces = 1;
        int vPieces = 1;

        // track cost
        int cost = 0;

        // sort cuts greedily
        Arrays.sort(vCuts, Comparator.reverseOrder());
        Arrays.sort(hCuts, Comparator.reverseOrder());

        int i = 0, j = 0;

        while (i < vCuts.length && j < hCuts.length){

            int vCut = vCuts[i];
            int hCut = hCuts[j];

            if (vCut >= hCut){

                cost += vCut * hPieces;
                vPieces++;
                i++;

            }
            else{

                cost += hCut * vPieces;
                hPieces++;
                j++;

            }


        }

        while (i < vCuts.length){

            cost += vCuts[i] * hPieces;
            vPieces++;
            i++;

        }

        while (j < hCuts.length){

            cost += hCuts[j] * vPieces;
            hPieces++;
            j++;

        }

        // display answer
        System.out.println("Total cost : " + cost);

    }

}