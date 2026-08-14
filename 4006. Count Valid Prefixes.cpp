class Solution {
public:
    int countValidPrefixes(string s) {
        int zero = 0, one = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '0') zero++;
            else one++;

            if (zero == one || zero + 1 == one || one + 1 == zero)
                ans++;
        }

        return ans;
    }
};