class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int ans = 0;
        for (int i = 0; i < (int)grid.size(); i++) {
            for (int j = 0; j < (int)grid[0].size(); j++) {
                if (grid[i][j] == 0) continue;
                int curr = 0;
                if (i + 1 >= (int)grid.size() || grid[i + 1][j] == 0) curr++;
                if (j + 1 >= (int)grid[0].size() || grid[i][j + 1] == 0) curr++;
                if (i - 1 < 0 || grid[i - 1][j] == 0) curr++;
                if (j - 1 < 0 || grid[i][j - 1] == 0) curr++;
                ans += curr;
            }
        }
        return ans;
    }
};