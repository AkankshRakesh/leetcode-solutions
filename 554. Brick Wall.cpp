class Solution {
public:
    int leastBricks(const vector<vector<int>>& wall) {
        unordered_map<int, int> sums;
        long rowSum = 0;
        for (const auto& layer : wall) {
            long sum = 0;
            for (int brick : layer) {
                sum += brick;
                sums[sum]++;
            }
            rowSum = sum;
        }
        int ans = wall.size();
        for (const auto& ele : sums) {
            if (ele.first == rowSum) continue;
            ans = min(ans, static_cast<int>(wall.size()) - ele.second);
        }
        return ans;
    }
};

