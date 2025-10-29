class Solution {
public:
    int smallestNumber(int n) {
        int ans = 0;
        while (n != 0) {
            ans |= 1;
            n = n >> 1;
            if (n != 0) ans = ans << 1;
        }
        return ans;
    }
};