class NumMatrix {
    vector<vector<long long>> prefMatrix;
public:
    NumMatrix(const vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        prefMatrix.assign(m + 1, vector<long long>(n + 1, 0));

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefMatrix[i][j] = prefMatrix[i - 1][j] + prefMatrix[i][j - 1] - prefMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        long long top = prefMatrix[row1 - 1][col2];
        long long diag = prefMatrix[row1 - 1][col1 - 1];
        long long left = prefMatrix[row2][col1 - 1];
        return static_cast<int>(prefMatrix[row2][col2] - top - left + diag);
    }
};