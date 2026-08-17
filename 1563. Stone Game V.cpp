class Solution {
public:
    int dfs(vector<int>& stoneValue, int left, int right, vector<vector<int>>& dp) {
        if (left >= right) return 0;
        if (dp[left][right] != -1) return dp[left][right];

        vector<int> prefix(right - left + 1);
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += stoneValue[i];
            prefix[i - left] = sum;
        }

        int maxValue = 0;
        for (int i = left; i < right; i++) {
            int leftSum = prefix[i - left];
            int rightSum = sum - leftSum;

            if (leftSum > rightSum) {
                int res = dfs(stoneValue, i + 1, right, dp);
                maxValue = max(maxValue, res + rightSum);
            }
            else if (leftSum < rightSum) {
                int res = dfs(stoneValue, left, i, dp);
                maxValue = max(maxValue, res + leftSum);
            }
            else {
                int res = max(
                    dfs(stoneValue, i + 1, right, dp),
                    dfs(stoneValue, left, i, dp)
                );
                maxValue = max(maxValue, res + leftSum);
            }
        }

        return dp[left][right] = maxValue;
    }

    int stoneGameV(vector<int>& stoneValue) {
        vector<vector<int>> dp(
            stoneValue.size(),
            vector<int>(stoneValue.size(), -1)
        );

        return dfs(stoneValue, 0, stoneValue.size() - 1, dp);
    }
};