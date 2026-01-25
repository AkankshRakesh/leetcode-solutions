class Solution {
public:
    bool isMatch(const std::string& s, const std::string& p) {
        std::vector<std::vector<bool>> dp(s.length() + 1, std::vector<bool>(p.length() + 1, false));
        dp[0][0] = true;
        for (size_t j = 1; j <= p.length(); j++) {
            if (p[j - 1] == '*') dp[0][j] = dp[0][j - 1];
        }
        if (s.length() == 0) {
            for (char c : p) if (c != '*') return false;
            return true;
        }

        for (size_t i = 1; i <= s.length(); i++) {
            for (size_t j = 1; j <= p.length(); j++) {
                if (s[i - 1] == p[j - 1] || p[j - 1] == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (p[j - 1] == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }

        return dp[s.length()][p.length()];
    }
};