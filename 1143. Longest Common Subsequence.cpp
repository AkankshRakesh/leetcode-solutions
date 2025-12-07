class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        vector<vector<int>> dp(n1, vector<int>(n2, 0));

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                int top = i > 0 ? dp[i - 1][j] : 0;
                int left = j > 0 ? dp[i][j - 1] : 0;
                dp[i][j] = max(top, left);
                if (text1[i] == text2[j]) {
                    dp[i][j] = (i > 0 && j > 0) ? dp[i - 1][j - 1] + 1 : 1;
                }
            }
        }

        return dp[n1 - 1][n2 - 1];
    }
};
