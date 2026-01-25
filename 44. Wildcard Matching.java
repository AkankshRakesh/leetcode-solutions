class Solution {
    public boolean dfs(String s, String p, int i, int j, Boolean[][] dp){
        if(i >= s.length() && j >= p.length()) return true;
        if(j >= p.length()) return false;
        if(i >= s.length()){
            for(int jj = j; jj < p.length(); jj++) if(p.charAt(jj) != '*') return false;
            return true;
        }
        if(dp[i][j] != null) return dp[i][j]; 

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') return dp[i][j] = dfs(s, p, i + 1, j + 1, dp);
        else if(p.charAt(j) == '*') return dp[i][j] = dfs(s, p, i + 1, j + 1, dp) | dfs(s, p, i + 1, j, dp) | dfs(s, p, i, j + 1, dp);
        
        return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return dfs(s, p, 0, 0, dp);
    }
}