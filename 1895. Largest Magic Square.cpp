class Solution {
public:
    bool checkAll(vector<vector<int>>& grid, int x, int y, int z, int sum) {
        for (int j = y; j <= y + z; j++) {
            int currSum = 0;
            for (int i = x; i <= x + z; i++)
                currSum += grid[i][j];
            if (currSum != sum) return false;
        }

        for (int i = x; i <= x + z; i++) {
            int currSum = 0;
            for (int j = y; j <= y + z; j++)
                currSum += grid[i][j];
            if (currSum != sum) return false;
        }

        int diag1 = 0;
        for (int i = 0; i <= z; i++) {
            diag1 += grid[x + i][y + i];
        }
        if (diag1 != sum) return false;

        int diag2 = 0;
        for (int i = 0; i <= z; i++) {
            diag2 += grid[x + i][y + z - i];
        }
        if (diag2 != sum) return false;

        return true;
    }

    int largestMagicSquare(vector<vector<int>>& grid) {
        int ans = 1;

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                int diag = grid[i][j];
                int firstRow = grid[i][j];

                for (int k = 1; i + k < grid.size() && j + k < grid[0].size(); k++) {
                    diag += grid[i + k][j + k];
                    firstRow += grid[i][j + k];

                    if (diag == firstRow) {
                        if (checkAll(grid, i, j, k, diag))
                            ans = max(ans, k + 1);
                    }
                }
            }
        }

        return ans;
    }
};
