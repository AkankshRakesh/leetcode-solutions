class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        dungeon[n - 1][m - 1] = Math.max(1, 1 - dungeon[n - 1][m - 1]);
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(i == n - 1 && j == m - 1) continue;

                int bottom = i + 1 < n ? dungeon[i + 1][j] : Integer.MAX_VALUE;
                int right = j + 1 < m ? dungeon[i][j + 1] : Integer.MAX_VALUE;
                
                dungeon[i][j] = Math.min(bottom, right) - dungeon[i][j];
                dungeon[i][j] = Math.max(1, dungeon[i][j]);
                // System.out.print(dungeon[i][j] + " ");
            }
            // System.out.println();
        }

        return dungeon[0][0];
    }
}