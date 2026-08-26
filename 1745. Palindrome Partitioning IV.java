class Solution {
    public boolean dfs(String s, int i, int j, Boolean[][] dp){
        if(i < 0 || j < 0 || i >= s.length() || j >= s.length()) return false;

        if(dp[i][j] != null) return dp[i][j];

        if(j - i + 1 == 1) return dp[i][j] = true;
        else if(j - i + 1 == 2) return dp[i][j] = (s.charAt(i) == s.charAt(j));
        
        return dp[i][j] = (s.charAt(i) == s.charAt(j) && dfs(s, i + 1, j - 1, dp)); 
    }
    public boolean checkPartitioning(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = dfs(s, i, j, dp);
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }

        for(int i = 0; i < n; i++){
            for(int j = n - 1; j >= 0; j--){
                if(j - i + 1 >= 1 && j != n - 1 && i != n - 1 && dp[0][i] && dp[i + 1][j] && dp[j + 1][n - 1]) return true;
            }
        }

        return false;
    }
}   