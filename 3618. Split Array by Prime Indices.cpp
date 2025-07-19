class Solution {
public:
    bool isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= std::sqrt(n); ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }

    long long splitArray(std::vector<int>& nums) {
        int n = nums.size();
        long long a = 0, b = 0;

        for (int i = 0; i < n; ++i) {
            if (isPrime(i)) b += nums[i];
            else a += nums[i];
        }

        return std::llabs(a - b);
    }
};
