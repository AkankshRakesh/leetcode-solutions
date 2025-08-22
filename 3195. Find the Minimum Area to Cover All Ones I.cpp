class Solution {
public:
    int minimumArea(vector<vector<int>>& grid) {
        int minI = -1;
        int maxI = -1;
        int minJ = -1;
        int maxJ = -1;

        int n = grid.size();
        int m = grid[0].size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (minI == -1 || minI > i) minI = i;
                    if (minJ == -1 || minJ > j) minJ = j;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    if (maxJ == -1 || maxJ < j) maxJ = j;
                    if (maxI == -1 || maxI < i) maxI = i;
                }
            }
        }

        return (maxI - minI + 1) * (maxJ - minJ + 1);
    }
};
