class Solution {
public:
    int backtrack(vector<vector<int>>& triangle, vector<vector<int>>& dp, int i, int j, int n) {
        if (i == n - 1) {
            return triangle[i][j];
        }
        if (dp[i][j] != INT_MAX) {
            return dp[i][j];
        }

        int left = backtrack(triangle, dp, i + 1, j, n);
        int right = backtrack(triangle, dp, i + 1, j + 1, n);
        dp[i][j] = triangle[i][j] + min(left, right);
        return dp[i][j];
    }

    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, INT_MAX));

        dp[0][0] = backtrack(triangle, dp, 0, 0, n);
        return dp[0][0];
    }
};
