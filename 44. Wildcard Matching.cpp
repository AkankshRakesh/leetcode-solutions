class Solution {
public:
    bool dfs(const std::string& s, const std::string& p, int i, int j, std::vector<std::vector<int>>& dp) {
        if (i >= (int)s.length() && j >= (int)p.length()) return true;
        if (j >= (int)p.length()) return false;
        if (i >= (int)s.length()) {
            for (int jj = j; jj < (int)p.length(); jj++) 
                if (p[jj] != '*') return false;
            return true;
        }
        if (dp[i][j] != -1) return dp[i][j];

        if (s[i] == p[j] || p[j] == '?') 
            return dp[i][j] = dfs(s, p, i + 1, j + 1, dp);
        else if (p[j] == '*') 
            return dp[i][j] = dfs(s, p, i + 1, j + 1, dp) || dfs(s, p, i + 1, j, dp) || dfs(s, p, i, j + 1, dp);

        return dp[i][j] = false;
    }

    bool isMatch(const std::string& s, const std::string& p) {
        std::vector<std::vector<int>> dp(s.length(), std::vector<int>(p.length(), -1));
        return dfs(s, p, 0, 0, dp);
    }
};

