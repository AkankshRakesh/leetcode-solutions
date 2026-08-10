class Solution {
public:
    long long weightedSum(vector<int>& parent, vector<int>& nums) {
        int n = parent.size();

        vector<vector<int>> adj(n);

        for (int i = 1; i < n; i++) {
            adj[parent[i]].push_back(i);
        }

        int h = 0;
        queue<int> q;
        q.push(0);

        while (!q.empty()) {
            int sz = q.size();

            while (sz--) {
                int node = q.front();
                q.pop();

                for (int child : adj[node]) {
                    q.push(child);
                }
            }

            h++;
        }

        long long ans = 0;
        int depth = 0;

        q.push(0);

        while (!q.empty()) {
            int sz = q.size();

            while (sz--) {
                int node = q.front();
                q.pop();

                ans += 1LL * nums[node] * (h - depth);

                for (int child : adj[node]) {
                    q.push(child);
                }
            }

            depth++;
        }

        return ans;
    }
};