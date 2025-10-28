class Solution {
    int ans = 0;
    public void backtrack(int[] nums, int index, int currSum, int target){
        if(index >= nums.length){
            if(currSum == target) ans++;
            return;
        }

        backtrack(nums, index + 1, currSum + nums[index], target);
        backtrack(nums, index + 1, currSum - nums[index], target);
    }
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, 0, 0, target);
        return ans;
    }
}