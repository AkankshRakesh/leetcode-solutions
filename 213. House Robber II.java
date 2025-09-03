class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]); 
        int[] dp = new int[n];
        int ans = 0;

        dp[0] = nums[0];
        dp[1] = Math.max(dp[1], dp[0]);
        for(int i = 2; i < n - 1; i++) dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        ans = dp[n - 2];
        dp = new int[n];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for(int i = 3; i < n; i++) dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);

        return Math.max(dp[n - 1], ans);
    }
}