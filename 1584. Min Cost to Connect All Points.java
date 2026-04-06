class Solution {
    class DSU{
        int[] parent;
        int[] size;
        public DSU(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
            Arrays.fill(size, 1);
        }

        public int find(int node){
            if(parent[node] != node) return find(parent[node]);
            return node;
        }

        public void union(int n1, int n2){
            int p1 = find(n1);
            int p2 = find(n2);
            if(p1 == p2) return;

            if(size[p1] > size[p2]){
                size[p1] += size[p2];
                parent[p2] = p1; 
            }
            else{
                size[p2] += size[p1];
                parent[p1] = p2;
            }
        }

        public int getSize(int n){
            return size[find(n)];
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int cost = 0;
        ArrayList<int[]> edges = new ArrayList<>();
        int n = points.length;
        DSU dsu = new DSU(n);

        for(int i = 0; i < n; i++){
            int[] pointsA = points[i];
            for(int j = i + 1; j < n; j++){
                int[] pointsB = points[j];
                edges.add(new int[]{i, j, Math.abs(pointsA[0] - pointsB[0]) + Math.abs(pointsA[1] - pointsB[1])});
            }
        }

        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(dsu.find(u) == dsu.find(v)) continue;
            dsu.union(u, v);
            cost += edge[2];
            if(dsu.getSize(u) == n) return cost;
        }

        return 0;
    }
}