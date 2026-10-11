class Solution {
public:
    vector<int> maxPrimes(int n, int s) {
        vector<bool> isPrime(n + 1, true);

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }

        vector<int> ans;
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                sum += i;
                if (sum > s) break;
                ans.push_back(i);
            }
        }

        return ans;
    }
};