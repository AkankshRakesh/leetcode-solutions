class Solution {
public:
    int minSwaps(vector<int>& nums) {
        vector<vector<int>> arr(nums.size(), vector<int>(2));
        unordered_map<int, int> hm;

        for (int i = 0; i < nums.size(); i++) {
            int temp = nums[i];
            int sum = 0;

            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }

            hm[nums[i]] = i;

            arr[i][0] = sum;
            arr[i][1] = nums[i];
        }

        sort(arr.begin(), arr.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] == b[0] ? a[1] < b[1] : a[0] < b[0];
        });

        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (arr[i][1] != nums[i]) {
                int swapIndex = hm[arr[i][1]];
                hm[nums[i]] = swapIndex;
                hm[arr[i][1]] = i;
                ans++;

                int temp = nums[i];
                nums[swapIndex] = nums[i];
                nums[i] = temp;
            }
        }

        return ans;
    }
};