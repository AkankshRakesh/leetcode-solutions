class Solution {
    public int dfs(int[][] dp, String s1, String s2, int i, int j){
        if(i >= s1.length()){
            int sum = 0;
            for(int k = j; k < s2.length(); k++) sum += (int)s2.charAt(k);
            return sum;
        }
        if(j >= s2.length()){
            int sum = 0;
            for(int k = i; k < s1.length(); k++) sum += (int)s1.charAt(k);
            return sum;
        }
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = dfs(dp, s1, s2, i + 1, j + 1);

        int ascii1 = (int) s1.charAt(i);
        int ascii2 = (int) s2.charAt(j);

        int delete1 = ascii1 + dfs(dp, s1, s2, i + 1, j);
        int delete2 = ascii2 + dfs(dp, s1, s2, i, j + 1);
        return dp[i][j] = Math.min(delete1, delete2);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i++) Arrays.fill(dp[i], -1);

        return dfs(dp, s1, s2, 0, 0);
    }
}