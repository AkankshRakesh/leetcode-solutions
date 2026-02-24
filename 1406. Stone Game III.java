class Solution {
    public int solve(int[] stoneValue, boolean p1Turn, int index, int[][] dp){
        if(index >= stoneValue.length) return 0;
        if(p1Turn){
            if(dp[index][0] != -1) return dp[index][0];
            int c1 = solve(stoneValue, !p1Turn, index + 1, dp) + stoneValue[index];
            int c2 = Integer.MIN_VALUE, c3 = Integer.MIN_VALUE;
            if(index + 1 < stoneValue.length) c2 = solve(stoneValue, !p1Turn, index + 2, dp) + stoneValue[index] + stoneValue[index + 1];
            if(index + 2 < stoneValue.length) c3 = solve(stoneValue, !p1Turn, index + 3, dp) + stoneValue[index] + stoneValue[index + 1] + stoneValue[index + 2];

            return dp[index][0] = Math.max(c1, Math.max(c2, c3));
        }
        
        if(dp[index][1] != -1) return dp[index][1];
        int c1 = solve(stoneValue, !p1Turn, index + 1, dp) - stoneValue[index];
        int c2 = Integer.MAX_VALUE, c3 = Integer.MAX_VALUE;
        if(index + 1 < stoneValue.length) c2 = solve(stoneValue, !p1Turn, index + 2, dp) - stoneValue[index] - stoneValue[index + 1];
        if(index + 2 < stoneValue.length) c3 = solve(stoneValue, !p1Turn, index + 3, dp) - stoneValue[index] - stoneValue[index + 1] - stoneValue[index + 2];

        return dp[index][1] = Math.min(c1, Math.min(c2, c3)); 
    }
    public String stoneGameIII(int[] stoneValue) {
        int[][] dp = new int[stoneValue.length][2];
        for(int i = 0; i < stoneValue.length; i++) Arrays.fill(dp[i], -1);

        int res = solve(stoneValue, true, 0, dp);
        if(res > 0) return "Alice";
        else if(res < 0) return "Bob";

        return "Tie";
    }
}