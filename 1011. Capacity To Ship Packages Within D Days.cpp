class Solution {
public:
    bool canShip(vector<int>& nums, int days, int w) {
        int index = 0;
        int curr = 0;

        while (index < nums.size() && days > 0) {
            if (curr + nums[index] > w) {
                days--;
                curr = 0;
            }
            else {
                curr += nums[index];
                index++;
            }
        }

        if (days <= 0) return false;
        return true;
    }

    int shipWithinDays(vector<int>& weights, int days) {
        int sum = 0;
        int minVal = weights[0];

        for (int weight : weights) {
            sum += weight;
            minVal = min(minVal, weight);
        }

        int left = minVal, right = sum;
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return ans;
    }
};