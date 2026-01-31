class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1) return -1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int len = 0;
        while(!q.isEmpty()){
            len++;
            int size = q.size();
            while(size != 0){
                int i = q.peek()[0];
                int j = q.poll()[1];
                if(i == n - 1 && j == n - 1) return len;

                if(i + 1 < n && grid[i + 1][j] == 0){
                    grid[i + 1][j] = 1;
                    q.offer(new int[]{i + 1, j});
                }
                if(j + 1 < n && grid[i][j + 1] == 0){
                    grid[i][j + 1] = 1;
                    q.offer(new int[]{i, j + 1});
                }
                if(i - 1 >= 0 && grid[i - 1][j] == 0){
                    grid[i - 1][j] = 1;
                    q.offer(new int[]{i - 1, j});
                }
                if(j - 1 >= 0 && grid[i][j - 1] == 0){
                    grid[i][j - 1] = 1;
                    q.offer(new int[]{i, j - 1});
                }
                if(i + 1 < n && j + 1 < n && grid[i + 1][j + 1] == 0){
                    grid[i + 1][j + 1] = 1;
                    q.offer(new int[]{i + 1, j + 1});
                }
                if(i + 1 < n && j - 1 >= 0 && grid[i + 1][j - 1] == 0){
                    grid[i + 1][j - 1] = 1;
                    q.offer(new int[]{i + 1, j - 1});
                }
                if(i - 1 >= 0 && j + 1 < n && grid[i - 1][j + 1] == 0){
                    grid[i - 1][j + 1] = 1;
                    q.offer(new int[]{i - 1, j + 1});
                }
                if(i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 0){
                    grid[i - 1][j - 1] = 1;
                    q.offer(new int[]{i - 1, j - 1});
                }
                size--; 
            }
        }
        return -1;
    }
}