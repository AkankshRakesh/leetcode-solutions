class Solution {
public:
    int nonSpecialCount(int l, int r) {
        int n = (int)sqrt(r);
        vector<bool> isPrime(n + 1, true);
        fill(isPrime.begin(), isPrime.end(), true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i] && i * i >= l)
                count++;
        }

        return r - l + 1 - count;
    }
};