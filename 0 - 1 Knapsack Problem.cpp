class Solution {
public:
    int dfs(vector<int>& val, vector<int>& wt, int currW, vector<vector<int>>& dp, int ind) {
        if (ind >= val.size()) return 0;
        if (dp[ind][currW] != -1) return dp[ind][currW];

        int ans = 0;
        if (currW >= wt[ind]) {
            ans = val[ind] + dfs(val, wt, currW - wt[ind], dp, ind + 1);
        }

        ans = max(ans, dfs(val, wt, currW, dp, ind + 1));
        return dp[ind][currW] = ans;
    }

    int knapsack(int W, vector<int>& val, vector<int>& wt) {
        int n = val.size();
        vector<vector<int>> dp(n, vector<int>(W + 1, -1));

        return dfs(val, wt, W, dp, 0);
    }
};
