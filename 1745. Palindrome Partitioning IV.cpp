class Solution {
public:
    bool dfs(string& s, int i, int j, vector<vector<int>>& dp) {
        if (i < 0 || j < 0 || i >= s.length() || j >= s.length())
            return false;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (j - i + 1 == 1)
            return dp[i][j] = true;
        else if (j - i + 1 == 2)
            return dp[i][j] = (s[i] == s[j]);

        return dp[i][j] = (s[i] == s[j] && dfs(s, i + 1, j - 1, dp));
    }

    bool checkPartitioning(string s) {
        int n = s.length();
        vector<vector<int>> dp(n, vector<int>(n, -1));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dfs(s, i, j, dp);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (j - i + 1 >= 1 && j != n - 1 && i != n - 1 &&
                    dp[0][i] && dp[i + 1][j] && dp[j + 1][n - 1])
                    return true;
            }
        }

        return false;
    }
};  