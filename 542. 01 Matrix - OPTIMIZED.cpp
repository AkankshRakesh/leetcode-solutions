class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int n = mat.size(), m = mat[0].size();
        vector<vector<int>> dp(n, vector<int>(m, 0));
        queue<pair<int,int>> q;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){ 
                if(mat[i][j] == 0) q.push({i, j});
                // else dp[i][j] = 1;
            }
        }

        int time = 0;
        while(!q.empty()){
            int size = q.size();
            time++;

            while(size != 0){
                int x = q.front().first;
                int y = q.front().second;
                q.pop();
                
                if(x + 1 < n && mat[x + 1][y] == 1){
                    mat[x + 1][y] = 0;
                    dp[x + 1][y] = time;
                    q.push({x + 1, y});
                }
                if(y + 1 < m && mat[x][y + 1] == 1){
                    mat[x][y + 1] = 0;
                    dp[x][y + 1] = time;
                    q.push({x, y + 1});
                }
                if(x - 1 >= 0 && mat[x - 1][y] == 1){
                    mat[x - 1][y] = 0;
                    dp[x - 1][y] = time;
                    q.push({x - 1, y});
                }
                if(y - 1 >= 0 && mat[x][y - 1] == 1){
                    mat[x][y - 1] = 0;
                    dp[x][y - 1] = time;
                    q.push({x, y - 1});
                }

                size--;
            }
        }
        
        return dp;
    }
};