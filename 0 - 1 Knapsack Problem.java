class Solution {
    public int dfs(int[] val, int[] wt, int currW, int[][] dp, int ind){
        if(ind >= val.length) return 0;
        if(dp[ind][currW] != -1) return dp[ind][currW];
        
        int ans = 0;
        if(currW >= wt[ind]){
            ans = val[ind] + dfs(val, wt, currW - wt[ind], dp, ind + 1);
        }
        
        ans = Math.max(ans, dfs(val, wt, currW, dp, ind + 1));
        return dp[ind][currW] = ans;
    }
    public int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int[val.length][W + 1];
        for(int i = 0; i < val.length; i++){
            for(int j = 0; j <= W; j++){
                dp[i][j] = -1;
            }
        }
        
        return dfs(val, wt, W, dp, 0);
    }
}
