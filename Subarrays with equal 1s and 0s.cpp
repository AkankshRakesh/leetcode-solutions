class Solution {
public:
    int countSubarray(const vector<int>& arr) {
        unordered_map<int, int> hm;
        int ans = 0;
        int sum = 0;
        hm[0] = 1;
        for (int num : arr) {
            if (num == 0) sum--;
            else sum++;

            if (hm.find(sum) != hm.end()) {
                ans += hm[sum];
                hm[sum]++;
            } else {
                hm[sum] = 1;
            }
        }

        return ans;
    }
};