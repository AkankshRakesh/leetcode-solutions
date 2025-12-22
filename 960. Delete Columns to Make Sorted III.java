class Solution {
    public int dfs(int[][] dp, int ind, int prev, String[] strs){
        if(ind == strs[0].length()) return 0;
        if(dp[ind][prev + 1] != -1) return dp[ind][prev + 1];
        if(prev == -1) return dp[ind][prev + 1] = Math.min(dfs(dp, ind + 1, ind, strs), 1 + dfs(dp, ind + 1, prev, strs));

        boolean check = true;
        for(String str : strs){
            if(str.charAt(prev) > str.charAt(ind)){
                check = false;
                break;
            }
        }

        if(check) return dp[ind][prev + 1] = Math.min(dfs(dp, ind + 1, ind, strs), 1 + dfs(dp, ind + 1, prev, strs));

        return dp[ind][prev + 1] = 1 + dfs(dp, ind + 1, prev, strs);
    }
    public int minDeletionSize(String[] strs) {
        int[][] dp = new int[120][120];
        for(int i = 0; i < 120; i++) Arrays.fill(dp[i], -1);

        return dfs(dp, 0, -1, strs);
    }
}