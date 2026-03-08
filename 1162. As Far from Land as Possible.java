class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) q.offer(new int[]{i, j, i, j});
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int x = q.peek()[0];
                int y = q.peek()[1];
                int landX = q.peek()[2];
                int landY = q.poll()[3];
                
                int right = Math.abs(landX - (x + 1)) + Math.abs(landY - y);
                int left = Math.abs(landX - (x - 1)) + Math.abs(landY - y);
                int top = Math.abs(landX - x) + Math.abs(landY - (y - 1));
                int bottom = Math.abs(landX - x) + Math.abs(landY - (y + 1));

                if(x + 1 < n && grid[x + 1][y] != 1 && (dp[x + 1][y] == -1 || dp[x + 1][y] > right)){
                    dp[x + 1][y] = right;
                    q.offer(new int[]{x + 1, y, landX, landY});
                }
                if(x - 1 >= 0 && grid[x - 1][y] != 1 && (dp[x - 1][y] == -1 || dp[x - 1][y] > left)){
                    dp[x - 1][y] = left;
                    q.offer(new int[]{x - 1, y, landX, landY});
                }

                if(y + 1 < n && grid[x][y + 1] != 1 && (dp[x][y + 1] == -1 || dp[x][y + 1] > bottom)){
                    dp[x][y + 1] = bottom;
                    q.offer(new int[]{x, y + 1, landX, landY});
                }
                if(y - 1 >= 0 && grid[x][y - 1] != 1 && (dp[x][y - 1] == -1 || dp[x][y - 1] > top)){
                    dp[x][y - 1] = top;
                    q.offer(new int[]{x, y - 1, landX, landY});
                }
            }
        }

        int ans = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 1 && dp[i][j] > ans) ans = dp[i][j];
            }
        }

        return ans;
    }
}