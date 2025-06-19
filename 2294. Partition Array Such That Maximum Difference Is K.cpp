class Solution {
public:
    std::vector<int> countSort(const std::vector<int>& inputArray) {
        int N = inputArray.size();
        int M = 0;

        for (int i = 0; i < N; i++) {
            M = std::max(M, inputArray[i]);
        }

        std::vector<int> countArray(M + 1, 0);

        for (int i = 0; i < N; i++) {
            countArray[inputArray[i]]++;
        }

        for (int i = 1; i <= M; i++) {
            countArray[i] += countArray[i - 1];
        }

        std::vector<int> outputArray(N);

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }

        return outputArray;
    }

    int partitionArray(std::vector<int>& nums, int k) {
        int n = nums.size();
        nums = countSort(nums);

        int ans = 1;
        int currMin = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] - currMin > k) {
                ans++;
                currMin = nums[i];
            }
        }

        return ans;
    }
};
