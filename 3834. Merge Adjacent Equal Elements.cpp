class Solution {
public:
    vector<long long> mergeAdjacent(const vector<int>& nums) {
        stack<long long> st;
        for (int num : nums) {
            long long curr = num;
            while (!st.empty() && st.top() == curr) {
                curr += st.top();
                st.pop();
            }
            st.push(curr);
        }

        vector<long long> arr;
        while (!st.empty()) {
            arr.push_back(st.top());
            st.pop();
        }
        reverse(arr.begin(), arr.end());

        return arr;
    }
};