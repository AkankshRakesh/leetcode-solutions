class Solution {
    public long findSideSum(int[][] grid, int len, int i, int j, int n, int m, int dirX, int dirY){
        int currLen = 0;
        int sum = 0;
        while(i < n && j < m && i >= 0 && j >= 0 && currLen <= len){
            sum += grid[i][j];
            i += dirX;
            j += dirY;
            currLen++;
        }
        return sum;
    }
    public void checkAns(int[] ans, long Lsum){
        int sum = (int)Lsum;
        if(sum == ans[0] || sum == ans[1] || sum == ans[2]) return;

        if(sum > ans[0]){
            ans[2] = ans[1];
            ans[1] = ans[0];
            ans[0] = sum;
        }
        else if(sum > ans[1]){
            ans[2] = ans[1];
            ans[1] = sum;
        }
        else if(sum > ans[2]){
            ans[2] = sum;
        }
    }

    public int[] getBiggestThree(int[][] grid) {
        int[] ans = new int[3];
        Arrays.fill(ans, -1);
        int n = grid.length;
        int m = grid[0].length;
        int maxLenPoss = Math.min(n, m);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                checkAns(ans, grid[i][j]);
                for(int len = 1; len < maxLenPoss; len++){
                    if(i + len >= n || j + len + len >= m || i - len < 0) break;
                    int c1 = grid[i][j];
                    int c2 = grid[i - len][j + len];
                    int c3 = grid[i][j + len + len];
                    int c4 = grid[i + len][j + len];
                    // System.out.println(c1 + " " + c2 + " " + c3  + " " + c4 + " " + findSideSum(grid, len, i, j, n, m, -1, 1));
                    long sum = findSideSum(grid, len, i, j, n, m, -1, 1) + findSideSum(grid, len, i - len, j + len, n, m, 1, 1) + findSideSum(grid, len, i, j + len + len, n, m, 1, -1) + findSideSum(grid, len, i + len, j + len, n, m, -1, -1);
                    sum -= (c1 + c2 + c3 + c4);
                    checkAns(ans, sum);
                }
            }
        }
        if(ans[1] == -1) return new int[]{ans[0]};
        else if(ans[2] == -1) return new int[]{ans[0], ans[1]};
        
        return ans;
    }
}