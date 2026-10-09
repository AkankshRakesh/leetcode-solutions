class Solution {
    public int dfs(int[] nums, int left, int right, int[][] dp){
        if(left > right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        int ans = 0;
        int next = right + 1 < nums.length ? nums[right + 1] : 1;
        int prev = left - 1 >= 0 ? nums[left - 1] : 1;
        
        for(int i = left; i <= right; i++){
            int curr = nums[i] * prev * next;
            ans = Math.max(ans, curr + dfs(nums, left, i - 1, dp) + dfs(nums, i + 1, right, dp));
        }

        return dp[left][right] = ans;
    }
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) Arrays.fill(dp[i], -1);
        return dfs(nums, 0, nums.length - 1, dp);
    }
}