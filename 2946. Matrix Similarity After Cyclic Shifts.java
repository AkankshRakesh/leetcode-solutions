class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i % 2 == 0){
                    int rotationInd = (j + k) % m;
                    if(mat[i][j] != mat[i][rotationInd]) return false;
                }
                else{
                    int rotationInd = (j - k % m + m) % m;
                    if(mat[i][j] != mat[i][rotationInd]) return false;
                }
            }
        }

        return true;
    }
}