class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        map<int, int> hm; 
        int counter = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                counter++;
            }
            if (nums[i] == 0) {
                if (counter == 0) continue;
                hm[i - counter] = counter;
                counter = 0;
            }
        }

        if (counter != 0) {
            hm[n - counter] = counter;
        }

        int prevInd = -1, prevCount = 0;
        int ans = 0;

        if (hm.size() == 1 && hm.count(0) && hm.begin()->second == n) {
            return hm.begin()->second - 1;
        }

        for (auto& ele : hm) {
            int ind = ele.first;
            int count = ele.second;

            ans = max(ans, count);

            if (prevInd != -1 && ind - (prevInd + prevCount) == 1) {
                ans = max(ans, prevCount + count);
            }

            prevInd = ind;
            prevCount = count;
        }

        return ans;
    }
};
