class Solution {
public:
    long long findSideSum(const vector<vector<int>>& grid, int len, int i, int j, int n, int m, int dirX, int dirY) {
        int currLen = 0;
        long long sum = 0;
        while(i < n && j < m && i >= 0 && j >= 0 && currLen <= len){
            sum += grid[i][j];
            i += dirX;
            j += dirY;
            currLen++;
        }
        return sum;
    }

    void checkAns(vector<int>& ans, long long Lsum) {
        int sum = static_cast<int>(Lsum);
        if(sum == ans[0] || sum == ans[1] || sum == ans[2]) return;

        if(sum > ans[0]){
            ans[2] = ans[1];
            ans[1] = ans[0];
            ans[0] = sum;
        }
        else if(sum > ans[1]){
            ans[2] = ans[1];
            ans[1] = sum;
        }
        else if(sum > ans[2]){
            ans[2] = sum;
        }
    }

    vector<int> getBiggestThree(vector<vector<int>>& grid) {
        vector<int> ans(3, -1);
        int n = grid.size();
        int m = grid[0].size();
        int maxLenPoss = min(n, m);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                checkAns(ans, grid[i][j]);
                for(int len = 1; len < maxLenPoss; len++){
                    if(i + len >= n || j + len + len >= m || i - len < 0) break;
                    int c1 = grid[i][j];
                    int c2 = grid[i - len][j + len];
                    int c3 = grid[i][j + len + len];
                    int c4 = grid[i + len][j + len];
                    long long sum = findSideSum(grid, len, i, j, n, m, -1, 1) 
                                  + findSideSum(grid, len, i - len, j + len, n, m, 1, 1) 
                                  + findSideSum(grid, len, i, j + len + len, n, m, 1, -1) 
                                  + findSideSum(grid, len, i + len, j + len, n, m, -1, -1);
                    sum -= (c1 + c2 + c3 + c4);
                    checkAns(ans, sum);
                }
            }
        }
        if(ans[1] == -1) return {ans[0]};
        else if(ans[2] == -1) return {ans[0], ans[1]};

        return ans;
    }
};