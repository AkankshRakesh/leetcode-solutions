class Solution {
public:
    int dfs(int index, int m, const vector<long long>& suffixArr, vector<vector<int>>& dp){
        if(index >= suffixArr.size()) return 0;
        if(dp[index][m] != -1) return dp[index][m];

        int res = 0;

        for(int i = 1; i <= 2 * m && index + i <= suffixArr.size(); i++){
            int nextM = max(i, m);
            
            int nextTurn = dfs(index + i, nextM, suffixArr, dp);

            res = max(res, (int)suffixArr[index] - nextTurn);
        }

        return dp[index][m] = res;
    }

    int stoneGameII(vector<int>& piles) {
        int n = piles.size();
        if(n == 1) return piles[0];
        
        vector<long long> suffixArr(n);
        suffixArr[n - 1] = piles[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suffixArr[i] = piles[i] + suffixArr[i + 1];
        }

        vector<vector<int>> dp(n, vector<int>(n, -1));

        return dfs(0, 1, suffixArr, dp);
    }
};