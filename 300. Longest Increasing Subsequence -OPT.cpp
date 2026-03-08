class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> arr;
        for (int num : nums) {
            if (arr.empty() || arr.back() < num) {
                arr.push_back(num);
            } else {
                int left = 0, right = (int)arr.size() - 1;
                int ans = 0;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (arr[mid] < num) {
                        left = mid + 1;
                    } else {
                        ans = mid;
                        right = mid - 1;
                    }
                }
                arr[ans] = num;
            }
        }
        return (int)arr.size();
    }
};