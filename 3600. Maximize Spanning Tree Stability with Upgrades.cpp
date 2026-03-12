class Solution {

    public class DSU {
        public int parent[];
        public int rank[];

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        public DSU(int[] p) {
            parent = p.clone();
            rank = new int[p.length];
        }

        public int find(int i) {
            if (parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }

        public boolean union(int u, int v) {
            int p1 = find(u);
            int p2 = find(v);
            if (p1 == p2)
                return false;

            if (rank[p1] < rank[p2])
                parent[p1] = p2;
            else if (rank[p1] > rank[p2])
                parent[p2] = p1;
            else {
                parent[p2] = p1;
                rank[p1]++;
            }
            return true;
        }
    }

    int[] initParent;
    int selectedInit;

    public boolean check(int n, List<int[]> optionalEdges, int k, int target) {
        DSU dsu = new DSU(initParent);
        int used = selectedInit;

        for (int[] e : optionalEdges) {
            int u = e[0];
            int v = e[1];
            int s = e[2];

            if (dsu.find(u) == dsu.find(v))
                continue;

            if (s >= target) {
                dsu.union(u, v);
                used++;
            } else if (k > 0 && s * 2 >= target) {
                dsu.union(u, v);
                used++;
                k--;
            } else
                break;

            if (used == n - 1)
                return true;
        }

        return false;
    }

    public int maxStability(int n, int[][] edges, int k) {

        List<int[]> mustEdges = new ArrayList<>();
        List<int[]> optionalEdges = new ArrayList<>();

        for (int[] e : edges) {
            if (e[3] == 1)
                mustEdges.add(e);
            else
                optionalEdges.add(e);
        }

        optionalEdges.sort((a, b) -> b[2] - a[2]);

        initParent = new int[n];
        for (int i = 0; i < n; i++)
            initParent[i] = i;

        DSU dsuInit = new DSU(initParent);

        selectedInit = 0;
        int mustMin = Integer.MAX_VALUE;

        for (int[] e : mustEdges) {
            int u = e[0], v = e[1], s = e[2];

            if (!dsuInit.union(u, v))
                return -1;

            selectedInit++;
            mustMin = Math.min(mustMin, s);
        }

        if (selectedInit == n - 1) {
            return mustMin;
        }

        initParent = dsuInit.parent;

        int left = 0, right = mustMin;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(n, optionalEdges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return ans;
    }
}