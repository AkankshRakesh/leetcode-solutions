class Solution {
    public boolean dfs(String s, int index, int op, Boolean[][] dp){
        if(index >= s.length()) return op == 0;

        if(dp[index][op] != null) return dp[index][op];

        boolean res = false;
        char ch = s.charAt(index);
        if(ch == '*'){
            res |= dfs(s, index + 1, op + 1, dp);
            if(op != 0) res |= dfs(s, index + 1, op - 1, dp);
            res |= dfs(s, index + 1, op, dp);
        }
        else if(ch == '(') res = dfs(s, index + 1, op + 1, dp);
        else if(ch == ')' && op != 0) res = dfs(s, index + 1, op - 1, dp);

        return dp[index][op] = res;
    }
    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];

        return dfs(s, 0, 0, dp);
    }
}