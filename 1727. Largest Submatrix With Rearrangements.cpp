class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int ans = 0;
        int n = matrix.length, m = matrix[0].length;
        for(int i = 0; i < n; i++){
            int[] currRow = new int[m];
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1 && i > 0){
                    matrix[i][j] += matrix[i - 1][j];
                }
                currRow[j] = matrix[i][j];
            }
            Arrays.sort(currRow);
            for(int j = 0; j < m; j++) ans = Math.max(ans, currRow[j] * (m - j));
        }

        return ans;
    }
}