class Solution {
    int MOD = 1000000007;
    public int numSub(String s) {
        long ans = 0;
        int left = 0;
        int i = 1;
        for(i = 1; i < s.length(); i++){
            while(s.charAt(left) != '1' && left < i) left++;

            if(s.charAt(i) == '0' && s.charAt(left) == '1'){
                int len = i - left;
                ans += (long)len * (len + 1) / 2;
                ans %= MOD;
                left = i;
            }
            
        }

        if(s.charAt(s.length() - 1) == '1'){
            int len = i - left;
            ans += (long)len * (len + 1) / 2;
            ans %= MOD;
        }
        return (int) ans;
    }
}