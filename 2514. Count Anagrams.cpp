class Solution {
public:
    const int MOD = 1000000007;

    long long fastPow(long long a, long long b) {
        if (b == 0) return 1;
        else if (b % 2 == 0) {
            long long half = fastPow(a, b / 2) % MOD;
            return (half * half) % MOD;
        } else {
            return (a * fastPow(a, b - 1)) % MOD;
        }
    }

    int countAnagrams(string s) {
        vector<int> fact(s.length() + 1);
        fact[0] = 1;
        for (int i = 1; i <= (int)s.length(); i++) {
            fact[i] = (int)((1LL * i * fact[i - 1]) % MOD);
        }

        vector<int> freq(26, 0);
        long long ans = 1;
        int len = 0;

        for (int i = 0; i <= (int)s.length(); i++) {
            if (i == (int)s.length() || s[i] == ' ') {
                if (len > 0) {
                    long long b = 1;
                    for (int j = 0; j < 26; j++) {
                        if (freq[j] >= 1) {
                            b = (b * fact[freq[j]]) % MOD;
                        }
                    }
                    b = fastPow(b, MOD - 2);
                    long long temp = (1LL * fact[len] * b) % MOD;
                    ans = (ans * temp) % MOD;

                    fill(freq.begin(), freq.end(), 0);
                    len = 0;
                }
            } else {
                freq[s[i] - 'a']++;
                len++;
            }
        }

        return (int)ans;
    }
};
