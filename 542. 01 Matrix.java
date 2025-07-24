class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }

        int[][] dir = {{-1, 0},{1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            int[] cords = q.poll();
            int row = cords[0];
            int col = cords[1];


            for(int[] curr : dir){
                int nRow = row + curr[0];
                int nCol = col + curr[1];

                if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && !visited[nRow][nCol]){
                    dist[nRow][nCol] = 1 + dist[row][col];
                    q.offer(new int[]{nRow, nCol});
                    visited[nRow][nCol] = true;
                }
            }
        }
        return dist;
    }
}