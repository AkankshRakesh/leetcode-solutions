class Solution {
    static double waterOverflow(int K, int R, int C) {
        double ans = 0;
        double[][] dp = new double[K + 1][K + 1];
        
        int col = 1;
        dp[0][0] = K;
        for(int i = 0; i < K; i++){
            for(int j = 0; j < col; j++){
                double curr = dp[i][j];
                double extra = curr - 1.0;
                if(extra <= 0) continue;
                dp[i + 1][j] += extra / 2.0;
                dp[i + 1][j + 1] += extra / 2.0;
                dp[i][j] = 1;
            }
            col++;
        }
        
        return dp[R - 1][C - 1];
    }
}