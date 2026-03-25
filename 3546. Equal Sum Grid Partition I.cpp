class Solution {
public:
    bool colWiseSum(const vector<vector<int>>& grid, long target) {
        for (size_t j = 0; j < grid[0].size(); j++) {
            long sum = 0;
            for (size_t i = 0; i < grid.size(); i++) sum += grid[i][j];
            if (sum == target) return true;
        }
        return false;
    }

    bool rowWiseSum(const vector<vector<int>>& grid, long target) {
        for (const auto& row : grid) {
            long sum = 0;
            for (int col : row) sum += col;
            if (sum == target) return true;
        }
        return false;
    }

    bool canPartitionGrid(const vector<vector<int>>& grid) {
        long sum = 0;
        for (const auto& row : grid) {
            for (int col : row) sum += col;
        }
        if (sum % 2 != 0) return false;

        long target = sum / 2;
        return rowWiseSum(grid, target) || colWiseSum(grid, target);
    }
};