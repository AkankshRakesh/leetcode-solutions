class Solution {
    public boolean checkPattern(String p, int index){
        // System.out.println(index);
        if(index >= p.length()) return true;
        
        if(index + 1 >= p.length() || p.charAt(index + 1) != '*') return false;
        return checkPattern(p, index + 2);
    }
    public boolean backtrack(String s, String p, int i, int j, Boolean[][] dp){
        if(i >= s.length() && j >= p.length()) return true;
        if(j >= p.length()) return false;
        if(i >= s.length()){
            boolean res = checkPattern(p, j);
            // System.out.println("Res was: " + res);
            return res;
        }
        if(dp[i][j] != null) return dp[i][j];

        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
                return dp[i][j] = backtrack(s, p, i + 1, j, dp) || backtrack(s, p, i + 1, j + 2, dp) || backtrack(s, p, i, j + 2, dp);
            else
                return dp[i][j] = backtrack(s, p, i, j + 2, dp);
        } 
        else if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') return dp[i][j] = backtrack(s, p, i + 1, j + 1, dp);
        return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return backtrack(s, p, 0, 0, dp);
    }
}