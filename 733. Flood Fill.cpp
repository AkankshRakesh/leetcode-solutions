class Solution {
public:
    void dfs(vector<vector<int>>& image, vector<vector<int>>& newImage, int i, int j, int n, int m, vector<vector<bool>>& visited, int startPix, int color) {
        if (i >= n || j >= m || i < 0 || j < 0 || visited[i][j] || image[i][j] != startPix) return;

        newImage[i][j] = color;
        visited[i][j] = true;
        
        dfs(image, newImage, i + 1, j, n, m, visited, startPix, color);
        dfs(image, newImage, i - 1, j, n, m, visited, startPix, color);
        dfs(image, newImage, i, j + 1, n, m, visited, startPix, color);
        dfs(image, newImage, i, j - 1, n, m, visited, startPix, color);
    }

    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int n = image.size();
        int m = image[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        vector<vector<int>> newImage = image;

        int startPix = image[sr][sc];
        dfs(image, newImage, sr, sc, n, m, visited, startPix, color);

        return newImage;
    }
};
