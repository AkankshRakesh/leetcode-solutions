class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int n = cost.size();
        vector<int> dp(n + 1, 0);

        dp[n] = 0;
        dp[n - 1] = cost[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = cost[i] + min(dp[i + 1], dp[i + 2]);
        }
        return min(dp[0], dp[1]);
    }
};
