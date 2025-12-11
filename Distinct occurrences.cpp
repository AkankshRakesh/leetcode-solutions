class Solution {
public:
    int dfs(string &txt, string &pat, int ind1, int ind2, vector<vector<int>>& dp) {
        if (ind2 >= pat.length()) return 1;
        if (ind1 >= txt.length()) return 0;

        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

        int ans = 0;
        if (txt[ind1] == pat[ind2]) {
            ans += dfs(txt, pat, ind1 + 1, ind2 + 1, dp);
        }
        ans += dfs(txt, pat, ind1 + 1, ind2, dp);

        return dp[ind1][ind2] = ans;
    }

    int subseqCount(string txt, string pat) {
        vector<vector<int>> dp(txt.length(), vector<int>(pat.length(), -1));
        return dfs(txt, pat, 0, 0, dp);
    }
};
