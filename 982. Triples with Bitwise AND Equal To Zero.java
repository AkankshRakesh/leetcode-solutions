class Solution {
    public int countTriplets(int[] nums) {
        int N = 1 << 16;
        int[] dp = new int[N];
        dp[N - 1] = 1;
        for (int i = 0; i < 3; i++) {
            int[] temp = new int[N];
            
            for (int k = 0; k < N; k++) {
                for (int num : nums) {
                    temp[k & num] += dp[k];
                }
            }
            dp = temp;
        }
        return dp[0];
    }
}