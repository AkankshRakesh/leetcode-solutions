class Solution {
    public int dfs(int[] nums, int index, int canRob, int[][] dp){
        if(index >= nums.length) return 0;
        
        if(dp[index][canRob] != -1) return dp[index][canRob];

        int pick = Integer.MIN_VALUE;
        if(canRob == 1 && nums[index] != -1){
            pick = nums[index] + dfs(nums, index + 1, 0, dp);
        }

        int notPick = dfs(nums, index + 1, 1, dp);

        return dp[index][canRob] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int[][] dp = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) Arrays.fill(dp[i], -1);
        
        int res1 = dfs(nums, 1, 1, dp);

        for(int i = 0; i < nums.length; i++) Arrays.fill(dp[i], -1);
        nums[nums.length - 1] = -1;
        int res2 = dfs(nums, 0, 1, dp);

        return Math.max(res1, res2);
    }
}