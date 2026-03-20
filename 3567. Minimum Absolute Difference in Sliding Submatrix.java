class Solution {
    public int findMinAbsDiff(int[][] grid, int x, int y, int n, int m){
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = x; i < n; i++){
            for(int j = y; j < m; j++){
                nums.add(grid[i][j]);
            }
        }
        Collections.sort(nums);

        long ans = Integer.MAX_VALUE;
        for(int i = 1; i < nums.size(); i++){
            if((long)nums.get(i) == nums.get(i - 1)) continue;
            ans = Math.min(ans, (long)nums.get(i) - nums.get(i - 1));
        }

        return (int)(ans == Integer.MAX_VALUE ? 0 : ans);
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n - k + 1][m - k + 1];

        for(int i = 0; i < n - k + 1; i++){
            for(int j = 0; j < m - k + 1; j++){
                ans[i][j] = findMinAbsDiff(grid, i, j, i + k, j + k);
            }
        }

        return ans;
    }
}