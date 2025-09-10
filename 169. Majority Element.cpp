#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int, int> hm;
        for (int num : nums) {
            hm[num]++; // count frequency
        }

        int maxKey = nums[0];
        int maxCount = hm[maxKey];

        for (auto &ele : hm) {
            if (ele.second > maxCount) {
                maxKey = ele.first;
                maxCount = ele.second;
            }
        }
        return maxKey;
    }
};
