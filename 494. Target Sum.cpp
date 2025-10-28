class Solution {
public:
    int ans = 0;
    vector<vector<int>> dp;

    int backtrack(vector<int>& nums, int index, int currSum, int target, int totalSum) {
        if (index >= nums.size()) {
            if (currSum == target) return 1;
            return 0;
        }

        if (dp[index][totalSum + currSum] != INT_MIN)
            return dp[index][totalSum + currSum];

        dp[index][totalSum + currSum] =
            backtrack(nums, index + 1, currSum + nums[index], target, totalSum) +
            backtrack(nums, index + 1, currSum - nums[index], target, totalSum);

        return dp[index][totalSum + currSum];
    }

    int findTargetSumWays(vector<int>& nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        dp.assign(nums.size(), vector<int>(2 * totalSum + 1, INT_MIN));

        return backtrack(nums, 0, 0, target, totalSum);
    }
};