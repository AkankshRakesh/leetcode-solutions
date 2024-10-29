#include <queue>
#include <vector>
#include <climits>
using namespace std;
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int min = INT_MAX, max = INT_MIN;
        priority_queue<int> pq;
        for(int i = 0; i < prices.size(); i++){
            if(min > prices[i]){
                if(max != INT_MIN && min != INT_MAX) pq.push(max - min);
                min = prices[i];
                max = prices[i];
            }
            if(max < prices[i]) max = prices[i];
        }
        if(max != INT_MIN && min != INT_MAX) pq.push(max - min);
        return pq.top();
    }
};