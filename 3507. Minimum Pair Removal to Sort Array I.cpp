#include <vector>
#include <climits>
#include <algorithm>

class Solution {
public:
    bool check(const std::vector<int>& arr) {
        for (size_t i = 1; i < arr.size(); i++)
            if (arr[i] < arr[i - 1])
                return false;
        return true;
    }

    int minimumPairRemoval(const std::vector<int>& nums) {
        std::vector<int> arr(nums.begin(), nums.end());

        while (!check(arr)) {
            int sum = INT_MAX;
            for (size_t i = 1; i < arr.size(); i++)
                sum = std::min(sum, arr[i] + arr[i - 1]);

            std::vector<int> changedArr;
            bool merged = false;

            for (size_t i = 0; i < arr.size();) {
                if (!merged && i + 1 < arr.size() && arr[i] + arr[i + 1] == sum) {
                    changedArr.push_back(arr[i] + arr[i + 1]);
                    merged = true;
                    i += 2;
                } else {
                    changedArr.push_back(arr[i]);
                    i++;
                }
            }

            arr = std::move(changedArr);
        }

        return static_cast<int>(nums.size() - arr.size());
    }
};