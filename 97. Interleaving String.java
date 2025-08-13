class Solution {
    public boolean dfs(String s1, String s2, String s3, int i, int j, int k, Boolean[][] dp){
        if(s3.length() <= k){
            return (s1.length() <= i && s2.length() <= j);
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        boolean res = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            res = dfs(s1, s2, s3, i + 1, j, k + 1, dp);
        }
        if(!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            res = dfs(s1, s2, s3, i, j + 1, k + 1, dp);
        }
        
        dp[i][j] = res;
        return res;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if(n + m != s3.length()) return false;

        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return dfs(s1, s2, s3, 0, 0, 0, dp);
    }
}