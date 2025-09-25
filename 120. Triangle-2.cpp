class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        for (int i = n - 2; i >= 0; i--) {
            int m = triangle[i].size();
            for (int j = 0; j < m; j++) {
                int left = triangle[i + 1][j];
                int right = triangle[i + 1][j + 1];
                int curr = triangle[i][j];
                triangle[i][j] = min(curr + left, curr + right);
            }
        }
        return triangle[0][0];
    }
};
