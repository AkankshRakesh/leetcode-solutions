class Solution {
public:
    vector<vector<int>> constructProductMatrix(const vector<vector<int>>& grid) {
        int n = grid.size() * grid[0].size();
        vector<int> nums(n);
        vector<int> ans(n);
        int index = 0;
        for (int i = 0; i < (int)grid.size(); i++) {
            for (int j = 0; j < (int)grid[0].size(); j++) {
                nums[index++] = grid[i][j];
            }
        }

        long long past = nums[0] % 12345;
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = (int)past;
            past = (past * nums[i]) % 12345;
        }
        past = nums[n - 1] % 12345;
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = (int)((ans[i] * past) % 12345);
            past = (past * nums[i]) % 12345;
        }

        vector<vector<int>> res(grid.size(), vector<int>(grid[0].size()));
        index = 0;
        for (int i = 0; i < (int)grid.size(); i++) {
            for (int j = 0; j < (int)grid[0].size(); j++) {
                res[i][j] = ans[index++];
            }
        }

        return res;
    }
};