class Solution {
public:
    int dfs(int n, int m, int i, int j, vector<vector<int>>& dp) {
        if (i >= n || j >= m) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int res = dfs(n, m, i + 1, j, dp) + dfs(n, m, i, j + 1, dp);

        dp[i][j] = res;

        return res;
    }

    int uniquePaths(int n, int m) {
        vector<vector<int>> dp(n, vector<int>(m, -1));
        dp[n - 1][m - 1] = 1;
        return dfs(n, m, 0, 0, dp);
    }
};
