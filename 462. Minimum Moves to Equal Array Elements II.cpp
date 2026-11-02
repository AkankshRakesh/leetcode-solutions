class Solution {
public:
    int moves(vector<int>& nums, int num) {
        int ans = 0;
        for (int ele : nums) {
            ans += abs(num - ele);
        }

        return ans;
    }

    int minMoves2(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        int first = nums[nums.size() / 2];

        if (nums.size() % 2 == 0) {
            int second = nums[(nums.size() / 2) - 1];

            return min(moves(nums, first), moves(nums, second));
        }

        return moves(nums, first);
    }
};