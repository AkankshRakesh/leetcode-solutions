class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node){
            if(parent[node] != node) return find(parent[node]);
            return node;
        }

        public void union(int n1, int n2){
            int p1 = find(n1);
            int p2 = find(n2);
            if(p1 == p2) return;

            if(rank[p1] > rank[p2]) parent[p2] = p1;
            else if(rank[p1] < rank[p2]) parent[p1] = p2;
            else{
                parent[p2] = p1;
                p1++;
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.offer(new int[]{i, j, dist});
            }
        }

        int cost = 0;
        DSU dsu = new DSU(points.length);
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int u = edge[0];
            int v = edge[1];
            int edgeCost = edge[2];
            if(dsu.find(u) != dsu.find(v)){
                dsu.union(u, v);
                cost += edgeCost;
            }
        }

        return cost;
    }
}