class Solution {
public:
    int minimumOperations(vector<vector<int>>& grid) {
        int ans = 0;
        for(int i = 0; i < grid[0].size(); i++){
            int val = grid[0][i];
            for(int j = 1; j < grid.size(); j++){
                if(grid[j][i] <= val){
                    ans += (val - grid[j][i] + 1);
                    val = grid[j][i] + (val - grid[j][i] + 1);
                }
                else val = grid[j][i];
            }
        }
        return ans;
    }
};