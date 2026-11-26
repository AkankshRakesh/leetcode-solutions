class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        if (k == 1) return nums;

        vector<int> ans(nums.size() - k + 1);
        int index = 1;

        priority_queue<pair<int, int>> pq;

        for (int i = 0; i < k; i++) {
            pq.emplace(nums[i], i);
        }

        ans[0] = pq.top().first;
        for (int i = 1; i + k <= (int)nums.size(); i++) {
            int ele = nums[i + k - 1];
            pq.emplace(ele, i + k - 1);
            while (pq.top().second < i) pq.pop();
            ans[index++] = pq.top().first;
        }

        return ans;
    }
};