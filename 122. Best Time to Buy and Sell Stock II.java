class Solution {
    public int maxProfit(int[] prices) {
        int currStock = Integer.MAX_VALUE;
        int profit = 0;
        for(int price : prices){
            if(price > currStock){
                profit += price - currStock;
            }
            currStock = price;
        }

        return profit;
    }
}