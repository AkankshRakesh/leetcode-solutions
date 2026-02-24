class Solution {
    public int pickNotPick(int[] nums, int index, int curr, int[][] dp){
        if(curr == 0) return 1;
        if(index >= nums.length) return 0;
        if(dp[index][curr] != -1) return dp[index][curr];

        int pick = 0;
        if(curr - nums[index] >= 0){
            pick = Math.max(pickNotPick(nums, index, curr - nums[index], dp), pickNotPick(nums, index + 1, curr - nums[index], dp));
        }
        int notPick = pickNotPick(nums, index + 1, curr, dp);
        return dp[index][curr] = Math.max(pick * nums[index], notPick);
    }
    public int integerBreak(int n) {
        int[] nums = new int[n];
        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        for(int i = 0; i < n; i++) nums[i] = i;

        // int ans = 0;
        // for(int i = 2; i <= n; i++){
        //     ans = Math.max(ans, pickNotPick(nums, 1, 0, ))
        // }
        return pickNotPick(nums, 1, n, dp);
    }
}