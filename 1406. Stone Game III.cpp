class Solution {
public:
    int solve(const vector<int>& stoneValue, bool p1Turn, int index, vector<vector<int>>& dp) {
        if (index >= (int)stoneValue.size()) return 0;
        if (p1Turn) {
            if (dp[index][0] != -1) return dp[index][0];
            int c1 = solve(stoneValue, !p1Turn, index + 1, dp) + stoneValue[index];
            int c2 = INT_MIN, c3 = INT_MIN;
            if (index + 1 < (int)stoneValue.size()) 
                c2 = solve(stoneValue, !p1Turn, index + 2, dp) + stoneValue[index] + stoneValue[index + 1];
            if (index + 2 < (int)stoneValue.size()) 
                c3 = solve(stoneValue, !p1Turn, index + 3, dp) + stoneValue[index] + stoneValue[index + 1] + stoneValue[index + 2];

            return dp[index][0] = max(c1, max(c2, c3));
        }

        if (dp[index][1] != -1) return dp[index][1];
        int c1 = solve(stoneValue, !p1Turn, index + 1, dp) - stoneValue[index];
        int c2 = INT_MAX, c3 = INT_MAX;
        if (index + 1 < (int)stoneValue.size()) 
            c2 = solve(stoneValue, !p1Turn, index + 2, dp) - stoneValue[index] - stoneValue[index + 1];
        if (index + 2 < (int)stoneValue.size()) 
            c3 = solve(stoneValue, !p1Turn, index + 3, dp) - stoneValue[index] - stoneValue[index + 1] - stoneValue[index + 2];

        return dp[index][1] = min(c1, min(c2, c3));
    }

    string stoneGameIII(const vector<int>& stoneValue) {
        vector<vector<int>> dp(stoneValue.size(), vector<int>(2, -1));

        int res = solve(stoneValue, true, 0, dp);
        if (res > 0) return "Alice";
        else if (res < 0) return "Bob";

        return "Tie";
    }
};