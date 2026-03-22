class Solution {
public:
    int dfs(const vector<int>& nums, int index, vector<vector<vector<int>>>& dp, int curr, int target, int count) {
        if (index >= (int)nums.size()) {
            if (curr == target) return count;
            return INT_MIN;
        }
        if (dp[index][count][curr] != -1) return dp[index][count][curr];

        return dp[index][count][curr] = max(
            dfs(nums, index + 1, dp, curr ^ nums[index], target, count + 1),
            dfs(nums, index + 1, dp, curr, target, count)
        );
    }

    int minRemovals(vector<int>& nums, int target) {
        int max_val = nums[0];
        for (int num : nums) max_val = max(max_val, num);
        int bits = 0;
        while (max_val != 0) {
            max_val /= 2;
            bits++;
        }
        vector<vector<vector<int>>> dp(nums.size(), vector<vector<int>>(nums.size() + 1, vector<int>(1 << bits, -1)));

        int res = dfs(nums, 0, dp, 0, target, 0);
        if (res == INT_MIN) return -1;
        return (int)nums.size() - res;
    }
};