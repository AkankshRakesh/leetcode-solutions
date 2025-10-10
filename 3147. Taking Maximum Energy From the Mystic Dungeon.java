class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];

        for(int i = n - 1; i >= 0; i--){
            if(i + k >= n) dp[i] =  energy[i];
            else dp[i] = energy[i] + dp[i + k];
        }

        int ans = Integer.MIN_VALUE;
        for(int dpVal : dp) if(dpVal > ans) ans = dpVal;

        return ans;
    }
}