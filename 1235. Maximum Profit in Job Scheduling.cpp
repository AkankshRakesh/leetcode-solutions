class Solution {
public:
    int pickInd(const vector<vector<int>>& nums, int index) {
        int left = index, right = (int)nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[index - 1][1] <= nums[mid][0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    int dfs(const vector<vector<int>>& nums, vector<int>& dp, int index) {
        if (index >= (int)nums.size()) return 0;
        if (dp[index] != -1) return dp[index];

        int notPick = dfs(nums, dp, index + 1);
        int nextIndex = pickInd(nums, index + 1);
        int pick = nums[index][2] + dfs(nums, dp, nextIndex);

        return dp[index] = max(pick, notPick);
    }

    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        int n = (int)startTime.size();
        vector<vector<int>> nums(n, vector<int>(3));
        for (int i = 0; i < n; i++) {
            nums[i][0] = startTime[i];
            nums[i][1] = endTime[i];
            nums[i][2] = profit[i];
        }
        sort(nums.begin(), nums.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });

        vector<int> dp(n, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, dfs(nums, dp, i));
        }
        return ans;
    }
};