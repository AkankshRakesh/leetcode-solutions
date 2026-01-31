class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) if(mat[i][j] == 1) dp[i][j] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});

                    int dist = 0;
                    while(!q.isEmpty()){
                        dist++;
                        int size = q.size();
                        while(size != 0){
                            int x = q.peek()[0];
                            int y = q.poll()[1];
                            if(x + 1 < n && dp[x + 1][y] > dist){
                                dp[x + 1][y] = dist;
                                q.offer(new int[]{x + 1, y});
                            }
                            if(x - 1 >= 0 && dp[x - 1][y] > dist){
                                dp[x - 1][y] = dist;
                                q.offer(new int[]{x - 1, y});
                            }
                            if(y - 1 >= 0 && dp[x][y - 1] > dist){
                                dp[x][y - 1] = dist;
                                q.offer(new int[]{x, y - 1});
                            }
                            if(y + 1 < m && dp[x][y + 1] > dist){
                                dp[x][y + 1] = dist;
                                q.offer(new int[]{x, y + 1});
                            }

                            size--;
                        }
                    }
                }
            }
        }

        return dp;
    }
}