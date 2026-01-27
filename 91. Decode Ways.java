class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if(s.length() == 1) return 1;
        dp[1] = s.charAt(1) == '0' ? 0 : 1;

        for(int i = 2; i < s.length(); i++){
            if(s.charAt(i) == '0') continue;
            int num = Integer.parseInt(s.charAt(i - 2) + "" + s.charAt(i - 1));
            
            if(num > 26) dp[i] = dp[i - 1];
            else dp[i] = dp[i - 1] + dp[i - 2];
        }

        int num = Integer.parseInt(s.charAt(s.length() - 2) + "" + s.charAt(s.length() - 1));
        if(num > 26) return dp[s.length() - 1];

        return dp[s.length() - 1] + dp[s.length() - 2];
    }
}