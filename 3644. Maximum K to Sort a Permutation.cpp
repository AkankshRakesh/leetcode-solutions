class Solution {
public:
    int sortPermutation(vector<int>& nums) {
        int n = nums.size();
        int swapCost = ~0;
        vector<bool> visited(n, false);
        bool found = false;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && nums[i] != i) {
                found = true;
                int andFound = ~0;
                int curr = i;

                while (!visited[curr]) {
                    visited[curr] = true;
                    andFound &= nums[curr];
                    curr = nums[curr];
                }

                swapCost &= andFound;
            }
        }

        return found ? swapCost : 0;
    }
};
