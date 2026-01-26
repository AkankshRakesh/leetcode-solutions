class Solution {
public:
    std::vector<std::vector<int>> minimumAbsDifference(std::vector<int>& arr) {
        std::vector<std::vector<int>> ans;
        std::sort(arr.begin(), arr.end());
        int minDiff = INT_MAX;
        for (size_t i = 1; i < arr.size(); i++) {
            minDiff = std::min(minDiff, arr[i] - arr[i - 1]);
        }

        for (size_t i = 1; i < arr.size(); i++) {
            if (minDiff == arr[i] - arr[i - 1]) {
                ans.push_back({arr[i - 1], arr[i]});
            }
        }

        return ans;
    }
};