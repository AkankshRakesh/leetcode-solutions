class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        vector<int> remArr(value, 0);

        for (int num : nums) {
            if (num < 0) {
                int rem = (-num) % value;
                remArr[(value - rem) % value]++;
            } else {
                remArr[num % value]++;
            }
        }

        int ans = 0;
        while (remArr[ans % value] > 0) {
            remArr[ans % value]--;
            ans++;
        }

        return ans;
    }
};