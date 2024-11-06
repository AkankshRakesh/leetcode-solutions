#include <vector>
#include <climits>
using namespace std;
class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int max = INT_MIN;
        for(int i = 0; i < piles.size(); i++){
            if(max < piles[i]) max = piles[i];
        }
        int left = 1, right = max;
        int ans = INT_MAX;
        while(left < right){
            int mid = left + (right - left)/2;
            int calc = 0;
            for (int pile : piles) {
                calc += (pile + mid - 1) / mid;
            }
            if(calc <= h){
                ans = mid;
                right = mid;
            }
            else if(calc > h){
                left = mid + 1;
            }
        }
        if(ans == INT_MAX) return left;
        return ans;
    }
};