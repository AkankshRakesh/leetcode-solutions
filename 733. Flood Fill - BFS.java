class Solution {
    public void dfs(int[][] image, int i, int j, int pixel, int color){
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != pixel) return;

        image[i][j] = color;
        dfs(image, i + 1, j, pixel, color);
        dfs(image, i - 1, j, pixel, color);
        dfs(image, i, j + 1, pixel, color);
        dfs(image, i, j - 1, pixel, color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }
}