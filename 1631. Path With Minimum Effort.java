class Solution {
    public boolean dfs(int[][] heights, int i, int j, int past, int k, boolean[][] visited){
        if(i >= heights.length || j >= heights[0].length || i < 0 || j < 0 || visited[i][j] || Math.abs(past - heights[i][j]) > k) return false;
        if(i == heights.length - 1 && j == heights[0].length - 1) return true;

        visited[i][j] = true;
        boolean res = dfs(heights, i + 1, j, heights[i][j], k, visited) ||
               dfs(heights, i - 1, j, heights[i][j], k, visited) ||
               dfs(heights, i, j + 1, heights[i][j], k, visited) ||
               dfs(heights, i, j - 1, heights[i][j], k, visited);

        return res;
    }
    public int minimumEffortPath(int[][] heights) {
        int left = 0, right = 0;
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                right = Math.max(right, heights[i][j]);
            }
        }
        int ans = Integer.MAX_VALUE;
        while(left < right){
            boolean[][] visited = new boolean[heights.length][heights[0].length];
            int mid = left + (right - left) / 2;
            // System.out.println(mid);
            if(dfs(heights, 0, 0, heights[0][0], mid, visited)){
                ans = mid;
                right = mid;
            }
            else left = mid + 1;
        }

        return ans;
    }
}