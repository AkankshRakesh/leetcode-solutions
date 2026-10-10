class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        int maxDiff = abs(nums1[0] - nums2[0]);

        for (int i = 0; i < nums1.size(); i++) {
            maxDiff = max(maxDiff, abs(nums1[i] - nums2[i]));
        }

        vector<int> freq(maxDiff + 1, 0);

        for (int i = 0; i < nums1.size(); i++) {
            freq[abs(nums1[i] - nums2[i])]++;
        }

        long long k = (long long)k1 + (long long)k2;

        int index = maxDiff;
        while (index > 0 && k != 0) {
            if (freq[index] > k) {
                freq[index - 1] += k;
                freq[index] -= k;
                k = 0;
            }
            else {
                freq[index - 1] += freq[index];
                k -= freq[index];
                freq[index] = 0;
            }
            index--;
        }

        long long ans = 0;
        for (int i = 1; i <= maxDiff; i++) {
            ans += (long long)i * i * freq[i];
        }

        return ans;
    }
};