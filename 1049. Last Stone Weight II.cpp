class Solution {
public:
    int pickOrNot(const vector<int>& stones, int index, vector<vector<int>>& dp, int curr) {
        if (index >= (int)stones.size()) {
            if (curr < 0) return INT_MAX;
            return curr;
        }
        if (dp[index][curr] != -1) return dp[index][curr];

        return dp[index][curr] = min(
            pickOrNot(stones, index + 1, dp, curr + stones[index]),
            pickOrNot(stones, index + 1, dp, abs(curr - stones[index]))
        );
    }

    int lastStoneWeightII(vector<int>& stones) {
        int n = (int)stones.size();
        int sum = 0;
        for (int stone : stones) sum += stone;
        vector<vector<int>> dp(n, vector<int>(sum + 1, -1));

        return pickOrNot(stones, 0, dp, 0);
    }
};