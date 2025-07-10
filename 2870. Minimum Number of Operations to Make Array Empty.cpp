class Solution {
public:
    int minOperations(std::vector<int>& nums) {
        int operations = 0;
        int count = 1;
        int n = nums.size();
        std::sort(nums.begin(), nums.end());

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (count == 1) return -1;
                else if (count % 3 == 0) operations += count / 3;
                else operations += count / 3 + 1;
                count = 1;
            }
        }

        if (count == 1) return -1;
        else if (count % 3 == 0) operations += count / 3;
        else operations += count / 3 + 1;

        return operations;
    }
};
