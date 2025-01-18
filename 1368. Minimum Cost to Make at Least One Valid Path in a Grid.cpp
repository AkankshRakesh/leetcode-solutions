class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        int numRows = grid.size(), numCols = grid[0].size();
        vector<vector<int>> minChanges(numRows, vector<int>(numCols, INT_MAX));

        minChanges[0][0] = 0;

        while (true) {
            vector<vector<int>> prevState = minChanges;

            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    if (row > 0) {
                        minChanges[row][col] =
                            min(minChanges[row][col],
                                minChanges[row - 1][col] +
                                    (grid[row - 1][col] == 3 ? 0 : 1));
                    }
                    if (col > 0) {
                        minChanges[row][col] =
                            min(minChanges[row][col],
                                minChanges[row][col - 1] +
                                    (grid[row][col - 1] == 1 ? 0 : 1));
                    }
                }
            }

            for (int row = numRows - 1; row >= 0; row--) {
                for (int col = numCols - 1; col >= 0; col--) {
                    if (row < numRows - 1) {
                        minChanges[row][col] =
                            min(minChanges[row][col],
                                minChanges[row + 1][col] +
                                    (grid[row + 1][col] == 4 ? 0 : 1));
                    }
                    if (col < numCols - 1) {
                        minChanges[row][col] =
                            min(minChanges[row][col],
                                minChanges[row][col + 1] +
                                    (grid[row][col + 1] == 2 ? 0 : 1));
                    }
                }
            }

            if (prevState == minChanges) {
                break;
            }
        }

        return minChanges[numRows - 1][numCols - 1];
    }
};