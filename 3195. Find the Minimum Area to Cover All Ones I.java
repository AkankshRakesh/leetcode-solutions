class Solution {
    public int minimumArea(int[][] grid) {
        int minI = -1;
        int maxI = -1;
        int minJ = -1;
        int maxJ = -1;

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    if(minI == -1 || minI > i) minI = i;
                    if(minJ == -1 || minJ > j) minJ = j;

                    // if(minI != -1 && minJ != -1) break;
                }
            }
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(grid[i][j] == 1){
                    if(maxJ == -1 || maxJ < j) maxJ = j;
                    if(maxI == -1 || maxI < i) maxI = i; 
                }

                // if(maxI != -1 && maxJ != -1) break;
            }
        }


        return (maxI - minI + 1) * (maxJ - minJ + 1);
    }
}