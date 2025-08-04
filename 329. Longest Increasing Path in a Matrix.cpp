class Solution {
public:
    int trav(vector<vector<int>>& matrix, vector<vector<int>>& memo, int lastEle, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) return 0;

        if (lastEle >= matrix[i][j]) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int found = 1 + max({
            trav(matrix, memo, matrix[i][j], i + 1, j, n, m),
            trav(matrix, memo, matrix[i][j], i - 1, j, n, m),
            trav(matrix, memo, matrix[i][j], i, j + 1, n, m),
            trav(matrix, memo, matrix[i][j], i, j - 1, n, m)
        });

        memo[i][j] = found;
        return found;
    }

    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        int maxPath = 1;
        vector<vector<int>> memo(n, vector<int>(m, -1));

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (memo[i][j] != -1) {
                    maxPath = max(maxPath, memo[i][j]);
                    continue;
                }

                int found = 1 + max({
                    trav(matrix, memo, matrix[i][j], i + 1, j, n, m),
                    trav(matrix, memo, matrix[i][j], i - 1, j, n, m),
                    trav(matrix, memo, matrix[i][j], i, j + 1, n, m),
                    trav(matrix, memo, matrix[i][j], i, j - 1, n, m)
                });

                memo[i][j] = found;
                maxPath = max(maxPath, found);
            }
        }

        return maxPath;
    }
};
