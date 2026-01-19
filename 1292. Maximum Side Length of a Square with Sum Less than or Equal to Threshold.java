class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int[][] preSum = new int[mat.length][mat[0].length];
        preSum[0][0] = mat[0][0];
        for(int i = 1; i < mat.length; i++) preSum[i][0] = preSum[i - 1][0] + mat[i][0];
        for(int j = 1; j < mat[0].length; j++) preSum[0][j] = preSum[0][j - 1] + mat[0][j];
        for(int i = 1; i < mat.length; i++){
            for(int j = 1; j < mat[0].length; j++){
                preSum[i][j] = mat[i][j] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }
        // for(int i = 0; i < mat.length; i++){
        //     for(int j = 0; j < mat[0].length; j++){
        //         System.out.print(preSum[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int ans = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] <= threshold) ans = Math.max(ans, 1);
                // else break;

                for(int k = 1; k + i < mat.length && k + j < mat[0].length; k++){
                    int sum = preSum[k + i][k + j];
                    if(i != 0) sum -= preSum[i - 1][j + k];
                    if(j != 0) sum -= preSum[i + k][j - 1];
                    if(i != 0 && j != 0) sum += preSum[i - 1][j - 1];

                    if(sum <= threshold){
                        ans = Math.max(ans, k + 1); 
                        // System.out.println(i + "-" + j + "+" + k);
                    }
                    // else break;    
                }
            }
        }

        return ans;
    }
}