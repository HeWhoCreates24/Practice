import java.util.*;

public class StockSpan{

    public static void stockSpan(int[] stocks, int[] spans){

        Stack<Integer> spanIndex = new Stack<>();

        spanIndex.push(0);

        spans[0] = 1;

        for(int i = 1; i < stocks.length; i++){
            int curr = stocks[i];

            boolean spanSet = false;

            while (!spanSet){
                if (!spanIndex.isEmpty()){
                    if (curr >= stocks[spanIndex.peek()]){
                        spanIndex.pop();
                    }
                    else{
                        spans[i] = i - spanIndex.peek();
                        spanIndex.push(i);
                        spanSet = true;
                    }
                }
                else{
                    spans[i] = i+1;
                    spanSet = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] stocks = {100, 80, 60, 70, 60, 85, 100};
        int[] spans = new int[stocks.length];

        stockSpan(stocks, spans);

        for(int span : spans){
            System.out.println(span + " ");
        }
    }
}