class Solution {
    public int dfs(int index, int m, long[] suffixArr, int[][] dp){
        if(index >= suffixArr.length) return 0;
        if(dp[index][m] != -1) return dp[index][m];

        int res = 0;

        for(int i = 1; i <= 2 * m && index + i <= suffixArr.length; i++){
            int nextM = Math.max(i, m);
            
            int nextTurn = dfs(index + i, nextM, suffixArr, dp);

            res = Math.max(res, (int)suffixArr[index] - nextTurn);
        }

        return dp[index][m] = res;
    }
    public int stoneGameII(int[] piles) {
        if(piles.length == 1) return piles[0];
        
        long[] suffixArr = new long[piles.length];
        suffixArr[piles.length - 1] = piles[piles.length - 1];
        for(int i = piles.length - 2; i >= 0; i--){
            suffixArr[i] = piles[i] + suffixArr[i + 1];
        }

        int[][] dp = new int[piles.length][piles.length];
        for(int i = 0; i < piles.length; i++) Arrays.fill(dp[i], -1);

        return dfs(0, 1, suffixArr, dp);
    }
}