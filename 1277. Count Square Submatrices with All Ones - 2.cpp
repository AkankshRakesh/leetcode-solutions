class Solution {
public:
    int countSquares(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<int>> count(n, vector<int>(m, 0));
        int ans = 0;

        for (int i = 0; i < n; i++) {
            count[i][0] = matrix[i][0];
            if (matrix[i][0] == 1) ans++;
        }
        for (int j = 1; j < m; j++) {
            count[0][j] = matrix[0][j];
            if (matrix[0][j] == 1) ans++;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) continue;
                int a = count[i - 1][j];
                int b = count[i][j - 1];
                int c = count[i - 1][j - 1];

                if (a == b && b == c) count[i][j] = a + 1;
                else if (a == 0 || b == 0 || c == 0) count[i][j] = 1;
                else count[i][j] = min({a, b, c}) + 1;

                ans += count[i][j];
            }
        }

        return ans;
    }
};
