class Solution {
    // Function to calculate the number of subsets with a given sum
    public int dfs(int[] nums, int curr, int[][] dp, int index){
        if(curr == 0) return 1;
        if(index >= nums.length) return 0;
        int ans = 0;
        if(dp[index][curr] != -1) return dp[index][curr];
        
        if(curr - nums[index] >= 0 && nums[index] != 0){
            ans += dfs(nums, curr - nums[index], dp, index + 1);
        }
        ans += dfs(nums, curr, dp, index + 1);
        
        // if(nums[index] == 0) return 0;
        return dp[index][curr] = ans;
    }
    public int perfectSum(int[] nums, int target) {
        int sum = 0;
        int count = 0;
        for(int val : nums) if(val == 0) count++;
        // if(target == 0) return (int)Math.pow(2, count);
        for(int val : nums) sum += val;
        int[][] dp = new int[nums.length][sum + 1];
        for(int i = 0; i < nums.length; i++) Arrays.fill(dp[i], -1);
        
        int start = 0;
        for(start = 0; start < nums.length; start++) if(nums[start] != 0) break;
        return dfs(nums, target, dp, start) * (int)Math.pow(2, count);
    }
}