class Solution {
public:
    long long continuousSubarrays(vector<int>& nums) {
        int left = 0, right = 0;
        long long count = 0; 
        priority_queue<int, vector<int>, function<bool(int, int)>> minHeap(
            [&nums](int a, int b) { return nums[a] > nums[b]; });
        priority_queue<int, vector<int>, function<bool(int, int)>> maxHeap(
            [&nums](int a, int b) { return nums[a] < nums[b]; });

        while (right < nums.size()) {
            minHeap.push(right);
            maxHeap.push(right);

            while (left < right &&
                   nums[maxHeap.top()] - nums[minHeap.top()] > 2) {
                left++;

                while (!maxHeap.empty() && maxHeap.top() < left) {
                    maxHeap.pop();
                }
                while (!minHeap.empty() && minHeap.top() < left) {
                    minHeap.pop();
                }
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
};