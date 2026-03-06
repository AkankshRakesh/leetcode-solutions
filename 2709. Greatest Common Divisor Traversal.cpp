class Solution {
    class DSU {
    public:
        vector<int> parent;
        vector<int> rank;

        DSU(int n) : parent(n), rank(n, 0) {
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        bool unionSets(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) return false;
            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            } else if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
            } else {
                parent[p2] = p1;
                rank[p1]++;
            }

            return true;
        }
    };

public:
    bool canTraverseAllPairs(const vector<int>& nums) {
        int maxVal = nums[0];
        unordered_set<int> numbers;
        bool allOne = true;
        for (int num : nums) {
            if (num != 1) allOne = false;
            numbers.insert(num);
            maxVal = max(maxVal, num);
        }
        if (allOne && nums.size() > 1) return false;

        vector<bool> isPrime(maxVal + 1, true);
        unordered_map<int, vector<int>> adj;

        for (int i = 2; i <= maxVal; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= maxVal; j += i) {
                    if (numbers.find(j) == numbers.end()) continue;
                    adj[j].push_back(i);
                    isPrime[j] = false;
                }
            }
        }

        DSU dsu(maxVal + 1);
        for (const auto& ele : adj) {
            int node = ele.first;
            for (int factor : ele.second) {
                dsu.unionSets(node, factor);
            }
        }

        int parent = dsu.find(nums[0]);
        for (int num : nums) {
            if (parent != dsu.find(num)) return false;
        }

        return true;
    }
};