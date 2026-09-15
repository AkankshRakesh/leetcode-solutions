class Solution {
    private boolean checkPalindrome(StringBuilder sb){
        for(int i = 0; i < sb.length() / 2; i++){
            if(sb.charAt(i) != sb.charAt(sb.length() - i - 1)) return false;
        }

        return true;
    }
    private int[] substrIndex(String s, int k){
        // greedy: i -> j -> when k / 2 > j - i -> start palin check by stack pop
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(isPal[i], false);

        for(int len = 1; len <= n; len++){
            for(int i = 0; i + len <= n; i++){
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && (len <= 2 || isPal[i + 1][j - 1])) isPal[i][j] = true;
            }
        }
        
        int[] indexes = new int[n];
        Arrays.fill(indexes, -1);

        for(int i = 0; i < n; i++){
            for(int j = i + k - 1; j < n; j++){
                if(isPal[i][j]){
                    indexes[i] = j;
                    break;
                }
            }
        }

        return indexes;
    }
    private int dfs(int[] nums, int index, int[] dp){
        if(index >= nums.length) return 0;

        if(dp[index] != -1) return dp[index];

        int pick = 0;
        if(nums[index] != -1) pick = 1 + dfs(nums, nums[index] + 1, dp);
        
        int notPick = dfs(nums, index + 1, dp);

        return dp[index] = Math.max(pick, notPick);
    }
    public int maxPalindromes(String s, int k) {
        int[] indexes = substrIndex(s, k);
        int[] dp = new int[indexes.length];
        Arrays.fill(dp, -1);
        dfs(indexes, 0, dp);
        
        int ans = 0;
        for(int i = 0; i < indexes.length; i++){
            // System.out.println(indexes[i]);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}