class Solution {
public:
    long long dfs(vector<vector<int>>& grid, int i, int j, int pastMove, vector<vector<vector<long long>>>& dp) {
        if (i >= grid.size() || j >= grid[0].size()) return 0;
        if (i == grid.size() - 1 && j == grid[0].size() - 1) return 1;

        if (dp[i][j][pastMove] != -1) return dp[i][j][pastMove];

        long long ans = 0;
        if (grid[i][j] == 1) {
            if (pastMove == 0) {
                ans = dfs(grid, i + 1, j, 1, dp);
            }
            else {
                ans = dfs(grid, i, j + 1, 0, dp);
            }
        }
        else {
            ans += dfs(grid, i + 1, j, 1, dp) + dfs(grid, i, j + 1, 0, dp);
        }

        return dp[i][j][pastMove] = ans % 1000000007;
    }

    int uniquePaths(vector<vector<int>>& grid) {
        vector<vector<vector<long long>>> dp(
            grid.size(),
            vector<vector<long long>>(grid[0].size(), vector<long long>(2, -1))
        );

        return (int)dfs(grid, 0, 0, 0, dp);
    }
};