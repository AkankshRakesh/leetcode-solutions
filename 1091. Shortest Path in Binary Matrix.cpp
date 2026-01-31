class Solution {
public:
    int shortestPathBinaryMatrix(std::vector<std::vector<int>>& grid) {
        int n = grid.size();
        if(grid[0][0] == 1) return -1;

        std::queue<std::pair<int, int>> q;
        q.emplace(0, 0);
        int len = 0;
        while(!q.empty()){
            len++;
            int size = q.size();
            while(size != 0){
                int i = q.front().first;
                int j = q.front().second;
                q.pop();
                if(i == n - 1 && j == n - 1) return len;

                if(i + 1 < n && grid[i + 1][j] == 0){
                    grid[i + 1][j] = 1;
                    q.emplace(i + 1, j);
                }
                if(j + 1 < n && grid[i][j + 1] == 0){
                    grid[i][j + 1] = 1;
                    q.emplace(i, j + 1);
                }
                if(i - 1 >= 0 && grid[i - 1][j] == 0){
                    grid[i - 1][j] = 1;
                    q.emplace(i - 1, j);
                }
                if(j - 1 >= 0 && grid[i][j - 1] == 0){
                    grid[i][j - 1] = 1;
                    q.emplace(i, j - 1);
                }
                if(i + 1 < n && j + 1 < n && grid[i + 1][j + 1] == 0){
                    grid[i + 1][j + 1] = 1;
                    q.emplace(i + 1, j + 1);
                }
                if(i + 1 < n && j - 1 >= 0 && grid[i + 1][j - 1] == 0){
                    grid[i + 1][j - 1] = 1;
                    q.emplace(i + 1, j - 1);
                }
                if(i - 1 >= 0 && j + 1 < n && grid[i - 1][j + 1] == 0){
                    grid[i - 1][j + 1] = 1;
                    q.emplace(i - 1, j + 1);
                }
                if(i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 0){
                    grid[i - 1][j - 1] = 1;
                    q.emplace(i - 1, j - 1);
                }
                size--; 
            }
        }
        return -1;
    }
};