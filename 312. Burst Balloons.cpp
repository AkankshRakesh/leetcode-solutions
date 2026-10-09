class Solution {
public:
    int dfs(vector<int>& nums, int left, int right, vector<vector<int>>& dp) {
        if (left > right) return 0;

        if (dp[left][right] != -1) return dp[left][right];

        int ans = 0;
        int next = right + 1 < nums.size() ? nums[right + 1] : 1;
        int prev = left - 1 >= 0 ? nums[left - 1] : 1;

        for (int i = left; i <= right; i++) {
            int curr = nums[i] * prev * next;
            ans = max(ans, curr + dfs(nums, left, i - 1, dp) + dfs(nums, i + 1, right, dp));
        }

        return dp[left][right] = ans;
    }

    int maxCoins(vector<int>& nums) {
        vector<vector<int>> dp(nums.size(), vector<int>(nums.size(), -1));
        return dfs(nums, 0, nums.size() - 1, dp);
    }
};