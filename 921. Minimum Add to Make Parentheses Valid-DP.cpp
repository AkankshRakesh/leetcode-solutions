class Solution {
    public int dfs(String s, int index, int currSum, int[][] dp){
        if(index >= s.length()) return currSum == 0 ? 0 : Integer.MAX_VALUE;
        if(currSum < 0) return Integer.MAX_VALUE;

        if(dp[index][currSum] != -1) return dp[index][currSum];

        int nextSum = currSum;
        if(s.charAt(index) == '(') nextSum++;
        else nextSum--;

        int makeMove = Math.min(dfs(s, index + 1, nextSum + 1, dp), dfs(s, index + 1, nextSum - 1, dp));
        if(makeMove != Integer.MAX_VALUE) makeMove++;

        int noMove = dfs(s, index + 1, nextSum, dp);

        return dp[index][currSum] = Math.min(makeMove, noMove);
    }
    public int minAddToMakeValid(String s) {
        int[][] dp = new int[s.length()][2000];
        for(int i = 0; i < s.length(); i++) Arrays.fill(dp[i], -1);

        return dfs(s, 0, 0, dp);
    }
}