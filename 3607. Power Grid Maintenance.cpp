class Solution {
public:
    vector<int> rankArr, parent, minNode;
    vector<bool> online;

    int find(int i) {
        if (parent[i] != i)
            parent[i] = find(parent[i]);
        return parent[i];
    }

    void unionSets(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot) return;

        if (rankArr[xRoot] < rankArr[yRoot]) {
            parent[xRoot] = yRoot;
            minNode[yRoot] = min(minNode[yRoot], minNode[xRoot]);
        } 
        else if (rankArr[yRoot] < rankArr[xRoot]) {
            parent[yRoot] = xRoot;
            minNode[xRoot] = min(minNode[xRoot], minNode[yRoot]);
        } 
        else {
            parent[yRoot] = xRoot;
            rankArr[xRoot]++;
            minNode[xRoot] = min(minNode[xRoot], minNode[yRoot]);
        }
    }

    vector<int> processQueries(int c, vector<vector<int>>& connections, vector<vector<int>>& queries) {
        rankArr.assign(c + 1, 0);
        parent.resize(c + 1);
        minNode.resize(c + 1);
        online.assign(c + 1, true);

        for (int i = 1; i <= c; i++) {
            parent[i] = i;
            minNode[i] = i;
        }

        for (auto& con : connections)
            unionSets(con[0], con[1]);

        unordered_map<int, priority_queue<int, vector<int>, greater<int>>> roots;

        for (int i = 1; i <= c; i++) {
            int root = find(i);
            roots[root].push(i);
        }

        vector<int> result;

        for (auto& query : queries) {
            int opt = query[0];
            int station = query[1];

            if (opt == 1) { 
                if (online[station]) {
                    result.push_back(station);
                    continue;
                }

                int root = find(station);
                auto& heap = roots[root];

                while (!heap.empty() && !online[heap.top()])
                    heap.pop();

                if (!heap.empty())
                    result.push_back(heap.top());
                else
                    result.push_back(-1);
            } 
            else if (opt == 2) { 
                online[station] = false;
            }
        }

        return result;
    }
};
