class Solution {
public:
    int MOD = 1000000007;

    int backtrack(vector<vector<int>>& grid, int i, int j, 
                  vector<vector<vector<int>>>& dp, int curr, 
                  int n, int m, int k) {
        
        if (i >= n || j >= m || i < 0 || j < 0) return 0;

        if (i == n - 1 && j == m - 1) {
            if ((curr + grid[i][j]) % k == 0) return 1;
            return 0;
        }

        int nextCurr = (curr + grid[i][j]) % k;

        if (dp[i][j][nextCurr] != -1) return dp[i][j][nextCurr];

        int down = backtrack(grid, i + 1, j, dp, nextCurr, n, m, k);
        int right = backtrack(grid, i, j + 1, dp, nextCurr, n, m, k);

        dp[i][j][nextCurr] = (down + right) % MOD;
        
        return dp[i][j][nextCurr];
    }

    int numberOfPaths(vector<vector<int>>& grid, int k) {
        int n = grid.size();
        int m = grid[0].size();

        vector<vector<vector<int>>> dp(n, vector<vector<int>>(m, vector<int>(k, -1)));

        return backtrack(grid, 0, 0, dp, 0, n, m, k);
    }
};
