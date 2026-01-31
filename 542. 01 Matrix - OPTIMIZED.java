class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dp = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){ 
                if(mat[i][j] == 0) q.offer(new int[]{i, j});
                // else dp[i][j] = 1;
            }
        }

        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            time++;

            while(size != 0){
                int x = q.peek()[0];
                int y = q.poll()[1];
                
                if(x + 1 < n && mat[x + 1][y] == 1){
                    mat[x + 1][y] = 0;
                    dp[x + 1][y] = time;
                    q.offer(new int[]{x + 1, y});
                }
                if(y + 1 < m && mat[x][y + 1] == 1){
                    mat[x][y + 1] = 0;
                    dp[x][y + 1] = time;
                    q.offer(new int[]{x, y + 1});
                }
                if(x - 1 >= 0 && mat[x - 1][y] == 1){
                    mat[x - 1][y] = 0;
                    dp[x - 1][y] = time;
                    q.offer(new int[]{x - 1, y});
                }
                if(y - 1 >= 0 && mat[x][y - 1] == 1){
                    mat[x][y - 1] = 0;
                    dp[x][y - 1] = time;
                    q.offer(new int[]{x, y - 1});
                }

                size--;
            }
        }
        
        return dp;
    }
}