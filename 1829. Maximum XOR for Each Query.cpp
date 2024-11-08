#include <vector>
#include <math.h>
using namespace std;
class Solution {
public:
    vector<int> getMaximumXor(vector<int>& nums, int maximumBit) {
        int xorSum = nums[0];
        vector<int> xorArr;
        xorArr.push_back(xorSum);
        for(int i = 1; i < nums.size(); i++){
            xorSum ^= nums[i];
            xorArr.push_back(xorSum);
        }
        vector<int> ans;
        int max = pow(2, maximumBit) - 1, n = xorArr.size();
        for(int i = n - 1; i >= 0; i--){
            int calc = max ^ xorArr[i];
            ans.push_back(calc);
        }
        return ans;
    }
};