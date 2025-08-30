class Solution {
    class Pair{
        Integer value;
        int[] index;
        public Pair(Integer value, int[] index){
            this.value = value;
            this.index = index;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) for(int j = 0; j < m; j++) dp[i][j] = Integer.MAX_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        pq.offer(new Pair(grid[0][0], new int[]{0, 0}));
        int curr = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int i = top.index[0];
            int j = top.index[1];
            if(top.value > dp[i][j]) continue;
            
            dp[i][j] = curr;
            if(i + 1 < n && dp[i + 1][j] > curr) pq.offer(new Pair(grid[i + 1][j], new int[]{i + 1, j}));
            if(j + 1 < m && dp[i][j + 1] > curr) pq.offer(new Pair(grid[i][j + 1], new int[]{i, j + 1}));
            if(i - 1 >= 0 && dp[i - 1][j] > curr) pq.offer(new Pair(grid[i - 1][j], new int[]{i - 1, j}));
            if(j - 1 >= 0 && dp[i][j - 1] > curr) pq.offer(new Pair(grid[i][j - 1], new int[]{i, j - 1}));
            System.out.println(top.value);
            curr = Math.max(curr, top.value);
            if(i + 1 >= n && j + 1 >= m) ans = Math.min(ans, curr);
        }

        return ans;
    }
}