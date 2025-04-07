class Solution {
    public boolean canPartition(int[] nums) {
        int totSum = 0;
        for(int num : nums) totSum += num;

        if(totSum % 2 != 0) return false;

        int resSum = totSum/2;
        boolean[] dp = new boolean[resSum + 1];

        dp[0] = true;

        for(int num : nums){
            for(int currSum = resSum; currSum >= num; currSum--){
                dp[currSum] = dp[currSum] || dp[currSum - num];
                if(dp[resSum]) return true;
            }
        }
        return dp[resSum];
    }
}