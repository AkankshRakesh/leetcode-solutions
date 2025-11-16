class Solution {
public:
    int MOD = 1000000007;

    int numSub(string s) {
        long long ans = 0;
        int left = 0;
        int i = 1;

        for(i = 1; i < (int)s.length(); i++) {
            while(s[left] != '1' && left < i) left++;

            if(s[i] == '0' && s[left] == '1') {
                int len = i - left;
                ans += (long long)len * (len + 1) / 2;
                ans %= MOD;
                left = i;
            }
        }

        if(s[s.length() - 1] == '1') {
            int len = i - left;
            ans += (long long)len * (len + 1) / 2;
            ans %= MOD;
        }

        return (int)ans;
    }
};
