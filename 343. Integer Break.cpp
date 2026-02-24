class Solution {
public:
    int pickNotPick(const vector<int>& nums, int index, int curr, vector<vector<int>>& dp) {
        if (curr == 0) return 1;
        if (index >= (int)nums.size()) return 0;
        if (dp[index][curr] != -1) return dp[index][curr];

        int pick = 0;
        if (curr - nums[index] >= 0) {
            pick = max(pickNotPick(nums, index, curr - nums[index], dp), pickNotPick(nums, index + 1, curr - nums[index], dp));
        }
        int notPick = pickNotPick(nums, index + 1, curr, dp);
        return dp[index][curr] = max(pick * nums[index], notPick);
    }

    int integerBreak(int n) {
        vector<int> nums(n);
        vector<vector<int>> dp(n, vector<int>(n + 1, -1));
        for (int i = 0; i < n; i++) nums[i] = i;

        return pickNotPick(nums, 1, n, dp);
    }
};