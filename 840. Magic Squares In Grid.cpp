class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        int ans = 0;

        for (int i = 0; i <= (int)grid.size() - 3; i++) {
            for (int j = 0; j <= (int)grid[0].size() - 3; j++) {

                if (grid[i][j] > 9 || grid[i + 1][j] > 9 || grid[i + 2][j] > 9 ||
                    grid[i][j + 1] > 9 || grid[i + 1][j + 1] > 9 || grid[i + 2][j + 1] > 9 ||
                    grid[i][j + 2] > 9 || grid[i + 1][j + 2] > 9 || grid[i + 2][j + 2] > 9)
                    continue;

                int firstRow  = grid[i][j]     + grid[i][j + 1]     + grid[i][j + 2];
                int secondRow = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
                int thirdRow  = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                if (firstRow != secondRow || secondRow != thirdRow) continue;

                int firstCol  = grid[i][j]     + grid[i + 1][j]     + grid[i + 2][j];
                int secondCol = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
                int thirdCol  = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
                if (firstCol != secondCol || secondCol != thirdCol) continue;

                int firstDiag  = grid[i][j]     + grid[i + 1][j + 1] + grid[i + 2][j + 2];
                int secondDiag = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
                if (firstDiag != secondDiag) continue;

                if (firstCol != firstRow || firstCol != firstDiag || firstCol != firstRow)
                    continue;

                vector<int> allDig(11, 0);

                allDig[grid[i][j]]++;
                allDig[grid[i + 1][j]]++;
                allDig[grid[i + 2][j]]++;

                allDig[grid[i][j + 1]]++;
                allDig[grid[i + 1][j + 1]]++;
                allDig[grid[i + 2][j + 1]]++;

                allDig[grid[i][j + 2]]++;
                allDig[grid[i + 1][j + 2]]++;
                allDig[grid[i + 2][j + 2]]++;

                if (allDig[0] != 0) continue;

                bool flag = true;
                for (int k = 1; k <= 9; k++) {
                    if (allDig[k] != 1) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) continue;

                ans++;
            }
        }

        return ans;
    }
};
