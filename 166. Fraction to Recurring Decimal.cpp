class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        long long num = llabs((long long)numerator);
        long long den = llabs((long long)denominator);
        string ans;

        if ((numerator < 0) ^ (denominator < 0)) ans.push_back('-');

        ans += to_string(num / den);
        if (num % den == 0) return ans;

        ans.push_back('.');
        long long remainder = num % den;

        unordered_map<long long, int> mp; 
        while (remainder != 0) {
            if (mp.count(remainder)) {
                ans.insert(mp[remainder], "(");
                ans.push_back(')');
                break;
            }
            mp[remainder] = ans.size();
            remainder *= 10;
            ans += to_string(remainder / den);
            remainder %= den;
        }

        return ans;
    }
};
