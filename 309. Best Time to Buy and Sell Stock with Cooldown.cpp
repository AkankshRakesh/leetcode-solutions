class Solution {
public:
    int dfs(vector<int>& prices, int index, int canBuy, vector<vector<int>>& dp) {
        if (index >= prices.size()) return 0;

        if (dp[index][canBuy] != -1)
            return dp[index][canBuy];

        int pick = 0;

        if (canBuy == 1) {
            pick = dfs(prices, index + 1, 0, dp) - prices[index];
        }
        else {
            pick = dfs(prices, index + 2, 1, dp) + prices[index];
        }

        int notPick = dfs(prices, index + 1, canBuy, dp);

        return dp[index][canBuy] = max(pick, notPick);
    }

    int maxProfit(vector<int>& prices) {
        vector<vector<int>> dp(prices.size(), vector<int>(2, -1));

        return dfs(prices, 0, 1, dp);
    }
};