class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        List<Integer> ans = new ArrayList<>();

        int r = 0, c = 0;
        int ind = 0;
        for(int i = 0; i < n * m; i++){
            ans.add(matrix[r][c]);
            visited[r][c] = true;

            if(r + dr[ind] >= n || c + dc[ind] >= m || r + dr[ind] < 0 || c + dc[ind] < 0 || visited[r + dr[ind]][c + dc[ind]]){
                ind = (ind + 1) % 4;
                r += dr[ind];
                c += dc[ind];
            }
            else{
                r += dr[ind];
                c += dc[ind];
            }
        }

        return ans;
    }
}