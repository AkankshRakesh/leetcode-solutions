class Solution {
    int n, m;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);   
            dfs(heights, atlantic, i, m - 1, Integer.MIN_VALUE); 
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);     
            dfs(heights, atlantic, n - 1, j, Integer.MIN_VALUE); 
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j, int prevHeight) {
        if (i < 0 || j < 0 || i >= n || j >= m) return;
        if (visited[i][j] || heights[i][j] < prevHeight) return;

        visited[i][j] = true;
        for (int[] d : dirs) {
            dfs(heights, visited, i + d[0], j + d[1], heights[i][j]);
        }
    }
}
