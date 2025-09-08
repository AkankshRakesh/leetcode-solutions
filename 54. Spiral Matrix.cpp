class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        int dr[4] = {0, 1, 0, -1};
        int dc[4] = {1, 0, -1, 0};
        vector<int> ans;

        int r = 0, c = 0;
        int ind = 0;
        for (int i = 0; i < n * m; i++) {
            ans.push_back(matrix[r][c]);
            visited[r][c] = true;

            if (r + dr[ind] >= n || c + dc[ind] >= m || 
                r + dr[ind] < 0 || c + dc[ind] < 0 || 
                visited[r + dr[ind]][c + dc[ind]]) {
                ind = (ind + 1) % 4;
                r += dr[ind];
                c += dc[ind];
            } else {
                r += dr[ind];
                c += dc[ind];
            }
        }

        return ans;
    }
};
