class Solution {
public:
    int dfs(int i, int n, vector<int>& costs, vector<int>& dp) {
        if (i > n) return -1;
        if (i == n) return costs[n - 1];

        if (dp[i] != -1) return dp[i];

        int one = dfs(i + 1, n, costs, dp);
        int two = dfs(i + 2, n, costs, dp);
        int three = dfs(i + 3, n, costs, dp);

        if (one == -1 && two == -1 && three == -1) return -1;
        if (one != -1) one++;
        if (two != -1) two += 4;
        if (three != -1) three += 9;

        if (one == -1) one = INT_MAX;
        if (two == -1) two = INT_MAX;
        if (three == -1) three = INT_MAX;

        int ans = min(one, min(two, three));
        if (i == 0) return dp[i] = ans;

        return dp[i] = ans + costs[i - 1];
    }

    int climbStairs(int n, vector<int>& costs) {
        vector<int> dp(n + 1, -1);

        return dfs(0, n, costs, dp);
    }
};