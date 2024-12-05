public class maxStockProfit{
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        int minbuy=Integer.MAX_VALUE;
        int maxpro=0;
        for(int i=0;i<prices.length;i++){
            minbuy=Math.min(prices[i],minbuy);
            int pr=prices[i]-minbuy;
            maxpro=Math.max(maxpro,pr);
        }
        System.out.println(maxpro);
    }
}