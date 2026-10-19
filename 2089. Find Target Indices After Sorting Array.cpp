class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        int maxVal = nums[0];
        for (int num : nums) maxVal = max(maxVal, num);

        vector<int> freq(maxVal + 1, 0);
        for (int num : nums) freq[num]++;

        vector<int> sorted(nums.size());
        int index = 0;

        for (int i = 0; i <= maxVal; i++) {
            int currFreq = freq[i];
            while (currFreq != 0) {
                sorted[index] = i;
                index++;
                currFreq--;
            }
        }

        vector<int> ans;
        for (int i = 0; i < sorted.size(); i++) {
            if (sorted[i] == target) ans.push_back(i);
        }

        return ans;
    }
};