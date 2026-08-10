class Solution {
public:
    long long weightedSum(vector<int>& parent, vector<int>& nums) {
        unordered_map<int, vector<int>> adj;

        for (int i = 1; i < parent.size(); i++) {
            vector<int> temp = adj.count(parent[i]) ? adj[parent[i]] : vector<int>();
            temp.push_back(i);
            adj[parent[i]] = temp;
        }

        long long h = 0;
        queue<int> q;
        q.push(0);

        long long ans = 0;
        while (!q.empty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int node = q.front();
                q.pop();

                if (!adj.count(node))
                    continue;

                for (int neig : adj[node])
                    q.push(neig);
            }

            h++;
        }

        long long d = 1;
        q.push(0);

        while (!q.empty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int node = q.front();
                q.pop();

                ans += (long long)(nums[node] * (h - d + 1));

                if (!adj.count(node))
                    continue;

                for (int neig : adj[node])
                    q.push(neig);
            }

            d++;
        }

        return ans;
    }
};