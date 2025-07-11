class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;

        int currStock = prices[0];
        for(int i = 1; i < n; i++){
            if(prices[i] > currStock){
                profit += prices[i] - currStock;
            }
            currStock = prices[i];
        }
        
        return profit;
    }
}