class Solution {
public:
    int coinChange(std::vector<int>& coins, int amount) {
        std::vector<int> dp(amount + 1, INT_MAX);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != INT_MAX) {
                    dp[i] = std::min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        return dp[amount] == INT_MAX ? -1 : dp[amount];
    }
};