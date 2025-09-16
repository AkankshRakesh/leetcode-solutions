class Solution {
    public int backtrack(ArrayList<Integer> arr, int dp[], int target){
        if(target == 0) return 0;
        int ans = Integer.MAX_VALUE;
        if(target < 0) return ans;
        if(dp[target] != -1) return dp[target];

        for(int i = 0; i < arr.size(); i++){
            int res = backtrack(arr, dp, target - arr.get(i));
            if(res != Integer.MAX_VALUE) ans = Math.min(ans, res + 1);
        }

        dp[target] = ans;
        return ans;
    }
    public int numSquares(int n) {
        ArrayList<Integer> ps = new ArrayList<>();
        int[] dp = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            ps.add(i * i);
        }

        for(int i = 0; i <= n; i++) dp[i] = -1;

        return backtrack(ps, dp, n);
    }
}