class Solution {
public:
    int dfs(vector<vector<int>>& dp, int ind, int prev, vector<string>& strs) {
        if (ind == strs[0].length()) return 0;

        if (dp[ind][prev + 1] != -1) return dp[ind][prev + 1];

        if (prev == -1) {
            return dp[ind][prev + 1] =
                min(dfs(dp, ind + 1, ind, strs),
                    1 + dfs(dp, ind + 1, prev, strs));
        }

        bool check = true;
        for (string& str : strs) {
            if (str[prev] > str[ind]) {
                check = false;
                break;
            }
        }

        if (check) {
            return dp[ind][prev + 1] =
                min(dfs(dp, ind + 1, ind, strs),
                    1 + dfs(dp, ind + 1, prev, strs));
        }

        return dp[ind][prev + 1] = 1 + dfs(dp, ind + 1, prev, strs);
    }

    int minDeletionSize(vector<string>& strs) {
        vector<vector<int>> dp(120, vector<int>(120, -1));
        return dfs(dp, 0, -1, strs);
    }
};
