class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[][] dp = new long[n][k];
        dp[0][nums[0] % k] = 1;

        for(int i = 1; i < n; i++) {
            dp[i][nums[i] % k] = 1;
            for(int j = 0; j < k; j++)
                dp[i][(nums[i] % k) * j % k] += dp[i - 1][j];
        }

        long[] ans = new long[k];
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < n; j++) {
                ans[i] += dp[j][i];
            }
        }

        return ans;
    }
}  