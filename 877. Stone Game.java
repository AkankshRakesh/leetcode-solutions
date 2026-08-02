class Solution {
    public boolean dfs(int[] piles, int left, int right, boolean aTurn, int aScore, int bScore, Boolean[][] dp){
        if(left >= right) return aScore > bScore;

        if(dp[left][right] != null) return dp[left][right];
        
        if(aTurn){
            return dp[left][right] = dfs(piles, left + 1, right, !aTurn, aScore + piles[left], bScore, dp) || dfs(piles, left, right - 1, !aTurn, aScore + piles[right], bScore, dp);
        }
        
        return dp[left][right] = dfs(piles, left + 1, right, !aTurn, aScore, bScore + piles[left], dp) || dfs(piles, left, right - 1, !aTurn, aScore, bScore + piles[right], dp);
    }
    public boolean stoneGame(int[] piles) {
        Boolean[][] dp = new Boolean[piles.length][piles.length];
        
        return dfs(piles, 0, piles.length - 1, true, 0, 0, dp);
    }
}