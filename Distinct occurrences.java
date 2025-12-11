class Solution {
    public int dfs(String txt, String pat, int ind1, int ind2, int[][] dp){
        if(ind2 >= pat.length()) return 1;
        if(ind1 >= txt.length()) return 0;
        
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        int ans = 0;
        if(txt.charAt(ind1) == pat.charAt(ind2)){
            ans += dfs(txt, pat, ind1 + 1, ind2 + 1, dp);
        }
        ans += dfs(txt, pat, ind1 + 1, ind2, dp);
        return dp[ind1][ind2] = ans;
    }
    public int subseqCount(String txt, String pat) {
        int[][] dp = new int[txt.length()][pat.length()];
        for(int i = 0; i < txt.length(); i++){
            for(int j = 0; j < pat.length(); j++){
                dp[i][j] = -1;
            }
        }
        return dfs(txt, pat, 0, 0, dp);
    }
}