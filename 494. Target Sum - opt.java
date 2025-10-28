class Solution {
    int ans = 0;
    int[][] dp;
    public int backtrack(int[] nums, int index, int currSum, int target, int totalSum){
        if(index >= nums.length){
            if(currSum == target) return 1;
            return 0;
        }

        if(dp[index][totalSum + currSum] != Integer.MIN_VALUE) return dp[index][totalSum + currSum];
        
        dp[index][totalSum + currSum] = backtrack(nums, index + 1, currSum + nums[index], target, totalSum) + backtrack(nums, index + 1, currSum - nums[index], target, totalSum);

        return dp[index][totalSum + currSum];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;

        dp = new int[nums.length][2 * totalSum + 1];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j <= 2 * totalSum; j++) dp[i][j] = Integer.MIN_VALUE;
        }

        return backtrack(nums, 0, 0, target, totalSum);
    }
}