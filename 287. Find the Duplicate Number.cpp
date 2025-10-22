class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int ans = 0;

        for (int bit = 0; bit < 32; bit++) {
            int mask = 1 << bit;
            int x = 0, y = 0;

            for (int num : nums) {
                if ((num & mask) == mask) x++;
            }

            for (int i = 1; i < (int)nums.size(); i++) {
                if ((i & mask) == mask) y++;
            }

            if (x > y) ans |= mask;
        }

        return ans;
    }
};
