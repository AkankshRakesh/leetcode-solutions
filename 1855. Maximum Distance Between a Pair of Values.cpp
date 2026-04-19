class Solution {
public:
    int maxDistance(const vector<int>& nums1, const vector<int>& nums2) {
        int ans = INT_MIN;
        int n = nums1.size(), m = nums2.size();
        for (int i = 0; i < n; i++) {
            if (i >= m) break;
            int left = i, right = m - 1;
            int currAns = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums2[mid] >= nums1[i]) {
                    currAns = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (currAns != -1) ans = max(ans, currAns - i);
        }

        return ans == INT_MIN ? 0 : ans;
    }
};