class Solution {
    class DSU {
    public:
        vector<int> parent;
        vector<int> rank;
        DSU(int n) : parent(n), rank(n, 0) {
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int n) {
            if (parent[n] != n) parent[n] = find(parent[n]);
            return parent[n];
        }

        bool unionSets(int u, int v) {
            int p1 = find(u);
            int p2 = find(v);

            if (p1 == p2) return false;
            if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
            }
            else if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            }
            else {
                rank[p1]++;
                parent[p2] = p1;
            }
            return true;
        }
    };

public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        DSU dsu(accounts.size());
        unordered_map<string, int> emailToIndex;

        for (int i = 0; i < (int)accounts.size(); i++) {
            bool isName = true;
            for (const string& email : accounts[i]) {
                if (isName) {
                    isName = false;
                    continue;
                }
                if (emailToIndex.count(email)) {
                    dsu.unionSets(emailToIndex[email], i);
                }
                else {
                    emailToIndex[email] = i;
                }
            }
        }

        unordered_map<int, vector<string>> indexHm;
        vector<vector<string>> ans;

        for (const auto& ele : emailToIndex) {
            int index = ele.second;
            const string& email = ele.first;
            int parent = dsu.find(index);
            indexHm[parent].push_back(email);
        }

        for (auto& ele : indexHm) {
            vector<string> curr;
            curr.push_back(accounts[ele.first][0]);
            sort(ele.second.begin(), ele.second.end());
            for (const string& str : ele.second) curr.push_back(str);
            ans.push_back(curr);
        }

        return ans;
    }
};

