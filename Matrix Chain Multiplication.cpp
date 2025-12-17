class Solution {
    static int divide(int[] arr, int[][] dp, int i, int j){
        if(i + 1 == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int res = Integer.MAX_VALUE;
        for(int k = i + 1; k < j; k++){
            res = Math.min(res, divide(arr, dp, i, k) + 
            divide(arr, dp, k, j) + (arr[i] * arr[j] * arr[k]));
        }
        
        return dp[i][j] = res;
    }
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        
        return divide(arr, dp, 0, n - 1);
    }
}