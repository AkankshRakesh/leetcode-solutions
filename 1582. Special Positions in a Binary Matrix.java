class Solution {
    public int numSpecial(int[][] mat) {
        boolean[] validRow = new boolean[mat.length];
        boolean[] validCol = new boolean[mat[0].length];

        for(int i = 0; i < mat.length; i++){
            int sum = 0;
            for(int j = 0; j < mat[0].length; j++){
                sum += mat[i][j];
            }
            if(sum == 1) validRow[i] = true;
        }
        for(int j = 0; j < mat[0].length; j++){
            int sum = 0;
            for(int i = 0; i < mat.length; i++){
                sum += mat[i][j];
            }
            if(sum == 1) validCol[j] = true;
        }

        int ans = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1 && validRow[i] && validCol[j]) ans++;
            }
        }

        return ans;
    }
}