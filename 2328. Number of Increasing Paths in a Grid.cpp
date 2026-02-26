class Solution {
public:
    const int MOD = 1'000'000'007;

    int dfs(const vector<vector<int>>& grid, vector<vector<bool>>& visited, int i, int j, int past, vector<vector<int>>& dp) {
        if (i < 0 || j < 0 || i >= (int)grid.size() || j >= (int)grid[0].size() || grid[i][j] <= past || visited[i][j]) 
            return 0;
        if (dp[i][j] != -1) 
            return dp[i][j];
        visited[i][j] = true;

        long long ans = 1;
        ans += dfs(grid, visited, i + 1, j, grid[i][j], dp);
        ans += dfs(grid, visited, i, j - 1, grid[i][j], dp);
        ans += dfs(grid, visited, i, j + 1, grid[i][j], dp);
        ans += dfs(grid, visited, i - 1, j, grid[i][j], dp);
        ans %= MOD;

        visited[i][j] = false;
        return dp[i][j] = (int)ans;
    }

    int countPaths(vector<vector<int>>& grid) {
        int ans = 0;
        int m = (int)grid.size();
        int n = (int)grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        vector<vector<int>> dp(m, vector<int>(n, -1));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dfs(grid, visited, i, j, -1, dp)) % MOD;
            }
        }

        return ans;
    }
};