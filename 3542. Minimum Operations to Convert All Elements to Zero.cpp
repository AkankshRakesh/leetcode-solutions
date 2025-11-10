class Solution {
public:
    int minOperations(vector<int>& nums) {
        stack<int> s;
        int res = 0;
        for (int a : nums) {
            while (!s.empty() && s.top() > a)
                s.pop();
            if (a == 0) continue;
            if (s.empty() || s.top() < a) {
                res++;
                s.push(a);
            }
        }
        return res;
    }
};
