class Solution {
public:
    bool check(int n) {
        int mask = 0b01010101010101010101010101010101;
        return ((mask | n) == mask);
    }

    bool isPowerOfFour(int n) {
        return (n > 0 && ((n & (n - 1)) == 0) && check(n));
    }
};
