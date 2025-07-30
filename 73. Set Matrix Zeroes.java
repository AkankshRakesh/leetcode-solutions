class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean mainCol = false;
        boolean mainRow = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    if(j == 0) mainCol = true;
                    if(i == 0) mainRow = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int j = 0; j < m; j++){
            if(matrix[0][j] == 0){
                if(j == 0) continue;
                for(int i = 1; i < n; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(matrix[i][0] == 0){
                if(i == 0) continue;
                for(int j = 1; j < m; j++) matrix[i][j] = 0;
            }
        }
        if(mainCol){
            for(int i = 0; i < n; i++) matrix[i][0] = 0;
        }
        if(mainRow){
            for(int j = 0; j < m; j++) matrix[0][j] = 0;
        }
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}