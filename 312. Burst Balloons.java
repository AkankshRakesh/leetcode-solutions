class Solution {
    public int maxCoins(int[] nums) {
        int m = nums.length;
        int[] arr = new int[m + 2];
        arr[0] = 1;
        for(int i = 0; i < m; i++) arr[i + 1] = nums[i];
        arr[m + 1] = 1;
        int n = m + 2;

        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Integer.MIN_VALUE;

                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j]
                               + arr[i] * arr[k] * arr[j];
                    if (cost > dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}