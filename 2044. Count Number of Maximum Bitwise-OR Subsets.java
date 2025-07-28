class Solution {
    int ans = 0;

    public void backtrack(int[] nums, int ind, int n, int currOr, int targetOr) {
        if (ind >= n) {
            if (currOr == targetOr) ans++;
            return;
        }

        backtrack(nums, ind + 1, n, currOr | nums[ind], targetOr);
        backtrack(nums, ind + 1, n, currOr, targetOr);
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = nums[0];
        for (int num : nums)
            maxOr |= num;

        backtrack(nums, 0, nums.length, 0, maxOr);
        return ans;
    }
}