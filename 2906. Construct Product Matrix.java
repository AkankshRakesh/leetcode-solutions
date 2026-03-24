class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length * grid[0].length;
        int[] nums = new int[n];
        int[] ans = new int[n];
        int index = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                nums[index++] = grid[i][j];
            }
        }

        long past = nums[0] % 12345;
        ans[0] = 1;
        for(int i = 1; i < n; i++){
            ans[i] = (int)past;
            past = (past * nums[i]) % 12345;
        }
        past = nums[n - 1] % 12345;
        for(int i = n - 2; i >= 0; i--){
            ans[i] = (int)((ans[i] * past) % 12345);
            // System.out.println(past);
            past = (past * nums[i]) % 12345;
        }

        int[][] res = new int[grid.length][grid[0].length];
        index = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                res[i][j] = ans[index++];
                // System.out.println(i + j + index);
            }
            // index += (grid[0].length) - 1;
        }

        return res;
    }
}