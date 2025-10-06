class Solution {
    class Pair{
        int i;
        int j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(grid[a.i][a.j], grid[b.i][b.j]));
        int n = grid.length;
        int ans = 0;
        pq.offer(new Pair(0, 0));
        boolean[][] visited = new boolean[n][n];
        
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int i = top.i;
            int j = top.j;
            visited[i][j] = true;
            ans = Math.max(ans, grid[i][j]);

            if(i - 1 >= 0 && !visited[i - 1][j]) pq.offer(new Pair(i - 1, j));   
            if(i + 1 < n && !visited[i + 1][j]) pq.offer(new Pair(i + 1, j));   
            if(j - 1 >= 0 && !visited[i][j - 1]) pq.offer(new Pair(i, j - 1));   
            if(j + 1 < n && !visited[i][j + 1]) pq.offer(new Pair(i, j + 1));   
            
            if(i == n - 1 && j == n - 1) break;
        }

        return ans;
    }
}