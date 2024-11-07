#include <vector>
#include <climits>
using namespace std;
class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        int max = INT_MIN;
        for(int i = 0; i < 32; i++){
            int cnt = 0;
            for(auto cand : candidates){
                if(cand & (1 << i)) cnt++;
            }
            if(max < cnt) max = cnt;
        }
        return max;
    }
};