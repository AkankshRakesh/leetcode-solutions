class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int ans = 0;
        int n = nums.size();
        unordered_set<int> hs;

        for (int i = 0; i < n; i++) {
            int a = nums[i];
            if (hs.count(a)) continue;

            int left = i + 1;
            int right = n - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == k + a) {
                    hs.insert(a);
                    ans++;
                    break;
                }
                else if (nums[mid] > k + a) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }

        return ans;
    }
};
