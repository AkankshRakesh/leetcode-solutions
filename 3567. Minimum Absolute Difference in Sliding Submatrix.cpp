class Solution {
public:
    int findMinAbsDiff(const vector<vector<int>>& grid, int x, int y, int n, int m) {
        vector<int> nums;
        for (int i = x; i < n; i++) {
            for (int j = y; j < m; j++) {
                nums.push_back(grid[i][j]);
            }
        }
        sort(nums.begin(), nums.end());

        long long ans = INT_MAX;
        for (size_t i = 1; i < nums.size(); i++) {
            if (nums[i] == nums[i - 1]) continue;
            ans = min(ans, static_cast<long long>(nums[i]) - nums[i - 1]);
        }

        return ans == INT_MAX ? 0 : static_cast<int>(ans);
    }

    vector<vector<int>> minAbsDiff(const vector<vector<int>>& grid, int k) {
        int n = grid.size(), m = grid[0].size();
        vector<vector<int>> ans(n - k + 1, vector<int>(m - k + 1));

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < m - k + 1; j++) {
                ans[i][j] = findMinAbsDiff(grid, i, j, i + k, j + k);
            }
        }

        return ans;
    }
};

