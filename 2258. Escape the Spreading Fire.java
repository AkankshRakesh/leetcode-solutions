class Solution {
    public boolean canCross(int[][] grid, int[][] fireTime, int allowed, boolean[][] visited){
        int n = fireTime.length, m = fireTime[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        if(fireTime[0][0] != -1 && fireTime[0][0] <= allowed) return false;
        visited[0][0] = true;

        int time = allowed;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int x = q.peek()[0];
                int y = q.poll()[1];
                if(x == n - 1 && y == m - 1) return true;

                for(int[] d : dir){
                    int nx = x + d[0], ny = y + d[1];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if(grid[nx][ny] == 2 || visited[nx][ny]) continue;

                    int arrival = time + 1;

                    if(nx == n - 1 && ny == m - 1){
                        if(fireTime[nx][ny] != -1 && fireTime[nx][ny] < arrival) continue;
                    } else {
                        if(fireTime[nx][ny] != -1 && fireTime[nx][ny] <= arrival) continue;
                    }

                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
            time++;
        }

        return false;
    }
    public int maximumMinutes(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> fireQ = new LinkedList<>();

        int[][] fireTime = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(fireTime[i], -1);
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) fireQ.offer(new int[]{i, j});
            }
        }

        int time = 0;
        while(!fireQ.isEmpty()){
            int size = fireQ.size();
            for(int i = 0; i < size; i++){
                int x = fireQ.peek()[0];
                int y = fireQ.poll()[1];
                fireTime[x][y] = time; 
                if(x + 1 < n && grid[x + 1][y] == 0 && fireTime[x + 1][y] == -1) fireQ.offer(new int[]{x + 1, y});
                if(y + 1 < m && grid[x][y + 1] == 0 && fireTime[x][y + 1] == -1) fireQ.offer(new int[]{x, y + 1});
                if(x - 1 >= 0 && grid[x - 1][y] == 0 && fireTime[x - 1][y] == -1) fireQ.offer(new int[]{x - 1, y});
                if(y - 1 >= 0 && grid[x][y - 1] == 0 && fireTime[x][y - 1] == -1) fireQ.offer(new int[]{x, y - 1});
            }
            time++;
        }

        int left = 0, right = 1_000_000_000, ans = -1;
        while(left <= right){
            boolean[][] visited = new boolean[n][m];
            int mid = left + (right - left) / 2;
            if(canCross(grid, fireTime, mid, visited)){
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return ans;
    }
}