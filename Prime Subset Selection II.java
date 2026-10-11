class Solution {
    public List<Integer> maxPrimeSubset(int n, int s) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;
    
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i] && i <= s) nums.add(i);
        }
    
        int m = nums.size();
    
        int INF = 1_000_000;
        int[][] dp = new int[m + 1][s + 1];
    
        for (int sum = 1; sum <= s; sum++) dp[m][sum] = INF;
    
        for (int i = m - 1; i >= 0; i--) {
            int p = nums.get(i);
    
            for (int sum = 0; sum <= s; sum++) {
                dp[i][sum] = dp[i + 1][sum];
    
                if (sum >= p && dp[i + 1][sum - p] != INF) {
                    dp[i][sum] = Math.min(
                        dp[i][sum],
                        1 + dp[i + 1][sum - p]
                    );
                }
            }
        }
    
        int maxSum = s;
        while (maxSum > 0 && dp[0][maxSum] == INF) maxSum--;
    
        List<Integer> ans = new ArrayList<>();
        int remaining = maxSum;
        int need = dp[0][maxSum];
    
        for (int i = 0; i < m && need > 0; i++) {
            int p = nums.get(i);
    
            if (remaining >= p &&
                dp[i + 1][remaining - p] == need - 1) {
                ans.add(p);
                remaining -= p;
                need--;
            }
        }
    
        return ans;
    }
}