class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dist = new int[maze.length][maze[0].length];
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                if(maze[i][j] == '.') dist[i][j] = -1;
            }
        }
        dist[entrance[0]][entrance[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        while(!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.poll()[1];
            if(x + 1 < maze.length && maze[x + 1][y] != '+' && dist[x + 1][y] == -1){
                dist[x + 1][y] = dist[x][y] + 1;
                q.offer(new int[]{x + 1, y});
            }
            if(y + 1 < maze[0].length && maze[x][y + 1] != '+' && dist[x][y + 1] == -1){
                dist[x][y + 1] = dist[x][y] + 1;
                q.offer(new int[]{x, y + 1});
            }
            if(y - 1 >= 0 && maze[x][y - 1] != '+' && dist[x][y - 1] == -1){
                dist[x][y - 1] = dist[x][y] + 1;
                q.offer(new int[]{x, y - 1});
            }
            if(x - 1 >= 0 && maze[x - 1][y] != '+' && dist[x - 1][y] == -1){
                dist[x - 1][y] = dist[x][y] + 1;
                q.offer(new int[]{x - 1, y});
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                if(i == 0 || j == 0 || i == maze.length - 1 || j == maze[0].length - 1){
                    if(dist[i][j] != -1 && dist[i][j] != 0) ans = Math.min(ans, dist[i][j]);
                }
                // System.out.print(dist[i][j] + " ");
            }
            // System.out.println();
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}