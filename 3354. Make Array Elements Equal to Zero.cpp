class Solution {
public:
    int countValidSelections(vector<int>& nums) {
        int n = nums.size();
        int validCount = 0;

        auto simulate = [&](int start, int direction) -> bool {
            vector<int> arr = nums;
            int curr = start;
            int move = direction;

            while (curr >= 0 && curr < n) {
                if (arr[curr] == 0) {
                    curr += move;
                } else {
                    arr[curr]--;
                    move = -move;
                    curr += move;
                }
            }

            for (int num : arr) {
                if (num != 0)
                    return false;
            }
            return true;
        };

        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                if (simulate(i, 1))
                    validCount++;
                if (simulate(i, -1))
                    validCount++;
            }
        }

        return validCount;
    }
};