#include <vector>
using namespace std;

class Solution {
public:
    void recursion(vector<int>& nums, vector<bool>& visited, vector<int>& curr, vector<vector<int>>& ans, int n) {
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            curr.push_back(nums[i]);
            visited[i] = true;
            recursion(nums, visited, curr, ans, n);
            curr.pop_back();
            visited[i] = false;
        }
        if(curr.size() != n) return;
        ans.push_back(curr);
    }

    vector<vector<int>> permute(vector<int>& nums) {
        int n = nums.size();
        vector<bool> visited(n, false);
        vector<vector<int>> ans;
        vector<int> temp;

        for(int i = 0; i < n; i++) {
            visited[i] = true;
            temp.push_back(nums[i]);
            recursion(nums, visited, temp, ans, n);
            temp.pop_back();
            visited[i] = false;
        }

        return ans;
    }
};
