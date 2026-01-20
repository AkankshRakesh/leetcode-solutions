class Solution {
public:
    int reverse(int x) {
        int ans = 0;
        bool isNeg = false;
        if (x < 0) {
            isNeg = true;
            if (x == INT_MIN) return 0;
            x = -x;
        }

        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (ans > INT_MAX / 10 || (ans == INT_MAX / 10 && digit > INT_MAX % 10)) return 0;
            ans *= 10;
            ans += digit;
        }

        return isNeg ? -ans : ans;
    }
};