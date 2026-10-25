class Solution {
    private static final int[] dirX = new int[]{0, 1, 0, -1};
    private static final int[] dirY = new int[]{1, 0, -1, 0};
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    // q = new LinkedList<>();
                    q.offer(new int[]{i, j});

                    boolean isIsland = true;
                    while(!q.isEmpty()){
                        int x = q.peek()[0];
                        int y = q.poll()[1];

                        for(int k = 0; k < 4; k++){
                            int nextX = dirX[k] + x;
                            int nextY = dirY[k] + y;

                            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m){
                                isIsland = false;
                                continue;
                            }
                            
                            if(grid[nextX][nextY] == 0 && !visited[nextX][nextY]) q.offer(new int[]{nextX, nextY});
                            visited[nextX][nextY] = true;
                        }                   
                    }

                    if(isIsland) ans++;
                }
            }
        }

        return ans;
    }
}