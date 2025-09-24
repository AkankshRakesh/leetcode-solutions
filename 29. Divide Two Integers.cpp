class Solution {
public:
    int divide(int dividend, int divisor) {
        const int MAX = INT_MAX;
        const int MIN = INT_MIN;

        if (dividend == MIN) {
            if (divisor == 1) return MIN;
            if (divisor == -1) return MAX;
        }

        if (divisor == MIN) {
            return dividend == MIN ? 1 : 0;
        }

        if (dividend != MIN && abs(dividend) < abs(divisor)) return 0;

        bool neg = (dividend < 0) ^ (divisor < 0);

        int a;
        int extra = 0;
        if (dividend == MIN) {
            dividend += abs(divisor);
            extra = 1;
        }
        a = abs(dividend);
        int b = abs(divisor);

        int ans = 0;
        while (a >= b) {
            int div = b;
            int q = 1;
            while (div <= (INT_MAX >> 1) && a >= (div << 1)) {
                div <<= 1;
                q <<= 1;
            }
            a -= div;
            ans += q;
        }

        if (extra == 1) ans += 1;

        return neg ? -ans : ans;
    }
};
