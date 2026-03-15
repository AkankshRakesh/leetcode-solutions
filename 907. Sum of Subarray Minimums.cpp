class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        int n = arr.size();
        vector<long long> prevSmallest(n);
        vector<long long> nextSmallest(n);
        stack<pair<int, int>> st;

        for (int i = 0; i < n; i++) {
            while (!st.empty() && st.top().first > arr[i]) st.pop();
            if (st.empty()) prevSmallest[i] = -1;
            else prevSmallest[i] = st.top().second;

            st.push({arr[i], i});
        }
        while (!st.empty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && st.top().first >= arr[i]) st.pop();
            if (st.empty()) nextSmallest[i] = n;
            else nextSmallest[i] = st.top().second;

            st.push({arr[i], i});
        }

        long long ans = 0;
        int MOD = 1'000'000'007;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long long)arr[i] * ((i - prevSmallest[i]) * (nextSmallest[i] - i) % MOD)) % MOD;
        }

        return (int)ans;
    }
};