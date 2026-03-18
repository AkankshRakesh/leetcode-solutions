class Solution {
public:
    int countSubmatrices(vector<vector<int>>& grid, int k) {
        int ans = 0;
        int rows = grid.size();
        int cols = grid[0].size();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int left = (j - 1 >= 0) ? grid[i][j - 1] : 0;
                int top = (i - 1 >= 0) ? grid[i - 1][j] : 0;
                int diag = (i - 1 >= 0 && j - 1 >= 0) ? grid[i - 1][j - 1] : 0;

                grid[i][j] += (top + left - diag);
                if(grid[i][j] <= k) ans++;
            }
        }
        return ans;
    }
};

