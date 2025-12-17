class Solution {
    public int dfs(int[][] dp, int index, int[] val, int[] wt, int currCap){
        if(index >= val.length) return 0;
        if(dp[index][currCap] != -1) return dp[index][currCap];
        
        if(currCap - wt[index] >= 0){
            dp[index][currCap] = val[index] + 
            Math.max(dfs(dp, index + 1, val, wt, currCap - wt[index]) ,
            dfs(dp, index, val, wt, currCap - wt[index]));
        }
        
        return dp[index][currCap] = Math.max(dp[index][currCap], dfs(dp, index + 1, val, wt, currCap));
    }
    public int knapSack(int val[], int wt[], int capacity) {
        int[][] dp = new int[val.length][capacity + 1];
        for(int i = 0; i < val.length; i++) Arrays.fill(dp[i], -1);
        
        return dfs(dp, 0, val, wt, capacity);
    }
}