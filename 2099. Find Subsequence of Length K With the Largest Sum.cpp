class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        priority_queue<int> pq;
        for (int num : nums) {
            pq.push(num);
        }

        vector<int> ansEle(k);
        int ind = 0;
        while (k != 0) {
            ansEle[ind++] = pq.top();
            pq.pop();
            k--;
        }

        vector<int> ans;
        for (int num : nums) {
            for (int i = 0; i < ansEle.size(); i++) {
                if (ansEle[i] == num) {
                    ans.push_back(num);
                    ansEle[i] = INT_MIN; // Mark as used
                    break;
                }
            }
        }

        return ans;
    }
};