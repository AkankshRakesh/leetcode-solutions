class Solution {
public:
    bool kLengthApart(vector<int>& nums, int k) {
        int last = -1;
        int ind = 0;

        for (int num : nums) {
            if (num == 1) {
                if (last == -1) {
                    last = ind;
                } else {
                    if (ind - last - 1 < k) return false;
                    last = ind;
                }
            }
            ind++;
        }

        return true;
    }
};
