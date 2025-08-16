class Solution {
    public void dfs(int n, int m, int i, int j, boolean[][] covered, int k, int[] count){
        if(i >= n || j >= m || i < 0 || j < 0) return;

        if(covered[i][j] == false){
            count[0]++;
            for (int x = i; x <= Math.min(n - 1, i + k); x++) {
                for (int y = j; y <= Math.min(m - 1, j + k); y++) {
                    covered[x][y] = true;
                }
            }

            dfs(n, m, i + 1, j, covered, k, count);
            dfs(n, m, i, j + 1, covered, k, count);
        }
    }
    public int minSensors(int n, int m, int k) {
        int dist = 2 * k + 1;
        int rows = (n + dist - 1) / dist;
        int cols = (m + dist - 1)/ dist;
        return rows * cols;
    }
}