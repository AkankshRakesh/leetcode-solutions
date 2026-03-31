class Solution {
public:
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

        bool unionSet(int x, int y) {
            int p1 = find(x);
            int p2 = find(y);
            if (p1 == p2) return false;
            if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
            }
            else if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            }
            else {
                parent[p2] = p1;
                rank[p1]++;
            }
            return true;
        }
    };

    int largestComponentSize(vector<int>& nums) {
        int maxVal = *max_element(nums.begin(), nums.end());

        DSU dsu(maxVal + 1);
        unordered_map<int, int> hm;
        int ans = 1;
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    dsu.unionSet(i, num);
                    dsu.unionSet(i, num / i);
                }
            }
        }
        for (int num : nums) {
            int parent = dsu.find(num);
            hm[parent]++;
            ans = max(ans, hm[parent]);
        }

        return ans;
    }
};

