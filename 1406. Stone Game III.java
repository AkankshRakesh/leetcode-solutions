class Solution {
    public int dfs(int[] nums, int index, int[] dp){
        if(index >= nums.length) return 0;

        if(dp[index] != Integer.MIN_VALUE) return dp[index];

        int res = Integer.MIN_VALUE;
        int next = 0;
        for(int i = index; i < nums.length; i++){
            if(index + 3 == i) break;
            
            next += nums[i];
            res = Math.max(res, next - dfs(nums, i + 1, dp));
        }

        return dp[index] = res;
    }
    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int res = dfs(stoneValue, 0, dp);
        if(res > 0) return "Alice";
        else if(res < 0) return "Bob";
        return "Tie";
    }
}