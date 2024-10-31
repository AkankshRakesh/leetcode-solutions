#include <queue>
#include <vector>
using namespace std;
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq;
        for(int i = 0; i < nums.size(); i++){
            pq.push(nums[i]);
        }
        k--;
        while(k){
            pq.pop();
            k--;
        }
        return pq.top();
    }
};