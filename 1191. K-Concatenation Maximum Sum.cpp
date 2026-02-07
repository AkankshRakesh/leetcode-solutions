class Solution {
    const int MOD = 1'000'000'007;
public:
    long long kadane(const std::vector<int>& arr) {
        long long currSum = 0, globalSum = 0;
        for (int num : arr) {
            currSum = std::max<long long>(num, num + currSum);
            globalSum = std::max(globalSum, currSum);
        }
        return globalSum % MOD;
    }

    int kConcatenationMaxSum(const std::vector<int>& arr, int k) {
        if (k == 1) return static_cast<int>(kadane(arr));

        std::vector<int> nums(arr.size() * 2);
        for (size_t i = 0; i < arr.size(); i++) {
            nums[i] = arr[i];
            nums[i + arr.size()] = arr[i];
        }

        long long maxSum = kadane(nums);
        long long arrSum = 0;
        for (int num : arr) arrSum += num;

        if (arrSum <= 0) return static_cast<int>(maxSum % MOD);
        return static_cast<int>((maxSum + (k - 2) * arrSum) % MOD);
    }
};