class Solution {
public:
    bool dfs(const vector<int>& piles, int left, int right, bool aTurn, int aScore, int bScore, vector<vector<int>>& dp) {
        if (left >= right) return aScore > bScore;

        if (dp[left][right] != -1) return dp[left][right];
        
        if (aTurn) {
            return dp[left][right] = dfs(piles, left + 1, right, !aTurn, aScore + piles[left], bScore, dp) || 
                                    dfs(piles, left, right - 1, !aTurn, aScore + piles[right], bScore, dp);
        }
        
        return dp[left][right] = dfs(piles, left + 1, right, !aTurn, aScore, bScore + piles[left], dp) || 
                                dfs(piles, left, right - 1, !aTurn, aScore, bScore + piles[right], dp);
    }

    bool stoneGame(vector<int>& piles) {
        int n = piles.size();
        vector<vector<int>> dp(n, vector<int>(n, -1));
        
        return dfs(piles, 0, n - 1, true, 0, 0, dp);
    }
};

