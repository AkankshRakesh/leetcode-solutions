class Solution {
    public void dfs(int[][] image,int[][] newImage, int i, int j, int n, int m, boolean[][] visited, int startPix, int color){
        if(i >= n || j >= m || i < 0 || j < 0 || visited[i][j] || image[i][j] != startPix) return;

        newImage[i][j] = color;
        visited[i][j] = true;
        dfs(image, newImage, i + 1, j, n, m, visited, startPix, color);
        dfs(image, newImage, i - 1, j, n, m, visited, startPix, color);
        dfs(image, newImage, i, j + 1, n, m, visited, startPix, color);
        dfs(image, newImage, i, j - 1, n, m, visited, startPix, color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] newImage = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                newImage[i][j] = image[i][j];
            }
        }
        int startPix = image[sr][sc];
        newImage[sr][sc] = color;

        dfs(image, newImage, sr, sc, n, m,visited, startPix, color);

        return newImage;
    }
}