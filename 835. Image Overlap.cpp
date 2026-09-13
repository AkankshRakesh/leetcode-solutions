class Solution {
public:
    int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
        vector<vector<int>> ones1;
        vector<vector<int>> ones2;
        int n = img1.size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) ones1.push_back({i, j});
                if (img2[i][j] == 1) ones2.push_back({i, j});
            }
        }

        vector<vector<int>> count(2 * n - 1, vector<int>(2 * n - 1));

        int ans = 0;

        for (vector<int>& a : ones1) {
            for (vector<int>& b : ones2) {
                int dx = a[0] - b[0] + n - 1;
                int dy = a[1] - b[1] + n - 1;

                count[dx][dy]++;
                ans = max(ans, count[dx][dy]);
            }
        }

        return ans;
    }
};