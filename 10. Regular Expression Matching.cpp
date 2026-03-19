class Solution {
public:
    bool checkPattern(const string& p, int index) {
        if (index >= (int)p.length()) return true;

        if (index + 1 >= (int)p.length() || p[index + 1] != '*') return false;
        return checkPattern(p, index + 2);
    }

    bool backtrack(const string& s, const string& p, int i, int j, vector<vector<int>>& dp) {
        if (i >= (int)s.length() && j >= (int)p.length()) return true;
        if (j >= (int)p.length()) return false;
        if (i >= (int)s.length()) {
            return checkPattern(p, j);
        }
        if (dp[i][j] != -1) return dp[i][j];

        if (j + 1 < (int)p.length() && p[j + 1] == '*') {
            if (s[i] == p[j] || p[j] == '.') {
                dp[i][j] = backtrack(s, p, i + 1, j, dp) || backtrack(s, p, i + 1, j + 2, dp) || backtrack(s, p, i, j + 2, dp);
            } else {
                dp[i][j] = backtrack(s, p, i, j + 2, dp);
            }
        } else if (s[i] == p[j] || p[j] == '.') {
            dp[i][j] = backtrack(s, p, i + 1, j + 1, dp);
        } else {
            dp[i][j] = false;
        }
        return dp[i][j];
    }

    bool isMatch(const string& s, const string& p) {
        vector<vector<int>> dp(s.length(), vector<int>(p.length(), -1));
        return backtrack(s, p, 0, 0, dp);
    }
};