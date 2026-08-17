class Solution {
    public int dfs(int[] stoneValue, int left, int right, int[][] dp){
        if(left >= right) return 0;
        if(dp[left][right] != -1) return dp[left][right];

        int[] prefix = new int[right - left + 1];
        int sum = 0;

        for(int i = left; i <= right; i++){
            sum += stoneValue[i];
            prefix[i - left] = sum;
        }

        int max = 0;
        for(int i = left; i < right; i++){
            int leftSum = prefix[i - left];
            int rightSum = sum - leftSum;
            if(leftSum > rightSum){
                int res = dfs(stoneValue, i + 1, right, dp);
                max = Math.max(max, res + rightSum);
            }
            else if(leftSum < rightSum){
                int res = dfs(stoneValue, left, i, dp);
                max = Math.max(max, res + leftSum);
            }
            else{
                int res = Math.max(dfs(stoneValue, i + 1, right, dp), dfs(stoneValue, left, i, dp));
                max = Math.max(max, res + leftSum);
            }
        }

        return dp[left][right] = max;
    }
    public int stoneGameV(int[] stoneValue) {
        int[][] dp = new int[stoneValue.length][stoneValue.length];
        for(int i = 0; i < stoneValue.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(stoneValue, 0, stoneValue.length - 1, dp);
    }
}