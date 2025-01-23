class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
        vector<int> rowSum(grid.size(), 0);
        vector<int> colSum(grid[0].size(), 0);
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == 1) {
                    rowSum[i]++;
                    colSum[j]++;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid[0].size(); j++){
                if(grid[i][j] == 1 && (colSum[j] > 1 || rowSum[i] > 1)) ans++; 
            }
        }
        return ans;
    }
};