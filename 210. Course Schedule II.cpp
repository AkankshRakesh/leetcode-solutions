class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& preReq) {
        unordered_map<int, vector<int>> adj;
        vector<int> inDeg(numCourses, 0);
        vector<int> res(numCourses);
        int index = 0;

        for (const auto& pair : preReq) {
            int u = pair[1];
            int v = pair[0];
            adj[u].push_back(v);
            inDeg[v]++;
        }

        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                q.push(i);
            }
        }

        while (!q.empty()) {
            int top = q.front();
            q.pop();

            if (index >= numCourses) return {};
            res[index++] = top;

            for (int nb : adj[top]) {
                inDeg[nb]--;
                if (inDeg[nb] == 0) q.push(nb);
            }
        }

        if (index != numCourses) return {};
        return res;
    }
};
