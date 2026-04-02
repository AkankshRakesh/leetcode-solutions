class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length, m = coins[0].length;

        int[][][] dp = new int[n][m][3];

        for(int k = 0; k < 3; k++){
            dp[0][0][k] = (coins[0][0] < 0 && k > 0) ? 0 : coins[0][0];
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0) continue;

                for(int k = 0; k < 3; k++){
                    int best = Integer.MIN_VALUE;

                    if(i > 0){
                        best = Math.max(best, dp[i-1][j][k] + coins[i][j]);

                        if(coins[i][j] < 0 && k > 0)
                            best = Math.max(best, dp[i-1][j][k-1]);
                    }

                    if(j > 0){
                        best = Math.max(best, dp[i][j-1][k] + coins[i][j]);

                        if(coins[i][j] < 0 && k > 0)
                            best = Math.max(best, dp[i][j-1][k-1]);
                    }

                    dp[i][j][k] = best;
                }
            }
        }

        return Math.max(
            dp[n-1][m-1][0],
            Math.max(dp[n-1][m-1][1], dp[n-1][m-1][2])
        );
    }
}