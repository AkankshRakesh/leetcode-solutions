class Solution {
public:
    int countPathsWithXorValue(vector<vector<int>>& grid, int k) {
        int m = grid.size(), n = grid[0].size();
        const int MOD = 1e9 + 7;
        
        vector<vector<unordered_map<int, int>>> dp(m, vector<unordered_map<int, int>>(n));
        
        dp[0][0][grid[0][0]] = 1;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (auto& [current_xor, count] : dp[i][j]) {
                    if (j + 1 < n) {
                        dp[i][j + 1][current_xor ^ grid[i][j + 1]] = (dp[i][j + 1].count(current_xor ^ grid[i][j + 1]) ? dp[i][j + 1][current_xor ^ grid[i][j + 1]] + count : count) % MOD;
                    }
                    if (i + 1 < m) {
                        dp[i + 1][j][current_xor ^ grid[i + 1][j]] = (dp[i + 1][j].count(current_xor ^ grid[i + 1][j]) ? dp[i + 1][j][current_xor ^ grid[i + 1][j]] + count : count) % MOD;
                    }
                }
            }
        }
        
        // Return the result at the bottom-right corner (m-1, n-1) with XOR == k
        return dp[m - 1][n - 1].count(k) ? dp[m - 1][n - 1][k] : 0;
    }
};