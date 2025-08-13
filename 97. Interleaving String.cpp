class Solution {
public:
    bool dfs(const string &s1, const string &s2, const string &s3,
             int i, int j, int k, vector<vector<int>> &dp) {
        if (k >= s3.size()) {
            return (i >= s1.size() && j >= s2.size());
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        bool res = false;

        if (i < s1.size() && s1[i] == s3[k]) {
            res = dfs(s1, s2, s3, i + 1, j, k + 1, dp);
        }

        if (!res && j < s2.size() && s2[j] == s3[k]) {
            res = dfs(s1, s2, s3, i, j + 1, k + 1, dp);
        }

        return dp[i][j] = res;
    }

    bool isInterleave(string s1, string s2, string s3) {
        int n = s1.size(), m = s2.size();
        if (n + m != s3.size()) return false;

        vector<vector<int>> dp(n + 1, vector<int>(m + 1, -1));
        return dfs(s1, s2, s3, 0, 0, 0, dp);
    }
};
