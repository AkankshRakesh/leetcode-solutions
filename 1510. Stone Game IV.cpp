class Solution {
public:
    bool dfs(int n, const vector<int>& arr, bool aTurn, vector<vector<int>>& dp) {
        if (n <= 0) {
            if (aTurn) return false;
            return true;
        }

        int index = aTurn ? 0 : 1;
        if (dp[n][index] != -1) return dp[n][index];

        if (!aTurn) {
            bool res = true;
            for (size_t i = 0; i < arr.size(); i++) {
                if (arr[i] > n) break;

                res &= dfs(n - arr[i], arr, !aTurn, dp);
            }    

            return dp[n][index] = res;
        }

        bool res = false;
        for (size_t i = 0; i < arr.size(); i++) {
            if (arr[i] > n) break;

            res |= dfs(n - arr[i], arr, !aTurn, dp);
        }

        return dp[n][index] = res;
    }

    bool winnerSquareGame(int n) {
        vector<int> arr;
        for (int i = 1; i * i <= n; i++) {
            arr.push_back(i * i);
        }
        // -1 represents null/uncalculated, 0 represents false, 1 represents true
        vector<vector<int>> dp(n + 1, vector<int>(2, -1));

        return dfs(n, arr, true, dp);
    }
};