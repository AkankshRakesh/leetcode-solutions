class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    int time = 0;
                    while(!q.isEmpty()){
                        int size = q.size();
                        time++;

                        while(size != 0){
                            int x = q.peek()[0];
                            int y = q.poll()[1];
                            if(x + 1 < n && grid[x + 1][y] != 0 && dp[x + 1][y] > time){
                                dp[x + 1][y] = time;
                                q.offer(new int[]{x + 1, y});
                            }
                            if(x - 1 >= 0 && grid[x - 1][y] != 0 && dp[x - 1][y] > time){
                                dp[x - 1][y] = time;
                                q.offer(new int[]{x - 1, y});
                            }
                            if(y + 1 < m && grid[x][y + 1] != 0 && dp[x][y + 1] > time){
                                dp[x][y + 1] = time;
                                q.offer(new int[]{x, y + 1});
                            }
                            if(y - 1 >= 0 && grid[x][y - 1] != 0 && dp[x][y - 1] > time){
                                dp[x][y - 1] = time;
                                q.offer(new int[]{x, y - 1});
                            }

                            size--;
                        }
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0) ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}