#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int count(int n){
        int c = 0;
        while(n){
            n &= (n - 1);
            c++;
        }
        return c;
    }
    using int2 = pair<int, int>;
    bool canSortArray(vector<int>& nums) {
        int2 prev = {INT_MIN, INT_MIN}, curr;
        int n = nums.size();
        int prevBit = -1;
        for(int i = 0; i < n; i++){
            int x = nums[i];
            int b = count(x);
            if(prevBit != b){
                if(curr.first < prev.second) return false;
                prev = curr;
                curr = {x,x};
                prevBit = b;
            }
            else{
                curr.first = min(curr.first, x);
                curr.second = max(curr.second, x);
            }
        }
        return curr.first >= prev.second;
    }
};