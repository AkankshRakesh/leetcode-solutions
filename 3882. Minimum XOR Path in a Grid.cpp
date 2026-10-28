class Solution {
public:
    int dfs(vector<vector<int>>& grid, int i, int j, int x, vector<vector<vector<int>>>& dp) {
        if (i >= grid.size() || j >= grid[0].size()) return -1;
        if (i == grid.size() - 1 && j == grid[0].size() - 1) return x ^ grid[i][j];

        if (dp[i][j][x] != -1) return dp[i][j][x];

        int right = dfs(grid, i, j + 1, x ^ grid[i][j], dp);
        int down = dfs(grid, i + 1, j, x ^ grid[i][j], dp);

        right = right == -1 ? INT_MAX : right;
        down = down == -1 ? INT_MAX : down;

        return dp[i][j][x] = min(right, down);
    }

    int minCost(vector<vector<int>>& grid) {
        vector<vector<vector<int>>> dp(
            grid.size(),
            vector<vector<int>>(grid[0].size(), vector<int>(1024, -1))
        );

        return dfs(grid, 0, 0, 0, dp);
    }
};