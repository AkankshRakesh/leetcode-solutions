class Solution {
public:
    int numberOfSubmatrices(const vector<vector<char>>& grid) {
        int count = 0;
        int rows = grid.size();
        int cols = grid[0].size();
        vector<vector<bool>> XFound(rows, vector<bool>(cols, false));
        vector<vector<int>> dp(rows, vector<int>(cols, 0));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = (j - 1 >= 0) ? dp[i][j - 1] : 0;
                int top = (i - 1 >= 0) ? dp[i - 1][j] : 0;
                int diag = (i - 1 >= 0 && j - 1 >= 0) ? dp[i - 1][j - 1] : 0;

                dp[i][j] = (left + top) - diag;
                if (grid[i][j] == 'X') {
                    dp[i][j]++;
                    XFound[i][j] = true;
                }
                else if (grid[i][j] == 'Y') {
                    dp[i][j]--;
                }

                XFound[i][j] = XFound[i][j] || 
                               (i - 1 >= 0 ? XFound[i - 1][j] : false) || 
                               (j - 1 >= 0 ? XFound[i][j - 1] : false) || 
                               (i - 1 >= 0 && j - 1 >= 0 ? XFound[i - 1][j - 1] : false);

                if (dp[i][j] == 0 && XFound[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
};