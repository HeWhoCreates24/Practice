
public class BestBuySellStocks{
    public static void main(String[] args) {
        
        int[] prices = {7, 1, 5, 3, 6, 4};
        
        int profit = 0;
        int buy = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            }
            else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }

        System.out.println("Maximum Profit: " + profit);
    }
}