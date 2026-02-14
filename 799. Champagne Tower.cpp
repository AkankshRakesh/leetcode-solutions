class Solution {
public:
    double champagneTower(int poured, int row, int glass) {
        vector<vector<double>> dp(row + 1, vector<double>(row + 1, 0.0));
        dp[0][0] = static_cast<double>(poured);
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j <= i; j++) {
                double prev = j != 0 ? dp[i - 1][j - 1] : 0;
                prev = max(0.0, prev - 1) / 2.0;

                double top = j != i ? dp[i - 1][j] : 0;
                top = max(0.0, top - 1) / 2.0;

                dp[i][j] = prev + top;
            }
        }

        if (dp[row][glass] > 1) return 1.0;
        return dp[row][glass];
    }
};

