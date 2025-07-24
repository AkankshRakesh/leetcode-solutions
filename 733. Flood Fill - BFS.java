class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        int[][] newImage = new int[n][m];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                newImage[i][j] = image[i][j];
            }
        }
        int startPix = image[sr][sc];
        newImage[sr][sc] = color;

        while(!q.isEmpty()){
            int[] cords = q.poll();
            int row = cords[0];
            int col = cords[1];

            for(int[] dir : dirs){
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && image[nRow][nCol] == startPix && !visited[nRow][nCol]){
                    q.offer(new int[]{nRow, nCol});
                    visited[nRow][nCol] = true;
                    newImage[nRow][nCol] = color;
                }
            }
        }
        
        return newImage;
    }
}