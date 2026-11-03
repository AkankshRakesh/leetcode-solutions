class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        for(int num : nums) max = max > num ? max : num;

        int ans = 0;
        for(int num : nums) ans += (max - num);

        return ans;
    }
}