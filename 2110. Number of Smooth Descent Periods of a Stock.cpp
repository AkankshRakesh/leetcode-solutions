class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        long long ans = prices.size();
        int left = 0, right = 1;

        while (right < prices.size()) {
            if (prices[right] + 1 != prices[right - 1]) {
                int num = right - left - 1;
                long long sum = 0;
                while (num > 0) {
                    sum += num;
                    num--;
                }
                ans += sum;
                left = right;
            }
            right++;
        }

        int num = right - left - 1;
        long long sum = 0;
        while (num > 0) {
            sum += num;
            num--;
        }
        ans += sum;

        return ans;
    }
};
