class Solution {
public:
    int numDecodings(const std::string& s) {
        if (s[0] == '0') return 0;

        std::vector<int> dp(s.length());
        dp[0] = 1;
        if (s.length() == 1) return 1;
        dp[1] = s[1] == '0' ? 0 : 1;

        for (size_t i = 2; i < s.length(); i++) {
            if (s[i] == '0') continue;
            int num = std::stoi(s.substr(i - 2, 2));

            if (num > 26) dp[i] = dp[i - 1];
            else dp[i] = dp[i - 1] + dp[i - 2];
        }

        int num = std::stoi(s.substr(s.length() - 2, 2));
        if (num > 26) return dp[s.length() - 1];

        return dp[s.length() - 1] + dp[s.length() - 2];
    }
};