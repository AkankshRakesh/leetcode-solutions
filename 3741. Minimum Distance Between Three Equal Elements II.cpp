class Solution {
public:
    int minimumDistance(const vector<int>& nums) {
        int ans = INT_MAX;
        unordered_map<int, vector<int>> hm;

        for (int i = 0; i < (int)nums.size(); i++) {
            int num = nums[i];
            if (hm.find(num) == hm.end()) {
                hm[num] = vector<int>{-1, -1, -1};
            }
            vector<int>& coords = hm[num];

            if (coords[0] == -1) coords[0] = i;
            else if (coords[1] == -1) coords[1] = i;
            else if (coords[2] == -1) {
                coords[2] = i;
                ans = min(ans, (coords[1] - coords[0]) + (coords[2] - coords[1]) + (coords[2] - coords[0]));
            }
            else {
                coords[0] = coords[1];
                coords[1] = coords[2];
                coords[2] = i;
                ans = min(ans, (coords[1] - coords[0]) + (coords[2] - coords[1]) + (coords[2] - coords[0]));
            }
        }

        return ans == INT_MAX ? -1 : ans;
    }
};