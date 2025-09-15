class Solution {
public:
    static int largestPrimeFactor(int n) {
        int maxFactor = INT_MIN;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                maxFactor = max(maxFactor, i);
                while (n % i == 0) n /= i;
            }
        }

        if (n > 2) maxFactor = max(maxFactor, n);

        return maxFactor;
    }
};
