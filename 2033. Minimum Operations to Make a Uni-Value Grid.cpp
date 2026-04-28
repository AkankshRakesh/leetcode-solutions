class Solution {
public:
    int minOperations(vector<vector<int>>& grid, int x) {
        vector<int> arr;
        for (const auto& row : grid) {
            for (int val : row) {
                arr.push_back(val);
            }
        }

        sort(arr.begin(), arr.end());
        int mid = arr[arr.size() / 2];
        int ans = 0;
        for (int val : arr) {
            int diff = val > mid ? val - mid : mid - val;
            if (diff % x != 0) return -1;
            ans += diff / x;
        }

        return ans;
    }
};