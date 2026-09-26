class Solution {
    public int dfs(int[] prices, int index, int canBuy, int[][] dp){
        if(index >= prices.length) return 0;

        if(dp[index][canBuy] != -1) return dp[index][canBuy];

        int pick = 0;
        if(canBuy == 1){
            pick = dfs(prices, index + 1, 0, dp) - prices[index];
        }
        else{
            pick = dfs(prices, index + 2, 1, dp) + prices[index];
        }

        int notPick = dfs(prices, index + 1, canBuy, dp);

        return dp[index][canBuy] = Math.max(pick, notPick);
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++) Arrays.fill(dp[i], -1);

        return dfs(prices, 0, 1, dp);
    }
}