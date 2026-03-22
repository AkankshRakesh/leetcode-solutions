class Solution {
    public boolean rotatedCheck(int[][] mat, int[][] target, boolean inc1, boolean inc2){
        boolean res = true;

        // System.out.println("---");
        int n = mat.length;
        if(inc1){
            for(int i = 0; i < n; i++){
                if(inc2){
                    for(int j = 0; j < n; j++){
                        if(mat[i][j] != target[i][j]){
                            res = false;
                            break;
                        }
                        // System.out.print(target[i][j] + " ");
                    }
                    // System.out.println();
                    if(!res) break;
                }
                else{
                    for(int j = n - 1; j >= 0; j--){
                        if(mat[j][i] != target[i][n - j - 1]){
                            res = false;
                            break;
                        }
                        // System.out.print(target[i][j] + " ");
                    }
                    // System.out.println();
                    if(!res) break;
                }
            }
            return res;
        }

        for(int i = n - 1; i >= 0; i--){
            if(inc2){
                for(int j = 0; j < n; j++){
                    if(mat[j][i] != target[n - i - 1][j]){
                        res = false;
                        break;
                    }
                    // System.out.print(target[n - i - 1][j] + " ");
                }
                // System.out.println();
                if(!res) break;
            }
            else{
                for(int j = n - 1; j >= 0; j--){
                    if(mat[i][j] != target[n - i - 1][n - j - 1]){
                        res = false;
                        break;
                    }
                    // System.out.print(target[n - i - 1][j] + " ");
                }
                // System.out.println();
                if(!res) break;
            }
        }
        
        return res;
    }
    public boolean findRotation(int[][] mat, int[][] target) {

        return rotatedCheck(mat, target, true, true) ||
            rotatedCheck(mat, target, true, false) ||
            rotatedCheck(mat, target, false, true) ||
            rotatedCheck(mat, target, false, false);
    }
}