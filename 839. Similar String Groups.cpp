class Solution {
    class DSU {
    public:
        vector<int> parent;
        vector<int> rank;

        DSU(int n) : parent(n), rank(n, 1) {
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int vertex) {
            if (parent[vertex] != vertex) {
                parent[vertex] = find(parent[vertex]);
            }
            return parent[vertex];
        }

        void unionSets(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) return;

            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            } else if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
            } else {
                parent[p1] = p2;
                rank[p2]++;
            }
        }
    };

public:
    bool isSimilar(const string& s1, const string& s2) {
        int count = 0;
        for (size_t i = 0; i < s1.size(); i++) {
            if (s1[i] != s2[i]) count++;
        }
        return count == 0 || count == 2;
    }

    int numSimilarGroups(vector<string>& strs) {
        unordered_map<string, int> hm;
        int index = 0;
        for (const auto& str : strs) {
            hm[str] = index++;
        }
        DSU dsu(strs.size());

        for (int i = 0; i < (int)strs.size(); i++) {
            for (int j = i + 1; j < (int)strs.size(); j++) {
                if (isSimilar(strs[i], strs[j])) {
                    dsu.unionSets(i, j);
                }
            }
        }

        unordered_set<int> hs;
        for (int i = 0; i < (int)strs.size(); i++) {
            if (hm[strs[i]] == i) {
                hs.insert(dsu.find(i));
            }
        }

        return (int)hs.size();
    }
};

