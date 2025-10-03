class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;

        int n = heightMap.length, m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][m - 1], i, m - 1});
            visited[i][0] = true;
            visited[i][m - 1] = true;
        }
        for (int j = 1; j < m - 1; j++) {
            pq.offer(new int[]{heightMap[0][j], 0, j});
            pq.offer(new int[]{heightMap[n - 1][j], n - 1, j});
            visited[0][j] = true;
            visited[n - 1][j] = true;
        }

        int water = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int maxHeight = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int h = cur[0], x = cur[1], y = cur[2];
            maxHeight = Math.max(maxHeight, h);

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;
                visited[nx][ny] = true;

                if (heightMap[nx][ny] < maxHeight) {
                    water += maxHeight - heightMap[nx][ny];
                }

                pq.offer(new int[]{heightMap[nx][ny], nx, ny});
            }
        }

        return water;
    }
}
