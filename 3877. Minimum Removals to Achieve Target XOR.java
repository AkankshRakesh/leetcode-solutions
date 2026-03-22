class Solution {
    public int dfs(int[] nums, int index, int[][][] dp, int curr, int target, int count){
        if(index >= nums.length){
            if(curr == target) return count;
            return Integer.MIN_VALUE;
        }
        if(dp[index][count][curr] != -1) return dp[index][count][curr];

        return dp[index][count][curr] = Math.max(dfs(nums, index + 1, dp, curr ^ nums[index], target, count + 1), dfs(nums, index + 1, dp, curr, target, count));
    }
    public int minRemovals(int[] nums, int target) {
        int max = nums[0];
        for(int num : nums) max = Math.max(max, num);
        int bits = 0;
        while(max != 0){
            max /= 2;
            bits++;
        }
        int[][][] dp = new int[nums.length][nums.length + 1][1 << bits];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j <= nums.length; j++) Arrays.fill(dp[i][j], -1);
        }

        if(dfs(nums, 0, dp, 0, target, 0) == Integer.MIN_VALUE) return -1;
        return nums.length - dfs(nums, 0, dp, 0, target, 0);
    }
}