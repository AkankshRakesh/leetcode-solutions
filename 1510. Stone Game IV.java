class Solution {
    public boolean dfs(int n, ArrayList<Integer> arr, boolean aTurn, Boolean[][] dp){
        if(n <= 0){
            if(aTurn) return false;
            return true;
        }

        int index = aTurn ? 0 : 1;
        if(dp[n][index] != null) return dp[n][index];

        if(!aTurn){
            boolean res = true;
            for(int i = 0; i < arr.size(); i++){
                if(arr.get(i) > n) break;

                res &= dfs(n - arr.get(i), arr, !aTurn, dp);
            }    

            return dp[n][index] = res;
        }

        boolean res = false;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) > n) break;

            res |= dfs(n - arr.get(i), arr, !aTurn, dp);
        }

        return dp[n][index] = res;
    }
    public boolean winnerSquareGame(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i * i <= n; i++){
            arr.add(i * i);
        }
        Boolean[][] dp = new Boolean[n + 1][2];

        return dfs(n, arr, true, dp);
    }
}