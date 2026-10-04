class Solution {
public:
    bool dfs(string s, int index, int op, vector<vector<int>>& dp) {
        if (index >= s.length()) return op == 0;

        if (dp[index][op] != -1) return dp[index][op];

        bool res = false;
        char ch = s[index];

        if (ch == '*') {
            res |= dfs(s, index + 1, op + 1, dp);
            if (op != 0) res |= dfs(s, index + 1, op - 1, dp);
            res |= dfs(s, index + 1, op, dp);
        }
        else if (ch == '(') {
            res = dfs(s, index + 1, op + 1, dp);
        }
        else if (ch == ')' && op != 0) {
            res = dfs(s, index + 1, op - 1, dp);
        }

        return dp[index][op] = res;
    }

    bool checkValidString(string s) {
        vector<vector<int>> dp(s.length(), vector<int>(s.length(), -1));

        return dfs(s, 0, 0, dp);
    }
};