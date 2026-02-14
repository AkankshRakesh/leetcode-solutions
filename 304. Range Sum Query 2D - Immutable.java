class NumMatrix {
    long[][] prefMatrix;
    public NumMatrix(int[][] matrix) {
        prefMatrix = new long[matrix.length + 1][matrix[0].length + 1];

        for(int i = 1; i <= matrix.length; i++){
            for(int j = 1; j <= matrix[0].length; j++){
                prefMatrix[i][j] = prefMatrix[i - 1][j] + prefMatrix[i][j - 1] - prefMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];        
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        long top = prefMatrix[row1 - 1][col2];
        long diag = prefMatrix[row1 - 1][col1 - 1];
        long left = prefMatrix[row2][col1 - 1];
        return (int)(prefMatrix[row2][col2] - top - left + diag);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */