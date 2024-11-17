class Solution {
public:
    bool isZeroArray(vector<int>& nums, vector<vector<int>>& q, int k) {
    vector<int> line(nums.size() + 1);
    for (int i = 0; i < k; ++i) {
        line[q[i][0]] += q[i][2];
        line[q[i][1] + 1] -= q[i][2];
    }
    int cur = 0;
    for (int i = 0; i < nums.size(); ++i) {
        cur += line[i];
        if (nums[i] > cur)
            return false;
    }
    return true;
}    
int minZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
    int l = 0, r = queries.size() + 1;
    while (l < r) {
        int m = (l + r) / 2;
        if (isZeroArray(nums, queries, m))
            r = m;
        else
            l = m + 1;
    }
    return l <= queries.size() ? l : -1;
}
};