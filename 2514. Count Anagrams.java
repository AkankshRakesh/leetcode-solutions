class Solution {
    int MOD = (int)1e9 + 7;
    public long fastPow(long a, long b){
        if(b == 0) return 1;
        else if(b % 2 == 0){
            long half = fastPow(a, b / 2) % MOD;
            return (half * half) % MOD;
        }
        else{
            return (a * fastPow(a, b - 1)) % MOD;
        }
    }
    public int countAnagrams(String s) {
        int[] fact = new int[s.length() + 1];
        fact[0] = 1;
        for(int i = 1; i <= s.length(); i++){
            fact[i] = (int)((1L * i * fact[i - 1]) % MOD);
        }

        int[] freq = new int[26];
        long ans = 1;
        int len = 0;
        for(int i = 0; i <= s.length(); i++){
            if (i == s.length() || s.charAt(i) == ' ') {
                if (len > 0) {
                    long b = 1;
                    for(int j = 0; j < 26; j++){
                        if(freq[j] >= 1){
                            b = (b * fact[freq[j]]) % MOD;
                        }
                    }
                    b = fastPow(b, MOD - 2);  
                    long temp = (1L * fact[len] * b) % MOD; 
                    ans = (ans * temp) % MOD;        
                    freq = new int[26];
                    len = 0;
                }
            }
            else {
                freq[s.charAt(i) - 'a']++;
                len++;
            }
        }

        return (int)ans;
    }
}